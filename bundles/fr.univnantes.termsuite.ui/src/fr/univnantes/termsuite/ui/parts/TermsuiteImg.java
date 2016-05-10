package fr.univnantes.termsuite.ui.parts;

import java.net.URL;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.Path;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.graphics.Image;
import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;

import fr.univnantes.termsuite.ui.model.termsuiteui.ELang;
import fr.univnantes.termsuite.ui.parts.NavigatorPart.ViewLabelProvider;
import fr.univnantes.termsuite.ui.util.LangUtil;

public class TermsuiteImg {
	public static final String CORPORA = "icons/repo_rep.gif";
	public static final String CORPUS = "icons/remote_history_mode.gif";
	public static final String PIPELINES = "icons/prj_obj.png";
	public static final String LINGUISTIC_RESOURCES = "icons/JPackage.gif";
	public static final String PIPELINE = "icons/debugtt_obj.gif";
	public static final String FOLDER = "icons/fldr_obj.png";
	public static final String FOLDER_TERMINO = "icons/fldr_termino.png";
	public static final String FOLDER_DOCUMENT = "icons/fldr_document.png";
	public static final String FILE = "icons/file_obj.png";
	public static final String RUN = "icons/run.png";
	public static final String TERM_FORM = "icons/default_co.png";
	public static final String OCCURRENCE = "icons/public_co.png";
	protected static final String SEARCHM_OBJECT = "icons/searchm_obj.png";

	public static final String TERMINOLOGY = "icons/hierarchicalLayout.png";
	

	private LoadingCache<String, Image> cache = CacheBuilder.newBuilder().build(new CacheLoader<String, Image>() {
		@Override
		public Image load(String fullPath) throws Exception {
			Bundle bundle = FrameworkUtil.getBundle(ViewLabelProvider.class);
			URL url = FileLocator.find(bundle, new Path(fullPath), null);
			ImageDescriptor imageDcr = ImageDescriptor.createFromURL(url);
			return imageDcr.createImage();
		}
	});
	
	public static final TermsuiteImg INSTANCE = new TermsuiteImg();
	
	private TermsuiteImg(){
		
	}
	
	public Image getFlag(ELang l) {
		return get(String.format("icons/flags/16x11/%s.png", 
				LangUtil.getCountry(l)));
	}
	
	public String getFlaggedTerminoURI(ELang lang) {
		return String.format("icons/termino/termino-%s.png", 
//				TermSuiteUI.PLUGIN_ID,
				LangUtil.getCountry(lang));
	}


	public Image get(String fullPath) {
		return cache.getUnchecked(fullPath);
	}

	public String getFlagIconURI(ELang l) {
		return String.format("platform:/plugin/fr.univnantes.termsuite.ui/icons/flags/16x11/%s.png", 
				LangUtil.getCountry(l));
	}

}
