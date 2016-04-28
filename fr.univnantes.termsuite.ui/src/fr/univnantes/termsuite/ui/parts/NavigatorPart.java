package fr.univnantes.termsuite.ui.parts;

import java.io.File;
import java.util.Collections;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.eclipse.core.commands.ParameterizedCommand;
import org.eclipse.e4.core.commands.ECommandService;
import org.eclipse.e4.core.commands.EHandlerService;
import org.eclipse.e4.core.services.events.IEventBroker;
import org.eclipse.e4.ui.di.Focus;
import org.eclipse.e4.ui.model.application.ui.basic.MPart;
import org.eclipse.e4.ui.services.EMenuService;
import org.eclipse.e4.ui.workbench.modeling.ESelectionService;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StyledCellLabelProvider;
import org.eclipse.jface.viewers.StyledString;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerCell;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.osgi.service.event.Event;
import org.osgi.service.event.EventHandler;

import com.google.common.base.Joiner;
import com.google.common.collect.Lists;
import com.google.common.io.Files;

import fr.univnantes.termsuite.ui.TermSuiteEvents;
import fr.univnantes.termsuite.ui.TermSuiteUI;
import fr.univnantes.termsuite.ui.handlers.OpenResourceHandler;
import fr.univnantes.termsuite.ui.model.termsuiteui.ECorpus;
import fr.univnantes.termsuite.ui.model.termsuiteui.EDocument;
import fr.univnantes.termsuite.ui.model.termsuiteui.EPipeline;
import fr.univnantes.termsuite.ui.model.termsuiteui.EResource;
import fr.univnantes.termsuite.ui.model.termsuiteui.ESingleLanguageCorpus;
import fr.univnantes.termsuite.ui.model.termsuiteui.ETerminology;
import fr.univnantes.termsuite.ui.services.CorpusService;
import fr.univnantes.termsuite.ui.services.PipelineService;
import fr.univnantes.termsuite.ui.services.ResourceService;
import fr.univnantes.termsuite.ui.util.CommandUtil;
import fr.univnantes.termsuite.ui.util.CustomTreeNode;
import fr.univnantes.termsuite.ui.util.CustomTreeNodeManager;
import fr.univnantes.termsuite.ui.util.LangUtil;
import fr.univnantes.termsuite.ui.util.jface.ExpandCollapseDoubleClickListener;
import fr.univnantes.termsuite.ui.util.treeviewer.TreePart;

@SuppressWarnings("restriction") 
public class NavigatorPart implements TreePart {

	public static final String ID = "fr.univnantes.termsuite.ui.part.navigator";
	public static final String POPUP_MENU_ID = "fr.univnantes.termsuite.ui.popupmenu.navigator";

	private static final int NODE_PIPELINES = 2;
	private static final int NODE_CORPORA = 3;
	private static final int NODE_FOLDER_TERMINO = 4;
	private static final int NODE_FOLDER_DOCUMENT = 5;
	
	private CustomTreeNodeManager nodeManager = new CustomTreeNodeManager();

	private final CustomTreeNode THE_CORPORA_NODE = nodeManager.get(null, NODE_CORPORA);
	private final CustomTreeNode THE_PIPELINE_NODE = nodeManager.get(null, NODE_PIPELINES);


	private TreeViewer viewer;
	private TermsuiteImg img = TermsuiteImg.INSTANCE;

	@Inject
	private CorpusService corpusService;

	@Inject
	private PipelineService pipelineService;

