package fr.univnantes.termsuite.ui.parts;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

import java.util.Collection;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;

import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.core.di.annotations.Optional;
import org.eclipse.e4.ui.model.application.ui.basic.MPart;
import org.eclipse.e4.ui.services.IServiceConstants;
import org.eclipse.e4.ui.workbench.modeling.ESelectionService;
import org.eclipse.jface.viewers.CellLabelProvider;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.TreeViewerColumn;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerCell;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.widgets.Composite;

import com.google.common.collect.Lists;

import fr.univnantes.termsuite.framework.service.RelationService;
import fr.univnantes.termsuite.framework.service.TermService;
import fr.univnantes.termsuite.model.Component;
import fr.univnantes.termsuite.model.Relation;
import fr.univnantes.termsuite.model.RelationType;
import fr.univnantes.termsuite.model.Term;
import fr.univnantes.termsuite.ui.TermOccurrenceContainer;
import fr.univnantes.termsuite.ui.util.CustomTreeNode;
import fr.univnantes.termsuite.ui.util.CustomTreeNodeManager;
import fr.univnantes.termsuite.ui.util.TermOccurrenceUtil;
import fr.univnantes.termsuite.ui.util.jface.ExpandCollapseDoubleClickListener;

public class TermOutlinePart {
	

	public static final String ID = "fr.univnantes.termsuite.ui.part.TermOutline";
	

	private static class DirectionalObject {
		private boolean direct;
		private Object object;
		private DirectionalObject(boolean direct, Object object) {
			super();
			this.direct = direct;
			this.object = object;
		}
		public Object getObject() {
			return object;
		}
		public boolean isDirect() {
			return direct;
		}
		
		private static Object[] fromObjects(boolean direct, Collection<?> objects) {
			return fromObjects(direct, objects.toArray());
		}

		private static Object[] fromObjects(boolean direct, Object... objects) {
			List<DirectionalObject> list = Lists.newArrayList();
			for(Object o:objects)
				list.add(new DirectionalObject(direct, o));
			return list.toArray();
		}
	}
	
	private static class Feature {
		private String name;
		private Object value;
		private boolean emph = false;
		
		public Feature(String name, Object value) {
			super();
			this.name = name;
			this.value = value;
		}
		public Feature(String name, Object value, boolean emph) {
			this(name, value);
			this.emph = emph;
		}
		
	}
	
	private CustomTreeNodeManager nodeManager = new CustomTreeNodeManager();

	private final int THE_FORMS_NODE = 1;
	private final int THE_VARIANT_NODE = 2;
	private final int THE_VARIATION_BASE_NODE = 3;
	private final int THE_EXTENSION_NODE = 4;
	private final int THE_EXTENSION_BASE_NODE = 5;
	private final int THE_COMPOSITION_NODE = 6;

	
	@Inject
	void updateTerm(@Optional @Named(IServiceConstants.ACTIVE_SELECTION) TermService scoredTerm) {
		if(viewer != null && scoredTerm != null)
			viewer.setInput(scoredTerm);
	}

	@Inject
	private ESelectionService selectionService;
	
	private TreeViewer viewer;
	  
