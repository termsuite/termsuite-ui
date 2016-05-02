package fr.univnantes.termsuite.ui;

import java.net.URL;
import java.util.Comparator;
import java.util.HashMap;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.StyledString.Styler;
import org.eclipse.swt.SWT;
import org.osgi.framework.Bundle;

import com.google.common.collect.Maps;

import fr.univnantes.termsuite.ui.model.termsuiteui.EDocument;
import fr.univnantes.termsuite.ui.styles.StylerBuilder;
import fr.univnantes.termsuite.ui.util.CorpusUtil;
/*
 * TODO Remove Pipeline main section
 * TODO Clean Pipeline model's obsolete fields
 * TODO Make the "run" button disabled if pipeline is not validated
 * TODO Debug the highlight in Document Editor
 * TODO Listen to preferences's Wrap option
 * TODO TermSuite resources as OSGi
 */
public class TermSuiteUI {
	
	
	public static final String WEB_SITE_URL = "http://termsuite.github.io/";
	public static final String WEB_SITE_DOC_URL = WEB_SITE_URL + "documentation/";
	public static final String WEB_SITE_TAGGER_DOC_URL = WEB_SITE_DOC_URL + "pos-tagger-lemmatizer/";
	public static final String PLUGIN_ID = "fr.univnantes.termsuite.ui";
	public static final String UI_MAIN_PART_STACK = "fr.univnantes.termsuite.ui.partstack.main";

	public static final String INPUT_OBJECT = "InputObject";

	public static final String RUN = "icons/run_exc.png";

	public static final Styler STYLE_BOLD = StylerBuilder.start().fontStyle(SWT.BOLD).create();
	public static final Styler STYLE_GRAYED = StylerBuilder.start().color(120, 120, 120).fontStyle(SWT.ITALIC).create();
	public static final Styler STYLE_GRAYED_BOLD = StylerBuilder.start().color(40, 40, 40).fontStyle(SWT.BOLD | SWT.ITALIC).create();
	public static final Styler STYLE_MATCHES = StylerBuilder.start().color(50, 200, 255).fontStyle(SWT.ITALIC).create();

	
	public static final String URL_TREE_TAGGER = "http://www.cis.uni-muenchen.de/~schmid/tools/TreeTagger/";
	public static final String URL_MATE = "https://code.google.com/archive/p/mate-tools/wikis/ParserAndModels.wiki";
	public static final String DESCRIPTION = "TermSuite is a Java UIMA-based platform for terminology extraction and multilingual "
			+ "terminology alignment. TermSuite is developped by LINA UMR 6241 CNRS, University of Nantes.";
	public static final String COPYRIGHT = "LINA UMR 6241 CNRS - University of Nantes © 2016";
	public static final String GITHUB_URL = "https://github.com/termsuite/";
	public static final Comparator<? super EDocument> DOCUMENT_COMPARATOR = CorpusUtil.alphaNumDocumentComparator();

	
	public static final String PROGRESS_VIEW_ID = "org.eclipse.e4.ui.progress.ProgressView";
	public static final String SOURCE_TERMINOLOGY = "SourceTerminology";
	public static final String TARGET_TERMINOLOGY = "TargetTerminology";

	public static ImageDescriptor getImg(String path) {
        Bundle bundle = Platform.getBundle(PLUGIN_ID);
        IPath p = new Path(path);
        HashMap<String, String> options = Maps.newHashMap();
		URL url = FileLocator.find(bundle, p, options);
        ImageDescriptor desc = ImageDescriptor.createFromURL(url);
        return desc;
	}
	
}
