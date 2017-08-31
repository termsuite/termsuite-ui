package fr.univnantes.termsuite.ui.parts;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.inject.Inject;
import javax.inject.Named;

import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.core.di.annotations.Optional;
import org.eclipse.e4.core.di.extensions.Preference;
import org.eclipse.e4.core.services.log.ILoggerProvider;
import org.eclipse.e4.core.services.log.Logger;
import org.eclipse.e4.ui.di.Persist;
import org.eclipse.e4.ui.di.UIEventTopic;
import org.eclipse.e4.ui.model.application.ui.MDirtyable;
import org.eclipse.e4.ui.model.application.ui.basic.MPart;
import org.eclipse.e4.ui.model.application.ui.menu.MToolItem;
import org.eclipse.e4.ui.services.IServiceConstants;
import org.eclipse.e4.ui.workbench.modeling.EModelService;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.Bullet;
import org.eclipse.swt.custom.LineBackgroundListener;
import org.eclipse.swt.custom.LineStyleEvent;
import org.eclipse.swt.custom.LineStyleListener;
import org.eclipse.swt.custom.ST;
import org.eclipse.swt.custom.StyleRange;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.GlyphMetrics;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

import com.google.common.collect.Lists;
import com.google.common.primitives.Ints;

import fr.univnantes.termsuite.framework.service.TermService;
import fr.univnantes.termsuite.model.TermOccurrence;
import fr.univnantes.termsuite.ui.TermSuiteEvents;
import fr.univnantes.termsuite.ui.TermSuiteUI;
import fr.univnantes.termsuite.ui.TermSuiteUIPreferences;
import fr.univnantes.termsuite.ui.model.termsuiteui.EDocument;
import fr.univnantes.termsuite.ui.services.CorpusService;
import fr.univnantes.termsuite.ui.services.TermSuiteSelectionService;

@SuppressWarnings("restriction")
public class FileEditorPart {
	public static final String ID =	"fr.univnantes.termsuite.ui.partdescriptor.fileeditor";
	public static final String TOOL_ITEM_WRAP_TEXT = "fr.univnantes.termsuite.ui.handledtoolitem.WrapText";
	
	private static final Color COLOR_GRAY = new Color(Display.getDefault(), 180,180,180);
	private static final Color COLOR_LIGHT_GRAY = new Color(Display.getDefault(), 210,210,210);
	private static final Color COLOR_CYAN = new Color(Display.getDefault(), 50, 200, 255);
	
	private Logger logger;

	@Inject CorpusService corpusService;
	@Inject TermSuiteSelectionService tsSelectionService;

	@Inject
	MDirtyable dirty;

	private StyledText text;
	private FileInput<?> fileInput;
	private String textAsString;
	private List<TermOccurrence> occurrences = Lists.newArrayList();
	private TermOccurrence activeOccurrence = null;

	private LineBackgroundListener lineBackgroundListener = new LineBackgroundListener() {
		public void lineGetBackground(org.eclipse.swt.custom.LineBackgroundEvent e) {
			int lineStart = e.lineOffset;
			int lineEnd = lineStart + e.lineText.length();
			TermOccurrence occ = FileEditorPart.this.activeOccurrence;
			if(occ != null && (occ.getBegin() < lineEnd && occ.getEnd() > lineStart)) {
				e.lineBackground = COLOR_LIGHT_GRAY;
			}
		};
	};

	private LineStyleListener lineStyleListener = new LineStyleListener() {
		public void lineGetStyle(LineStyleEvent e) {
			int lineStart = e.lineOffset;
			int lineEnd = lineStart + e.lineText.length();
			// Set the line number
			e.bulletIndex = text.getLineAtOffset(lineStart);
			
			// Set the style, 12 pixels wide for each digit
			StyleRange style = new StyleRange();
			style.foreground = new Color(text.getDisplay(), 120, 120, 120);
			style.fontStyle = SWT.ITALIC;
			style.metrics = new GlyphMetrics(0, 0, Integer.toString(text.getLineCount() + 1).length() * 12);
			// Create and set the bullet
			e.bullet = new Bullet(ST.BULLET_NUMBER, style);
			
			List<StyleRange> ranges = Lists.newArrayList();
			for(TermOccurrence occ:FileEditorPart.this.occurrences) {
				if((occ.getBegin() < lineEnd && occ.getEnd() > lineStart)) {
					int styleStart = Ints.max(occ.getBegin(), lineStart);
					int styleEnd = Ints.min(occ.getEnd(), lineEnd);
					int overlap = styleEnd - styleStart;
					StyleRange styleRange = new StyleRange();
					styleRange.start = styleStart;
					styleRange.length =  overlap;
					if(occ.equals(activeOccurrence)) {
						styleRange.fontStyle = SWT.BOLD | SWT.ITALIC;
						styleRange.background = COLOR_CYAN;
					} else {
						styleRange.background = COLOR_GRAY;						
					}
						
					ranges.add(styleRange);
				}
			}
			e.styles = ranges.toArray(new StyleRange[ranges.size()]);
		}
	};

