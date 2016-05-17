package fr.univnantes.termsuite.ui.parts;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;

import org.eclipse.core.commands.ParameterizedCommand;
import org.eclipse.e4.core.commands.ECommandService;
import org.eclipse.e4.core.commands.EHandlerService;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.core.di.annotations.Optional;
import org.eclipse.e4.core.services.log.ILoggerProvider;
import org.eclipse.e4.core.services.log.Logger;
import org.eclipse.e4.ui.di.UIEventTopic;
import org.eclipse.e4.ui.model.application.ui.basic.MPart;
import org.eclipse.e4.ui.services.IServiceConstants;
import org.eclipse.e4.ui.workbench.modeling.EPartService;
import org.eclipse.e4.ui.workbench.modeling.ESelectionService;
import org.eclipse.e4.ui.workbench.modeling.IPartListener;
import org.eclipse.jface.viewers.DelegatingStyledCellLabelProvider;
import org.eclipse.jface.viewers.DelegatingStyledCellLabelProvider.IStyledLabelProvider;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.ITreeSelection;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.StyledString;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;

import com.google.common.base.Objects;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import eu.project.ttc.models.Term;
import eu.project.ttc.models.TermOccurrence;
import eu.project.ttc.models.TermVariation;
import fr.univnantes.termsuite.ui.TermOccurrenceContainer;
import fr.univnantes.termsuite.ui.TermSuiteEvents;
import fr.univnantes.termsuite.ui.TermSuiteUI;
import fr.univnantes.termsuite.ui.handlers.OpenObjectHandler;
import fr.univnantes.termsuite.ui.model.termsuiteui.EDocument;
import fr.univnantes.termsuite.ui.services.CorpusService;
import fr.univnantes.termsuite.ui.services.ResourceService;
import fr.univnantes.termsuite.ui.services.TermSuiteSelectionService;
import fr.univnantes.termsuite.ui.util.CommandUtil;
import fr.univnantes.termsuite.ui.util.E4PartListener;
import fr.univnantes.termsuite.ui.util.StringUtil;
import fr.univnantes.termsuite.ui.util.TermOccurrenceUtil;
import fr.univnantes.termsuite.ui.util.jface.ExpandCollapseDoubleClickListener;
import fr.univnantes.termsuite.ui.util.treeviewer.TreePart;

@SuppressWarnings("restriction")
public class OccurrencePart implements TreePart {
	public static final String ID = "fr.univnantes.termsuite.ui.part.occurrences";

	public static final int OCCURRENCE_CONTEXT_SIZE = 25;

	private TermsuiteImg img = TermsuiteImg.INSTANCE;

	@Inject CorpusService corpusService;
	@Inject ECommandService commandService;
	@Inject EHandlerService handlerService;
	@Inject ResourceService resourceService;
	@Inject EPartService partService;
	@Inject ESelectionService selectionService;
	@Inject TermSuiteSelectionService termSuiteSelectionService;

	private Logger logger;

	
	private LinkedHashMap<TermOccurrence, TermOccurrenceContainer<EDocument>> documentContainersMap = Maps.newLinkedHashMap();
	private List<TermOccurrence> occurrencesList = Lists.newArrayList();
	private List<TermOccurrenceContainer<EDocument>> documentContainers = Lists.newArrayList();

	private IPartListener partListener = new E4PartListener() {
		
		@Override
		public void partBroughtToTop(MPart part) {
			if(part != null && part.getObject() instanceof FileEditorPart) {
				FileInput<?> fileInput = (FileInput<?>)part.getContext().get(TermSuiteUI.INPUT_OBJECT);
				if(fileInput != null && fileInput.getInputObject() instanceof EDocument) {
					EDocument doc  = (EDocument) fileInput.getInputObject();
					if(doc == null) {
						logger.warn("Input Object for FileEditorPart " + part.getLabel() + " is null");
						return;
					}
						
					for(TermOccurrenceContainer<EDocument> toc:documentContainers) {
						if(Objects.equal(toc.getContainer(), doc) && !toc.getOccurrences().isEmpty()) {
							navigateToOccurrence(toc.getOccurrences().iterator().next());
							break;
						}
					}
				}
			}
		}
	};

	@Inject @Optional
	private void nextHandler(@UIEventTopic(TermSuiteEvents.NEXT_OCCURRENCE) Object part) {
		if(part == this)
			navigate(true);
	}
	
