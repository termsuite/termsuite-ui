package fr.univnantes.termsuite.ui.viewers;

import static java.util.stream.Collectors.toList;

import java.util.regex.Pattern;

import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;

import fr.univnantes.termsuite.framework.service.RelationService;
import fr.univnantes.termsuite.framework.service.TermService;
import fr.univnantes.termsuite.framework.service.TerminologyService;
import fr.univnantes.termsuite.model.RelationType;
import fr.univnantes.termsuite.ui.model.termsuiteui.ETerminoViewerConfig;

public class TerminologyContentProvider implements ITreeContentProvider {

	private ETerminoViewerConfig viewerConfig;

	public TerminologyContentProvider(ETerminoViewerConfig viewerConfig) {
		super();
		this.viewerConfig = viewerConfig;
	}

	public boolean isMatchingTerm(Object termOrVariant) {
		if(!viewerConfig.getSearchString().trim().isEmpty()) {
			Pattern pattern = Pattern.compile(viewerConfig.getSearchString());
			if(termOrVariant instanceof TermService) {
				TermService t = (TermService)termOrVariant;
				return pattern.matcher(t.getGroupingKey()).find()
						|| pattern.matcher(t.getPilot()).find()
						|| t.outboundRelations(RelationType.VARIATION).filter(v->{
							return isMatchingTerm(v);
							}
						).findAny().isPresent();
			} else if (termOrVariant instanceof RelationService) {
				RelationService v = (RelationService) termOrVariant;
				return pattern.matcher(v.getTo().getGroupingKey()).find()
						|| v.getVariationRules().stream().filter(ruleName -> pattern.matcher(ruleName).find()).findAny().isPresent()
						|| pattern.matcher(v.getTo().getPilot()).find();
			} else
				return false;
		} else
			return true;
	}

	@Override
	public void dispose() {
	}

	private TerminologyService terminologyService;
	
	@Override
	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		this.terminologyService = (TerminologyService)newInput;
	}

	@Override
	public Object[] getElements(Object inputElement) {
		return this.terminologyService.terms()
			.filter(this::isMatchingTerm)
			.limit(viewerConfig.getNbDisplayedTerms())
			.collect(toList())
			.toArray();
	}

	@Override
	public Object[] getChildren(Object parentElement) {
		if (parentElement instanceof TermService) {
			TermService t = (TermService)parentElement;
			return t.outboundRelations(RelationType.VARIATION)
					.filter(this::isMatchingTerm)
					.collect(toList())
					.toArray();
		} else if (parentElement instanceof RelationService) {
			RelationService r = (RelationService)parentElement;
			return r.getTo().outboundRelations(RelationType.VARIATION)
					.filter(this::isMatchingTerm)
					.collect(toList())
					.toArray();

		}
		return null;
	}


	@Override
	public Object getParent(Object element) {
		if (element instanceof RelationService) 
			return ((RelationService)element).getFrom();
		return null;
	}

	@Override
	public boolean hasChildren(Object element) {
		if (element instanceof TermService) {
			return ((TermService)element)
					.outboundRelations(RelationType.VARIATION)
					.findAny()
					.isPresent();
		} else if (element instanceof RelationService) {
			return ((RelationService)element)
					.getTo()
					.outboundRelations(RelationType.VARIATION)
					.findAny()
					.isPresent();
		} else
			return false;

	}
}
