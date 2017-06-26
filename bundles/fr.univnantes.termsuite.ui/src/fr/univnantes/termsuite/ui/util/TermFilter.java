package fr.univnantes.termsuite.ui.util;

import fr.univnantes.termsuite.framework.service.TermService;

public interface TermFilter {
	boolean accept(TermService t);
}