	@Inject @Optional
	private void previousHandler(@UIEventTopic(TermSuiteEvents.PREVIOUS_OCCURRENCE) Object part) {
		if(part == this) 
			navigate(false);
	}

	
	/*
	 * 
	 */
	private TermOccurrence getSelectedOccurrence() {
		ITreeSelection sel = viewer.getStructuredSelection();
		return sel.isEmpty() || sel.size() > 1 || !(sel.getFirstElement() instanceof TermOccurrence) ? 
				null :
					(TermOccurrence) sel.getFirstElement();
	}


	/*
	 * Set the viewer selection to the next/previous occurrence
	 */
	private void navigate(boolean forward) {
		if(!occurrencesList.isEmpty()) {
			TermOccurrence selected = getSelectedOccurrence();
			int index = 0;
			
			if(selected != null) {
				index = occurrencesList.indexOf(selected);
				if(index == occurrencesList.size() - 1 && forward)
					index = 0;
				else if(index == 0 && !forward)
					index = occurrencesList.size() - 1;
				else 
					index = index + (forward ? 1 : -1);
			}
			TermOccurrence occ = occurrencesList.get(index);
			navigateToOccurrence(occ);
		}
	}

	private void navigateToOccurrence(TermOccurrence occ) {
		viewer.setExpandedState(documentContainersMap.get(occ), true);
		viewer.setSelection(new StructuredSelection(occ), false);
		viewer.reveal(occ);
		showOccurrenceInDocument(occ);
	}


	
	@Inject
	void updateOccurrences(@Optional @Named(IServiceConstants.ACTIVE_SELECTION) Object object) {
		Collection<TermOccurrence> occurrences = null;
		if(viewer != null && object != null) {
			if(object instanceof TermOccurrenceContainer) {
				occurrences = ((TermOccurrenceContainer<?>)object).getOccurrences();
			} else if (object instanceof Term) {
				occurrences = ((Term)object).getOccurrences();
			} else if (object instanceof TermVariation) {
				TermVariation sv = (TermVariation)object;
				occurrences = sv.getVariant().getOccurrences();
			} else
				return;
			documentContainers = TermOccurrenceUtil.toDocumentContainers(occurrences, corpusService);
			occurrencesList = Lists.newArrayList();
			documentContainersMap = Maps.newLinkedHashMap();
			for(TermOccurrenceContainer<EDocument> c:documentContainers) 
				for(TermOccurrence o:c.getOccurrences()) {
					this.documentContainersMap.put(o, c);
					this.occurrencesList.add(o);
				}
			Collections.sort(documentContainers, new Comparator<TermOccurrenceContainer<EDocument>>() {
					@Override
					public int compare(TermOccurrenceContainer<EDocument> e1, TermOccurrenceContainer<EDocument> e2) {
						return TermSuiteUI.DOCUMENT_COMPARATOR.compare(
								e1.getContainer(), 
								e2.getContainer());
					}
			});
			viewer.setInput(documentContainers);
			viewer.collapseAll();
			if(!documentContainers.isEmpty() && !documentContainers.get(0).getOccurrences().isEmpty()) {
				viewer.setExpandedState(documentContainers.get(0), true);
				viewer.getTree().setTopItem(viewer.getTree().getItem(0));
			}
		}
	}


	private TreeViewer viewer;

	@PostConstruct
	public void createControls(ILoggerProvider loggerProvider, IEclipseContext context, final Composite parent, MPart part) {
		
		this.logger = loggerProvider.getClassLogger(this.getClass());
		
		
		viewer = new TreeViewer(parent, SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL);
		context.set(TreeViewer.class, viewer);
		
		viewer.getTree().setLinesVisible(true);
		viewer.setContentProvider(new OccurrenceContentProvider());
		
		viewer.setLabelProvider(new DelegatingStyledCellLabelProvider(new OccurrenceViewLabelProvider()));
		viewer.addDoubleClickListener(new ExpandCollapseDoubleClickListener(viewer));
		viewer.addDoubleClickListener(new IDoubleClickListener() {
			@Override
			public void doubleClick(DoubleClickEvent event) {
				final IStructuredSelection selection = (IStructuredSelection) event.getSelection();
				if (selection == null || selection.isEmpty())
					return;
				final Object sel = selection.getFirstElement();
				if(sel instanceof TermOccurrence) {
					TermOccurrence occ = (TermOccurrence) sel;
					showOccurrenceInDocument(occ);
//					selectionService.setSelection(occ);
//					termSuiteSelectionService.setActiveOccurrence(occ);
				}
			}
		});
		
		viewer.addSelectionChangedListener(new ISelectionChangedListener() {
			public void selectionChanged(SelectionChangedEvent event) {
				IStructuredSelection selection = (IStructuredSelection) event.getSelection();
				// set the selection to the service
				if (selection.size() == 1 && selection.getFirstElement() instanceof TermOccurrence) {
//					selectionService.setSelection(selection.getFirstElement());
					termSuiteSelectionService.setActiveOccurrence((TermOccurrence)selection.getFirstElement());
				}
			}
		});


		partService.addPartListener(partListener);
	}

	

