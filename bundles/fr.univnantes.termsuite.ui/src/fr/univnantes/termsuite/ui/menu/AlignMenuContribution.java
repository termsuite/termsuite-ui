 
package fr.univnantes.termsuite.ui.menu;

import java.util.Collection;
import java.util.List;

import javax.inject.Named;

import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.ui.di.AboutToShow;
import org.eclipse.e4.ui.model.application.ui.basic.MPart;
import org.eclipse.e4.ui.model.application.ui.menu.MDirectMenuItem;
import org.eclipse.e4.ui.model.application.ui.menu.MMenuElement;
import org.eclipse.e4.ui.model.application.ui.menu.MMenuFactory;
import org.eclipse.e4.ui.services.IServiceConstants;

import fr.univnantes.termsuite.model.Term;
import fr.univnantes.termsuite.ui.TermSuiteUI;
import fr.univnantes.termsuite.ui.model.termsuiteui.ELang;
import fr.univnantes.termsuite.ui.model.termsuiteui.ETerminology;
import fr.univnantes.termsuite.ui.parts.TermsuiteImg;
import fr.univnantes.termsuite.ui.services.AlignmentService;
import fr.univnantes.termsuite.ui.services.ResourceService;

public class AlignMenuContribution {

	@AboutToShow
	public void aboutToShow(
			List<MMenuElement> items, 
			@Named(IServiceConstants.ACTIVE_SELECTION) Term term,
			@Named(IServiceConstants.ACTIVE_PART) MPart part,
			@Named(TermSuiteUI.INPUT_OBJECT) ETerminology sourceTerminology,
			IEclipseContext context,
			ResourceService resourceService,
			AlignmentService alignmentService
		) {
		if(term != null && sourceTerminology != null) {
			Collection<ETerminology> targetTerminologies = alignmentService.canAlignWith(sourceTerminology);
			for(ETerminology targetTerminology:targetTerminologies) {
				ELang targetLang = targetTerminology.getCorpus().getLanguage();
				MDirectMenuItem dynamicItem = MMenuFactory.INSTANCE
						.createDirectMenuItem();
				dynamicItem.setLabel(String.format("%s (%s)", 
						targetTerminology.getName(), 
						targetTerminology.getCorpus().getLanguage().getName().toLowerCase()));
				dynamicItem.setIconURI(TermsuiteImg.INSTANCE.getFlagIconURI(targetLang));
				dynamicItem.setContributionURI("bundleclass://fr.univnantes.termsuite.ui/fr.univnantes.termsuite.ui.menu.AlignHandler");
				dynamicItem.setContributorURI("platform:/plugin/fr.univnantes.termsuite.ui");
				dynamicItem.getTags().add(resourceService.toModelTag(targetTerminology));
				context.set(TermSuiteUI.SOURCE_TERMINOLOGY, sourceTerminology);
				items.add(dynamicItem);
			}
		}
		if(items.isEmpty()) {
			MDirectMenuItem dynamicItem = MMenuFactory.INSTANCE
					.createDirectMenuItem();
			dynamicItem.setLabel("(No target terminology found)");
			dynamicItem.setEnabled(false);
			items.add(dynamicItem);
		}
	}	
}