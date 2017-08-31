package fr.univnantes.termsuite.ui.services.impl;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.eclipse.core.runtime.preferences.InstanceScope;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.core.di.annotations.Optional;
import org.eclipse.e4.core.di.extensions.Preference;
import org.eclipse.e4.core.services.log.ILoggerProvider;
//import org.eclipse.e4.core.services.log.Logger;
import org.osgi.service.prefs.Preferences;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Lists;
import com.google.common.collect.Multimap;
import com.google.common.collect.Sets;

import fr.univnantes.termsuite.alignment.BilingualAlignmentService;
import fr.univnantes.termsuite.alignment.TranslationCandidate;
import fr.univnantes.termsuite.api.TermSuite;
import fr.univnantes.termsuite.framework.service.TermService;
import fr.univnantes.termsuite.metrics.Cosine;
import fr.univnantes.termsuite.ui.TermSuiteUI;
import fr.univnantes.termsuite.ui.TermSuiteUIPreferences;
import fr.univnantes.termsuite.ui.exceptions.DictionaryException;
import fr.univnantes.termsuite.ui.model.termsuiteui.EBilingualDictionary;
import fr.univnantes.termsuite.ui.model.termsuiteui.ELang;
import fr.univnantes.termsuite.ui.model.termsuiteui.ETerminology;
import fr.univnantes.termsuite.ui.model.termsuiteui.TermsuiteuiFactory;
import fr.univnantes.termsuite.ui.services.AlignmentService;
import fr.univnantes.termsuite.ui.services.ETerminologyService;
import fr.univnantes.termsuite.ui.services.ResourceService;
import fr.univnantes.termsuite.ui.util.LangUtil;

@SuppressWarnings("restriction")
public class AlignmentServiceImpl implements AlignmentService {

	@Inject ILoggerProvider loggerProvider;

	private List<EBilingualDictionary> dictionaries;
	private Multimap<ELang, EBilingualDictionary> targetDictionaries;
	private Multimap<ELang, EBilingualDictionary> sourceDictionaries;
	

	@Inject IEclipseContext context;

	@Inject
	@Optional
	public void reactOnInputDirectoryChange( @Preference(value = TermSuiteUIPreferences.BILINGUAL_DICTIONARY_DIRECTORY) String dictionaryDirectory) {
		loadDictionaries();
	}
	

	@PostConstruct
	private void loadDictionaries() {
		targetDictionaries = HashMultimap.create();
		sourceDictionaries = HashMultimap.create();
		
		Preferences preferences = InstanceScope.INSTANCE
				  .getNode(TermSuiteUI.PLUGIN_ID);

		String dictionaryDirectory = preferences.get(TermSuiteUIPreferences.BILINGUAL_DICTIONARY_DIRECTORY, null);
		
		dictionaries = findDictionaries(Paths.get(dictionaryDirectory));
			
		for(EBilingualDictionary dico:dictionaries) {
			sourceDictionaries.put(dico.getSourceLang(), dico);
			targetDictionaries.put(dico.getTargetLang(), dico);
		}
	}


	public static List<EBilingualDictionary> findDictionaries(Path dictionaryDirectory) {
		List<EBilingualDictionary> list = Lists.newArrayList();
		if(dictionaryDirectory != null) {

			File dir = dictionaryDirectory.toFile();
			Pattern pattern = Pattern.compile("(?<source>\\w+)-(?<target>\\w+)\\.txt");
			if(dir.isDirectory()) {
				for(File f:dir.listFiles()) {
					Matcher matcher = pattern.matcher(f.getName());
					if(matcher.matches()) {
						EBilingualDictionary dico = TermsuiteuiFactory.eINSTANCE.createEBilingualDictionary();
						String source = matcher.group("source").toLowerCase();
						dico.setSourceLang(LangUtil.getLanguageByString(source));

						String target = matcher.group("target").toLowerCase();
						dico.setTargetLang(LangUtil.getLanguageByString(target));
						
						dico.setPath(f.getAbsolutePath());
						
						list.add(dico);
					}
				}
			}
		}
		return list;
	}


	@Override
	public boolean canAlignWith(ELang sourceLang, ELang targetLang) {
		for(EBilingualDictionary dico:sourceDictionaries.get(sourceLang)) {
			if(dico.getTargetLang().equals(targetLang))
				return true;
		}
		return false;
	}


	@Override
	@SuppressWarnings("unchecked")
	public Collection<ETerminology> canAlignWith(ETerminology terminology) {
		if(terminology.isHasContexts()) {
			Set<ETerminology> alignableTermino = Sets.newHashSet();
			for(ETerminology targetTermino:context.get(ResourceService.class).getTerminologies())  {
				if(!targetTermino.getCorpus().getCorpus().equals(terminology.getCorpus().getCorpus())) {
					// 1- can only align on the same comparable corpus
					continue;
				}
				if(targetTermino.getCorpus().getLanguage().equals(terminology.getCorpus().getLanguage())) {
					// 2- cannot do bilingual alignment on the same language
					continue;
				}
				if(!targetTermino.isHasContexts()) {
					// 3- contexts must have been computed
					continue;
				}
				if(!canAlignWith(
						terminology.getCorpus().getLanguage(), 
						targetTermino.getCorpus().getLanguage())) {
					// 4- the dictionary needs to be available for these two languages
					continue;
				}
				alignableTermino.add(targetTermino);
			}
			return alignableTermino;
		} else
			return java.util.Collections.EMPTY_LIST;
	}
	
	@Override
	public Collection<EBilingualDictionary> getDictionaries() {
		return Collections.unmodifiableCollection(dictionaries);
	}

	@Override
	public Collection<EBilingualDictionary> getTargetDictionaries(ELang sourceLanguage) {
		return targetDictionaries.get(sourceLanguage);
	}

	@Override
	public Collection<EBilingualDictionary> getSourceDictionaries(ELang targetLanguage) {
		return sourceDictionaries.get(targetLanguage);
	}

	@Override
	public void reloadDictionaries() {
		loadDictionaries();
	}


	@Override
	public EBilingualDictionary getSynonymDictionary(ELang source, ELang target) {

		if(sourceDictionaries.get(source) != null) {
			for(EBilingualDictionary dico:sourceDictionaries.get(source))
				if(dico.getTargetLang().equals(target))
					return dico;
		}
		 return null;
	}


	@Override
	public List<TranslationCandidate> align(TermService term, ETerminology sourceTerminology, ETerminology targetTerminology) {
		
		EBilingualDictionary dico = getSynonymDictionary(
				sourceTerminology.getCorpus().getLanguage(), 
				targetTerminology.getCorpus().getLanguage());
		
		if(dico == null) {
//			LOG
			throw new DictionaryException(String.format(
					"Dictionary not found from language %s to language %s",
					sourceTerminology.getCorpus().getLanguage().getName(),
					targetTerminology.getCorpus().getLanguage().getName()));
			
		} else {
			BilingualAlignmentService aligner;
			ETerminologyService terminoService = context.get(ETerminologyService.class);
			aligner = TermSuite.bilingualAligner()
					.setSourceTerminology(terminoService.readTerminology(sourceTerminology))
					.setTargetTerminology(terminoService.readTerminology(targetTerminology))
					.setDicoPath(Paths.get(dico.getPath()))
					.setDistance(Cosine.class)
					.create();
			
			return aligner.align(term.getTerm(), 20, 2);
		}
	}

}
