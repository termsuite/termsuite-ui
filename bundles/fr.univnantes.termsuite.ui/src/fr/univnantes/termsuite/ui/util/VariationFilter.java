package fr.univnantes.termsuite.ui.util;

import fr.univnantes.termsuite.framework.service.RelationService;

public interface VariationFilter {
	boolean accept(RelationService v);
}