	@PostConstruct
	public void createControls(IEclipseContext context, final Composite parent, MPart part) {
		viewer = new TreeViewer(parent, SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL | SWT.FULL_SELECTION);
		viewer.getTree().setHeaderVisible(true);
		viewer.getTree().setLinesVisible(true);
		viewer.setContentProvider( 
				new ITreeContentProvider() {

					private TermService scoredTerm;
					
					@Override
					public void dispose() {
						// TODO Auto-generated method stub
						
					}

					@Override
					public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
						nodeManager.clear();
						this.scoredTerm = (TermService) newInput;
					}

					@Override
					public Object[] getElements(Object inputElement) {
						TermService term = (TermService) inputElement;
						List<Object> children = Lists.newArrayList();
						children.add(new Feature("Key", term.getGroupingKey(), true));
						children.add(new Feature("Rank", term.getRank()));
						children.add(new Feature("Lemma", term.getLemma()));
						children.add(new Feature("Spoting rule", term.getSpottingRule()));
						children.add(new Feature("Pattern", term.getPattern(), true));
						children.add(new Feature("Pilot", term.getPilot()));
						children.add(new Feature("Frequency", term.getFrequency(), true));
						children.add(new Feature("Specificity", term.getSpecificity()));
						children.add(new Feature("Document Frequency", term.getDocumentFrequency()));
						children.add(new Feature("Compound?", term.isCompound() ? "yes" : "no", true));

						if(term.isCompound()) {
							children.add(new Feature("Compound type", term.getWords().get(0).getWord().getCompoundType()));
							children.add(nodeManager.get(term, THE_COMPOSITION_NODE));
						}

						children.add(new Feature("[raw] Frequency", term.getFrequency()));
						children.add(new Feature("[raw] Normalized frequency", term.getFrequencyNorm()));
						children.add(new Feature("[raw] General frequency", term.getGeneralFrequencyNorm()));
//						children.add(new Feature("Orthographic score", term.getOrthographicScore()));
//						children.add(new Feature("Independance score", term.getTermIndependanceScore()));

						
						children.add(nodeManager.get(term, THE_FORMS_NODE));
						
						if(term.outboundRelations(RelationType.VARIATION).findAny().isPresent())
							children.add(nodeManager.get(term, THE_VARIANT_NODE));

						if(term.inboundRelations(RelationType.VARIATION).findAny().isPresent())
							children.add(nodeManager.get(term, THE_VARIATION_BASE_NODE));
						
						return children.toArray();
					}

					@Override
					public Object[] getChildren(Object parentElement) {
						if(parentElement instanceof CustomTreeNode) {
							CustomTreeNode node = (CustomTreeNode)parentElement;
							if(node.getNodeType() == THE_FORMS_NODE) {
								return TermOccurrenceUtil.toTermForms(scoredTerm.getOccurrences()).toArray();
							} else if(node.getNodeType() == THE_VARIANT_NODE) {
								return DirectionalObject.fromObjects(true, scoredTerm.outboundRelations(RelationType.VARIATION).collect(toList()));
							} else if(node.getNodeType() == THE_VARIATION_BASE_NODE) {
								return DirectionalObject.fromObjects(false, scoredTerm.inboundRelations(RelationType.VARIATION).collect(toList()));
							} else if(node.getNodeType() == THE_EXTENSION_NODE) {
								return scoredTerm.extensions().toArray();
							} else if(node.getNodeType() == THE_EXTENSION_BASE_NODE) {
								return scoredTerm.extensionBases().toArray();
							} else if(node.getNodeType() == THE_COMPOSITION_NODE) {
								return scoredTerm.getWords().get(0).getWord().getComponents().toArray();

							}
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
						if(element instanceof CustomTreeNode) {
							CustomTreeNode node = (CustomTreeNode)element;
							return node.getNodeType() == THE_FORMS_NODE 
									|| node.getNodeType() == THE_VARIANT_NODE
									|| node.getNodeType() == THE_VARIATION_BASE_NODE
									|| node.getNodeType() == THE_EXTENSION_NODE
									|| node.getNodeType() == THE_COMPOSITION_NODE
									|| node.getNodeType() == THE_EXTENSION_BASE_NODE
									;
						}
						return false;
					}
				}
		);
		
		
		TreeViewerColumn column1 = new TreeViewerColumn(viewer, SWT.LEFT);
		column1.getColumn().setText("Property");
		column1.getColumn().setWidth(250);
		column1.setLabelProvider(new CellLabelProvider() {
			@Override
			public void update(ViewerCell cell) {
				Object element = cell.getElement();
				if(element instanceof CustomTreeNode) {
					CustomTreeNode node = (CustomTreeNode)element;
					if(node.getNodeType() == THE_FORMS_NODE) {
					List<TermOccurrenceContainer<String>> termForms = TermOccurrenceUtil.toTermForms(((TermService)node.getParent()).getOccurrences());
					cell.setText(String.format(
							"Forms (%d)", 
							termForms.size()
							));
					} else if(node.getNodeType() == THE_VARIANT_NODE) {
						cell.setText("Variants");
					} else if(node.getNodeType() == THE_VARIATION_BASE_NODE) {
						cell.setText("Is variant of");
					} else if(node.getNodeType() == THE_COMPOSITION_NODE) {
						cell.setText("Composition");
					} else if(node.getNodeType() == THE_EXTENSION_NODE) {
						cell.setText("Extensions");
					} else if(node.getNodeType() == THE_EXTENSION_BASE_NODE) {
						cell.setText("Is extension of");
					}
				} else if(element instanceof TermOccurrenceContainer) {
					cell.setText(((TermOccurrenceContainer<?>)element).getContainer().toString());
				} else if(element instanceof Feature) {
					Feature f = (Feature)element;
					cell.setText(f.name);
				} else if (element instanceof Component) {
					Component c = (Component)element;
					cell.setText(c.getLemma());
				} else if(element instanceof Term) {
					Term t = (Term)element;
					cell.setText(t.getPilot());
				} else if (element instanceof DirectionalObject) {
					DirectionalObject o = (DirectionalObject)element;
					Object object = o.getObject();
					if(object instanceof Relation) {
						Relation tv = (Relation)object;
						cell.setText((o.isDirect() ? tv.getTo(): tv.getFrom()).getPilot());
					}	
				} 			
			}
		});
		
		TreeViewerColumn column2 = new TreeViewerColumn(viewer, SWT.LEFT);
		column2.getColumn().setText("Value");
		column2.getColumn().setWidth(200);
		column2.setLabelProvider(new CellLabelProvider() {
			@Override
			public void update(ViewerCell cell) {
				Object element = cell.getElement();
				TermService sourceTerm = (TermService)viewer.getInput();
				if(element instanceof TermOccurrenceContainer) {
					cell.setText(((TermOccurrenceContainer<?>)element).getFrequency().toString());
				} else if(element instanceof Feature) {
					Feature f = (Feature)element;
					cell.setText(f.value.toString());
					if(f.emph)
			            cell.setForeground(new Color(cell.getControl().getDisplay(), 200,0,0));
				} else if (element instanceof Component) {
					Component c = (Component)element;
					cell.setText(sourceTerm.getWords().get(0).getWord().getLemma().substring(c.getBegin(), c.getEnd()));
				} else if (element instanceof DirectionalObject) {
					DirectionalObject o = (DirectionalObject)element;
					if(element instanceof RelationService) {
						RelationService sv = (RelationService)o.getObject();
						cell.setText(sv.getVariationRules().stream().collect(joining(", ")));
					} else if(element instanceof TermService) {
						TermService t = (TermService)o.getObject();
						cell.setText(t.getPattern());
					}	
				} 						
			}
		});
		
		if(selectionService.getSelection() instanceof TermService)
			updateTerm((TermService)selectionService.getSelection());
	
		viewer.addDoubleClickListener(new ExpandCollapseDoubleClickListener(viewer));
		viewer.addSelectionChangedListener(new ISelectionChangedListener() {
			
			@Override
			public void selectionChanged(SelectionChangedEvent event) {
				Object o = ((IStructuredSelection)event.getSelection()).getFirstElement();
				if(o != null) {
					if(o instanceof TermOccurrenceContainer)
						selectionService.setSelection(o);
				}
			}
		});
	}
}