	@PostConstruct
	public void createControls(Composite parent,
			final ESelectionService selectionService,
			EMenuService menuService,
			IEventBroker eventBroker,
			MPart part,
			final ResourceService resourceService,
			final EHandlerService handlerService,
			final ECommandService commandService) {
		
		AdapterImpl refresher = new AdapterImpl(){
					@Override
					public void notifyChanged(Notification msg) {
						super.notifyChanged(msg);
						NavigatorPart.this.viewer.refresh();
					}
				};
		pipelineService.getPipelineList().eAdapters().add(refresher);
		corpusService.getCorporaList().eAdapters().add(refresher);
		
		viewer = new TreeViewer(parent, SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL);
		viewer.setContentProvider(new ViewContentProvider());
		viewer.setLabelProvider(new ViewLabelProvider());
		viewer.setInput(new Object[]{THE_CORPORA_NODE, THE_PIPELINE_NODE});
		IDoubleClickListener doubleClickHandler = new IDoubleClickListener() {
			@Override
			public void doubleClick(DoubleClickEvent event) {
				final IStructuredSelection selection = (IStructuredSelection)event.getSelection();
				if (selection == null || selection.isEmpty())
					return;
				final Object sel = selection.getFirstElement();
				if(sel instanceof EResource) {
					String resourceId = resourceService.getResourceId((EResource)sel);
					ParameterizedCommand command = commandService.createCommand(
							OpenResourceHandler.COMMAND_ID, 
							CommandUtil.params(OpenResourceHandler.PARAM_INPUT_OBJECT_ID, resourceId));
					if(handlerService.canExecute(command))
						handlerService.executeHandler(command);
					
				} 
			}
		};
		viewer.addDoubleClickListener(doubleClickHandler);
		viewer.addDoubleClickListener(new ExpandCollapseDoubleClickListener(viewer));
		viewer.addSelectionChangedListener(new ISelectionChangedListener() {
			@Override
			public void selectionChanged(SelectionChangedEvent event) {
				IStructuredSelection selection = (IStructuredSelection) viewer.getSelection();
				selectionService.setSelection(selection.getFirstElement());
			}
		});

		EventHandler updateHandler = new EventHandler(){
			@Override
			public void handleEvent(Event event) {
//				viewer.setInput(new Object[]{CustomNode.CORPORA, CustomNode.PIPELINES});
				viewer.refresh();
				Object data = event.getProperty(IEventBroker.DATA);
				if(event.getTopic().equals(TermSuiteEvents.NEW_TERMINOLOGY) && data instanceof ETerminology)
					viewer.reveal(data);
			}
		};
		eventBroker.subscribe(TermSuiteEvents.NEW_PIPELINE, updateHandler);
		eventBroker.subscribe(TermSuiteEvents.NEW_TERMINOLOGY, updateHandler);
		eventBroker.subscribe(TermSuiteEvents.PIPELINE_REMOVED, updateHandler);
		eventBroker.subscribe(TermSuiteEvents.TERMINOLOGY_REMOVED, updateHandler);
		eventBroker.subscribe(TermSuiteEvents.CORPUS_REMOVED, updateHandler);

		menuService.registerContextMenu(viewer.getControl(), POPUP_MENU_ID);
		
		revealTerminologies();
	}

	public void revealTerminologies() {
		for(ECorpus corpus:corpusService.getCorporaList().getCorpora())
			for(ESingleLanguageCorpus slc:corpus.getSingleLanguageCorpora())
				for(ETerminology termino:slc.getTerminologies())
					viewer.reveal(termino);
	}
	
	class ViewContentProvider implements ITreeContentProvider {
		public void inputChanged(Viewer v, Object oldInput, Object newInput) {
		}

		@Override
		public void dispose() {
		}

		@Override
		public Object[] getElements(Object inputElement) {
			return (Object[]) inputElement;
		}

		@Override
		public Object[] getChildren(Object parentElement) {
			if(parentElement instanceof CustomTreeNode) {
				CustomTreeNode node = (CustomTreeNode)parentElement;
				if(node.getNodeType() == NODE_CORPORA)
					return corpusService.getCorporaList().getCorpora().toArray();
				else if (node.getNodeType() == NODE_PIPELINES)
					return pipelineService.getPipelineList().getPipelines().toArray();
				else if (node.getNodeType() == NODE_FOLDER_TERMINO) {
					ESingleLanguageCorpus c = (ESingleLanguageCorpus)node.getParent();
					return c.getTerminologies().toArray();
				} else if (node.getNodeType() == NODE_FOLDER_DOCUMENT) {
					ESingleLanguageCorpus c = (ESingleLanguageCorpus)node.getParent();
					List<EDocument> documents = Lists.newArrayList(c.getDocuments());
					Collections.sort(documents, TermSuiteUI.DOCUMENT_COMPARATOR);
					return documents.toArray();
				}
			} else if (parentElement instanceof ECorpus) {
				ECorpus c = (ECorpus) parentElement;
				List<ESingleLanguageCorpus> slcList = Lists.newArrayList();
				for(ESingleLanguageCorpus slc:c.getSingleLanguageCorpora())
					if(corpusService.isLanguageSupported(slc.getLanguage()))
						slcList.add(slc);
				return slcList.toArray();
			} else if (parentElement instanceof ESingleLanguageCorpus) {
				ESingleLanguageCorpus c = (ESingleLanguageCorpus) parentElement;
				List<Object> children = Lists.newArrayList();
				if(!c.getTerminologies().isEmpty())
					children.add(nodeManager.get(c, NODE_FOLDER_TERMINO));
				if(!c.getDocuments().isEmpty())
					children.add(nodeManager.get(c, NODE_FOLDER_DOCUMENT));
				return children.toArray();
			}
			
			return null;
		}

		@Override
		public Object getParent(Object element) {
			
			if(element instanceof CustomTreeNode) {
				CustomTreeNode node = (CustomTreeNode)element;
				if (node.getNodeType() == NODE_FOLDER_TERMINO 
						|| node.getNodeType() == NODE_FOLDER_DOCUMENT ) 
					return node.getParent();
			} else if (element instanceof ESingleLanguageCorpus) {
				ESingleLanguageCorpus c = (ESingleLanguageCorpus) element;
				return c.getCorpus();
			} else if (element instanceof ECorpus) {
				return THE_CORPORA_NODE;
			} else if (element instanceof EPipeline) {
				return THE_PIPELINE_NODE;
			} else if (element instanceof EDocument) {
				ESingleLanguageCorpus singleLanguageCorpus = ((EDocument) element).getSingleLanguageCorpus();
				return nodeManager.get(singleLanguageCorpus, NODE_FOLDER_DOCUMENT);
			} else if (element instanceof ETerminology) {
				ESingleLanguageCorpus singleLanguageCorpus = ((ETerminology) element).getCorpus();
				return nodeManager.get(singleLanguageCorpus, NODE_FOLDER_TERMINO);
			}
			return null;
		}