	private void showOccurrenceInDocument(TermOccurrence occ) {
		EDocument doc = corpusService.resolveEDocument(occ.getSourceDocument());
		String resourceId = resourceService.getResourceId(doc);
		ParameterizedCommand command = commandService.createCommand(
				OpenObjectHandler.COMMAND_ID, 
				CommandUtil.params(OpenObjectHandler.PARAM_INPUT_OBJECT_ID, resourceId));
		if(handlerService.canExecute(command))
			handlerService.executeHandler(command);
	}



	private final class OccurrenceContentProvider implements ITreeContentProvider {
		@Override
		public void dispose() {
		}

		@Override
		public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		}

		@Override
		public Object[] getElements(Object inputElement) {
			return ((Collection<?>) inputElement).toArray();
		}

		@Override
		public Object[] getChildren(Object parentElement) {
			if (parentElement instanceof TermOccurrenceContainer<?>) {
				TermOccurrenceContainer<?> container = (TermOccurrenceContainer<?>) parentElement;
				return container.getOccurrences().toArray();
			}
			return null;
		}

		@Override
		public Object getParent(Object element) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public boolean hasChildren(Object element) {
			if (element instanceof TermOccurrenceContainer<?>) {
				return true;
			} else
				return false;
		}
	}



	private class OccurrenceViewLabelProvider extends LabelProvider implements IStyledLabelProvider {
		@Override
		public StyledString getStyledText(Object element) {
			StyledString styledString = new StyledString();
			if (element instanceof TermOccurrenceContainer<?>) {
				TermOccurrenceContainer<?> container = (TermOccurrenceContainer<?>) element;
				if(container.getContainer() instanceof EDocument) {
					EDocument document = (EDocument)container.getContainer();
					styledString.append(document.getFilename());
					styledString.append(
							String.format(" (%d matches)", container.getOccurrences().size()),
							TermSuiteUI.STYLE_MATCHES
							);
					
				} else if(container.getContainer() instanceof String) {
					styledString.append((String)container.getContainer());
				}
			} else if(element instanceof TermOccurrence) {
				TermOccurrence occ = (TermOccurrence) element;
				EDocument doc = corpusService.resolveEDocument(occ.getSourceDocument());
				String lineNb = doc == null ? "??" : Integer.toString(corpusService.getLineNumber(doc, occ));
				styledString.append(
						"Line " + lineNb + ": ", 
						TermSuiteUI.STYLE_MATCHES);
				if(doc != null) {
					styledString.append(
							"..." + StringUtil.noLinebreak(corpusService.getDocumentExcerpt(doc, occ.getBegin() - OCCURRENCE_CONTEXT_SIZE, occ.getBegin())), 
							TermSuiteUI.STYLE_GRAYED);
					styledString.append(
							StringUtil.noLinebreak(corpusService.getDocumentExcerpt(doc, occ.getBegin(), occ.getEnd())), 
							TermSuiteUI.STYLE_GRAYED_BOLD);
					styledString.append(
							StringUtil.noLinebreak(corpusService.getDocumentExcerpt(doc, occ.getEnd(), occ.getEnd() + OCCURRENCE_CONTEXT_SIZE)) + "...", 
							TermSuiteUI.STYLE_GRAYED);
				}
			}
			return styledString;

		}
		@Override
		public Image getImage(Object element) {
			if (element instanceof TermOccurrenceContainer<?>) {
				TermOccurrenceContainer<?> container = (TermOccurrenceContainer<?>) element;
				if(container.getContainer() instanceof EDocument) {
					return img.get(TermsuiteImg.FILE);
				} else if(container.getContainer() instanceof String) {
					// term form
					return img.get(TermsuiteImg.TERM_FORM);						
				}
			} else if(element instanceof TermOccurrence)
				return img.get(TermsuiteImg.SEARCHM_OBJECT);						
			
			return null;
		}
		
	}



	@Override
	public TreeViewer getTreeViewer() {
		return viewer;
	}
}
