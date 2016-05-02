package fr.univnantes.termsuite.ui.util;

import java.util.Comparator;

import fr.univnantes.termsuite.ui.model.termsuiteui.EDocument;

public class CorpusUtil {

	public static Comparator<EDocument> alphaNumDocumentComparator() {
		final Comparator<String> comp = StringUtil.numberAwareComparator();
		return new Comparator<EDocument>() {
			@Override
			public int compare(EDocument o1, EDocument o2) {
				return comp.compare(o1.getFilename(), o2.getFilename());
			}
		}; 
	}

}
