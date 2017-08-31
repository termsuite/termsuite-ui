package fr.univnantes.termsuite.ui.util;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import com.google.common.base.Preconditions;
import com.google.common.collect.HashMultimap;
import com.google.common.collect.Lists;
import com.google.common.collect.Multimap;

import fr.univnantes.termsuite.model.TermOccurrence;
import fr.univnantes.termsuite.ui.TermOccurrenceContainer;
import fr.univnantes.termsuite.ui.model.termsuiteui.EDocument;
import fr.univnantes.termsuite.ui.services.CorpusService;

public class TermOccurrenceUtil {


	public static List<TermOccurrenceContainer<String>> toTermForms(Collection<TermOccurrence> occurrences) {
		return toList(occurrences, new KeyGetter<String>() {
			@Override
			public String getKey(TermOccurrence o) {
				return StringUtil.noLinebreak(o.getCoveredText()).toLowerCase();
			}
		});
	}

	private static <T> List<TermOccurrenceContainer<T>> toList(Collection<TermOccurrence> occurrences, KeyGetter<T> getter) {
		Multimap<T, TermOccurrence> map = HashMultimap.create();
		for(TermOccurrence o:occurrences)
			map.put(getter.getKey(o), o);
		
		List<TermOccurrenceContainer<T>> termForms = Lists.newArrayList();
		for(T form:map.keySet()) {
			List<TermOccurrence> occList = Lists.newArrayList(map.get(form));
			Collections.sort(occList);
			termForms.add(new TermOccurrenceContainer<T>(form, occList));
		}
		
		Collections.sort(termForms);
		return termForms;
	}

	private static interface KeyGetter<T> {
		public T getKey(TermOccurrence o);
	}
	
	public static List<TermOccurrenceContainer<EDocument>> toDocumentContainers(Collection<TermOccurrence> o, final CorpusService corpusService) {
		return toList(o, new KeyGetter<EDocument>() {
			@Override
			public EDocument getKey(TermOccurrence o) {
				EDocument resolvedDoc = corpusService.resolveEDocument(o.getSourceDocument());
				Preconditions.checkNotNull(resolvedDoc);
				return resolvedDoc;
			}
		});

		
	}

}