	@Inject @Optional
	void updateTerm(@UIEventTopic(TermSuiteEvents.ACTIVE_TERM) TermService term) {
		if(term != null) {
			setActiveTerm(term);
			text.redraw();
		}
	}

	private void setActiveTerm(TermService term) {
		occurrences = Lists.newArrayList();
		for(TermOccurrence occ : term.getOccurrences()) {
			EDocument doc = corpusService.resolveEDocument(occ.getSourceDocument());
			if(doc.equals(this.fileInput.getInputObject()))
				occurrences.add(occ);
		}
		Collections.sort(occurrences);
	}
	
	private void setActiveTermOccurrence(TermOccurrence occ) {
		EDocument doc = corpusService.resolveEDocument(occ.getSourceDocument());
		if(doc != null && doc.equals(this.fileInput.getInputObject())) {
			this.activeOccurrence = occ;
			if(!occurrences.contains(occ)) {
				occurrences.add(occ);
				Collections.sort(occurrences);
			}
			recenter(occ);
		}
	}
	
	@Inject @Optional
	void updateTermOccurrence(@UIEventTopic(TermSuiteEvents.ACTIVE_TERM_OCCURRENCE) TermOccurrence occ) {
		if(occ != null) {
			setActiveTermOccurrence(occ);
			text.redraw();
		}
	}
	
	private void recenter(TermOccurrence occ) {
		text.setSelection(occ.getBegin());

		int topOffset = -1;
		int areaHeight= text.getClientArea().height;
		topOffset = text.getBaseline(text.getCaretOffset()) - areaHeight/2;
		if (topOffset >= 0) {
			text.setTopPixel(topOffset);
		}
	}
	@PreDestroy
	public void destroy() {
		if(!text.isDisposed())
			text.removeLineStyleListener(lineStyleListener);
	}

	@PostConstruct
	public void createControls(
			IEclipseContext context, 
			@Preference(nodePath = TermSuiteUI.PLUGIN_ID, value = TermSuiteUIPreferences.WRAP_TEXT) boolean wrap,
			final Composite parent, 
			MPart part,
			ILoggerProvider loggerProvider,
			EModelService modelService) {
		this.logger = loggerProvider.getClassLogger(this.getClass());

		parent.setLayout(new FillLayout());
		text = new StyledText(parent, getTheStyle(wrap, false));
		
		MToolItem wrapButton = (MToolItem)modelService.find(TOOL_ITEM_WRAP_TEXT, part.getToolbar());
		wrapButton.setSelected(wrap);
		
		text.addLineStyleListener(lineStyleListener);
		text.addLineBackgroundListener(lineBackgroundListener);
		text.setWrapIndent(20);
	}

	private int getTheStyle(boolean wrap, boolean editable) {
		int style = SWT.V_SCROLL | SWT.MULTI;
		if(!editable)
			style |= SWT.READ_ONLY; 
		if(wrap)
			style |= SWT.WRAP;
		return style;
	}
	
	
	@Inject @Optional
	private void init(@UIEventTopic(TermSuiteEvents.EDITOR_INITIATED) Object part, 
			CorpusService corpusService,
			@Named(TermSuiteUI.EDITABLE) boolean editable,
			IEclipseContext context) {
		if(this == part) {
			fileInput = (FileInput<?>)context.get(TermSuiteUI.INPUT_OBJECT);
			if(tsSelectionService.getActiveTerm() != null)
				setActiveTerm(tsSelectionService.getActiveTerm());
			if(tsSelectionService.getActiveTermOccurrence() != null)
				setActiveTermOccurrence(tsSelectionService.getActiveTermOccurrence());


			File asFile = fileInput.getFile();
			
			try {
				Scanner scanner = new Scanner(asFile, "UTF-8");
				this.textAsString = scanner.useDelimiter("\\A").next();
				text.setText(textAsString);
				text.setEditable(editable);
				if(editable) {
					text.addModifyListener(new ModifyListener() {
						@Override
						public void modifyText(ModifyEvent e) {
							dirty.setDirty(true);
						}
					});
				}
				scanner.close();
			} catch (FileNotFoundException e) {
				logger.error(e);
			    MessageDialog.openError(text.getShell(), "Error opening file", "File " + asFile.getAbsolutePath() + " could not be opened." );
			}
			

		}
	}

	public void wrap(boolean wrap) {
		text.setWordWrap(wrap);
	}
	
	
	@Persist
	public void save(MDirtyable dirty,
			@Named(IServiceConstants.ACTIVE_SHELL) Shell shell) {
		String absolutePath = this.fileInput.getFile().getAbsolutePath();
		logger.debug("Saving " + absolutePath);

		try {
			fileInput.save(this.text.getText());
			
			// save was successful
			dirty.setDirty(false);
		} catch (IOException e) {
			logger.error(e);
			MessageDialog.openError(shell, "Save error", e.getMessage());
		}
	}

}
