package fr.univnantes.termsuite.ui.parts;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.inject.Inject;

import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.core.di.annotations.Optional;
import org.eclipse.e4.core.di.extensions.Preference;
import org.eclipse.e4.ui.di.UIEventTopic;
import org.eclipse.e4.ui.model.application.ui.basic.MPart;
import org.eclipse.e4.ui.model.application.ui.menu.MToolItem;
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
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.GlyphMetrics;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;

import com.google.common.collect.Lists;
import com.google.common.primitives.Ints;

import eu.project.ttc.models.Term;
import eu.project.ttc.models.TermOccurrence;
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
	
	@Inject CorpusService corpusService;
	@Inject TermSuiteSelectionService tsSelectionService;

	private StyledText text;
	private FileInput<?> inputDocument;
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
	void updateTerm(@UIEventTopic(TermSuiteEvents.ACTIVE_TERM) Term term) {
		if(term != null) {
			setActiveTerm(term);
			text.redraw();
		}
	}

	private void setActiveTerm(Term term) {
		occurrences = Lists.newArrayList();
		for(TermOccurrence occ : term.getOccurrences()) {
			EDocument doc = corpusService.resolveEDocument(occ.getSourceDocument());
			if(doc.equals(this.inputDocument.getInputObject()))
				occurrences.add(occ);
		}
		Collections.sort(occurrences);
	}
	
	private void setActiveTermOccurrence(TermOccurrence occ) {
		EDocument doc = corpusService.resolveEDocument(occ.getSourceDocument());
		if(doc != null && doc.equals(this.inputDocument.getInputObject())) {
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
			@Preference(nodePath = TermSuiteUI.PLUGIN_ID, 
			  value = TermSuiteUIPreferences.WRAP_TEXT) 
			  boolean wrap,
			final Composite parent, 
			MPart part,
			EModelService modelService) {
		parent.setLayout(new FillLayout());
		text = new StyledText(parent, getTheStyle(wrap));
		
		MToolItem wrapButton = (MToolItem)modelService.find(TOOL_ITEM_WRAP_TEXT, part.getToolbar());
		wrapButton.setSelected(wrap);
		
		text.addLineStyleListener(lineStyleListener);
		text.addLineBackgroundListener(lineBackgroundListener);
		text.setWrapIndent(20);
	}

	private int getTheStyle(boolean wrap) {
		int style = SWT.READ_ONLY | SWT.V_SCROLL | SWT.MULTI;
		if(wrap)
			style |= SWT.WRAP;
		return style;
	}
	
	
	@Inject @Optional
	private void init(@UIEventTopic(TermSuiteEvents.EDITOR_INITIATED) Object part, 
			CorpusService corpusService, 
			IEclipseContext context) {
		if(this == part) {
			inputDocument = (FileInput<?>)context.get(TermSuiteUI.INPUT_OBJECT);
			if(tsSelectionService.getActiveTerm() != null)
				setActiveTerm(tsSelectionService.getActiveTerm());
			if(tsSelectionService.getActiveTermOccurrence() != null)
				setActiveTermOccurrence(tsSelectionService.getActiveTermOccurrence());


			File asFile = inputDocument.asFile();
			try {
				Scanner scanner = new Scanner(asFile);
				this.textAsString = scanner.useDelimiter("\\A").next();
				text.setText(textAsString);
				scanner.close();
			} catch (FileNotFoundException e) {
			    MessageDialog.openError(text.getShell(), "Error opening file", "File " + asFile.getAbsolutePath() + " could not be opened." );
			}
			

		}
	}

	public void wrap(boolean wrap) {
		text.setWordWrap(wrap);
	}
}