		@Override
		public boolean hasChildren(Object element) {
			if(element instanceof CustomTreeNode) {
				CustomTreeNode node = (CustomTreeNode)element;
				if(node.getNodeType() == NODE_CORPORA)
					return !corpusService.getCorporaList().getCorpora().isEmpty();
				else if (node.getNodeType() == NODE_PIPELINES)
					return !pipelineService.getPipelineList().getPipelines().isEmpty();
				else if (node.getNodeType() == NODE_FOLDER_TERMINO) {
					ESingleLanguageCorpus c = (ESingleLanguageCorpus)node.getParent();
					return !c.getTerminologies().isEmpty();
				} else if (node.getNodeType() == NODE_FOLDER_DOCUMENT) {
						ESingleLanguageCorpus c = (ESingleLanguageCorpus)node.getParent();
						return !c.getDocuments().isEmpty();
				}
			} else if(element instanceof ECorpus)
				return true;
			else if(element instanceof ESingleLanguageCorpus)
				return true;
			return false;
		}
	}

	class ViewLabelProvider extends StyledCellLabelProvider {
		@Override
		public void update(ViewerCell cell) {
			Object element = cell.getElement();
			StyledString text = new StyledString();
			if(element instanceof CustomTreeNode) {
				CustomTreeNode node = (CustomTreeNode)element;
				if(node.getNodeType() == NODE_CORPORA) {
					text.append("Corpora");
					cell.setImage(img.get(TermsuiteImg.CORPORA));
				} else if (node.getNodeType() == NODE_PIPELINES) {
					text.append("Pipelines");
					cell.setImage(img.get(TermsuiteImg.PIPELINES));
				} else if (node.getNodeType() == NODE_FOLDER_TERMINO) {
					text.append("Terminologies");
					cell.setImage(img.get(TermsuiteImg.FOLDER_TERMINO));
				} else if (node.getNodeType() == NODE_FOLDER_DOCUMENT) {
					text.append("Documents");
					cell.setImage(img.get(TermsuiteImg.FOLDER_DOCUMENT));
				}
			} else if (cell.getElement() instanceof File) {
				File file = (File) element;
				if (file.isDirectory()) {
					text.append(getFileName(file));
					cell.setImage(img.get(TermsuiteImg.FOLDER));
					String[] files = file.list();
					if (files != null) {
						text.append(" (" + files.length + ") ", StyledString.COUNTER_STYLER);
					}
				} else {
					text.append(getFileName(file));
					cell.setImage(img.get(TermsuiteImg.FILE));
				}
			} else if (cell.getElement() instanceof EDocument) {
				text.append(((EDocument)cell.getElement()).getFilename());
				cell.setImage(img.get(TermsuiteImg.FILE));

			} else if (element instanceof ETerminology) {
				ETerminology terminology = (ETerminology)element;
				text.append(terminology.getName());
				
				List<String> attributes = Lists.newArrayList();
				if(terminology.isHasContexts())
					attributes.add("contexts");
				if(terminology.isHasOccurrences())
					attributes.add("occurrences");
				if(!attributes.isEmpty())
					text.append(" - with " + Joiner.on(" and ").join(attributes), TermSuiteUI.STYLE_GRAYED);
				cell.setImage(img.get(TermsuiteImg.TERMINOLOGY));
			} else if (element instanceof EPipeline) {
				EPipeline p = (EPipeline) cell.getElement();
				text.append(Files.getNameWithoutExtension(p.getTargetTerminologyName()));
				cell.setImage(img.get(TermsuiteImg.PIPELINE));
			} else if (cell.getElement() instanceof ECorpus) {
				ECorpus c = (ECorpus) cell.getElement();
				text.append(c.getName());
				cell.setImage(img.get(TermsuiteImg.CORPUS));
			} else if (cell.getElement() instanceof ESingleLanguageCorpus) {
				ESingleLanguageCorpus c = (ESingleLanguageCorpus) cell.getElement();
				text.append(LangUtil.getTermsuiteLang(c.getLanguage()).getNameUC());
				text.append(" (" + c.getDocuments().size() + ") ", StyledString.COUNTER_STYLER);
				cell.setImage(img.getFlag(c.getLanguage()));
			}
			cell.setText(text.toString());
			cell.setStyleRanges(text.getStyleRanges());
			super.update(cell);

		}

		private String getFileName(File file) {
			String name = file.getName();
			return name.isEmpty() ? file.getPath() : name;
		}
	}

	@Focus
	public void setFocus() {
		viewer.getControl().setFocus();
	}

	@Override
	public TreeViewer getTreeViewer() {
		return this.viewer;
	}
}
