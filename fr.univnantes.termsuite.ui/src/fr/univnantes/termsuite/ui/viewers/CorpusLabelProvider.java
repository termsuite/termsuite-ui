package fr.univnantes.termsuite.ui.viewers;

import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.graphics.Image;

import fr.univnantes.termsuite.ui.model.termsuiteui.ECorpus;
import fr.univnantes.termsuite.ui.model.termsuiteui.ESingleLanguageCorpus;
import fr.univnantes.termsuite.ui.parts.TermsuiteImg;

public class CorpusLabelProvider extends LabelProvider  {
	@Override
	public String getText(Object element) {
		if (element instanceof ECorpus) 
			return ((ECorpus) element).getName();
		else if(element instanceof ESingleLanguageCorpus) 
			return ((ESingleLanguageCorpus) element).getLanguage().getName();
		else return null;
	}
	@Override
	public Image getImage(Object element) {
		if (element instanceof ECorpus) 
			return TermsuiteImg.INSTANCE.get(TermsuiteImg.CORPUS);
		else if(element instanceof ESingleLanguageCorpus) 
			return TermsuiteImg.INSTANCE.getFlag(((ESingleLanguageCorpus) element).getLanguage());
		else return null;
	}
	
}