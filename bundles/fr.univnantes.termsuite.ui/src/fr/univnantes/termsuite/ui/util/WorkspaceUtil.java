package fr.univnantes.termsuite.ui.util;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import fr.univnantes.termsuite.api.TermSuiteException;
import fr.univnantes.termsuite.ui.model.termsuiteui.TermsuiteuiPackage;

public class WorkspaceUtil {

	/**
	 * Saves an EMF object to XMI in a file inside 
	 * the runtime's workspace.
	 * 
	 * @param emfObject
	 * 			The object to store
	 * @param workspaceDir
	 * 			The parent directory where to store the resource.
	 * @param fileBaseName
	 * 			The file base name
	 * @param fileExtension
	 * 			the file extension
	 * @throws IOException
	 */
	public static void saveResource(EObject emfObject, String workspaceDir, String fileBaseName, String fileExtension) {

		Path p = Paths.get(
				Platform.getLocation().toString(), 
				workspaceDir,  
				fileBaseName + "." + fileExtension);
		saveResource(emfObject, p);
	}

	public static void saveResource(EObject emfObject, Path path) {
		// Obtain a new resource set
		ResourceSet resSet = new ResourceSetImpl();
		Resource resource = resSet
				.createResource(URI.createFileURI(path.toString()));
		// Get the first model element and cast it to the right type, in my
		// example everything is hierarchical included in this first node
		
//		if (emfObject instanceof EPipeline) {
//			resource.getContents().add(((EPipeline) emfObject).getTaggerConfig());
//		}
		resource.getContents().add(emfObject);

		// now save the content.
		Map<String, Object> options = Maps.newHashMap();
//		options.put(Resource.OPTION_SAVE_ONLY_IF_CHANGED, false);
		try {
			resource.save(options);
		} catch (IOException e) {
			throw new TermSuiteException("Could not save resource " + emfObject.getClass().getSimpleName(), e);
		}
	}
	
	/**
	 * Remove the file denoted by the relative path.
	 * 
	 * @param workspaceDir
	 * @param fileBaseName
	 * @param fileExtension
	 */
	public static void removeResource(String workspaceDir, String fileBaseName, String fileExtension) {
		Path p = Paths.get(
				Platform.getLocation().toString(), 
				workspaceDir,  
				fileBaseName + "." + fileExtension);
		p.toFile().delete();
	}
	
	public static URL getWorkspaceURL() {
		return Platform.getInstanceLocation().getURL();
	}
	
	public static Path getWorkspacePath() {
		try {
			return Paths.get(getWorkspaceURL().toURI());
		} catch (URISyntaxException e) {
			throw new TermSuiteException(e);
		}
	}

	public static Path getWorkspacePath(String... elements) {
		return Paths.get(getWorkspacePath().toString(), elements);
	}

	
	public static <T extends EObject> List<T> loadResources(String dir, final String extension, Class<T> cls) {
		// Initialize the model
		TermsuiteuiPackage.eINSTANCE.eClass();
		
		List<T> list = Lists.newArrayList();
		// Obtain a new resource set
		ResourceSet resSet = new ResourceSetImpl();
		
		
		File pDir = Paths.get(Platform.getLocation().toString(), dir).toFile();
		if(pDir.exists()) {
			File[] pFiles = pDir.listFiles((directory, name) ->  name.endsWith("." + extension));
			for(File f:pFiles) {
				URI uri = URI.createFileURI(f.getAbsolutePath());
				Resource resource = resSet.getResource(uri, true);
				// Get the first model element and cast it to the right type, in my
				// example everything is hierarchical included in this first node
				T pip = cls.cast(resource.getContents().get(0));
				list.add(pip);
			}
		}
		return list;
	}

	public static <T extends EObject> T loadResource(String resourcePath, Class<T> cls) {
		ResourceSet resSet = new ResourceSetImpl();
		File file = Paths.get(Platform.getLocation().toString(), resourcePath).toFile();
		Resource resource = resSet.getResource(URI.createFileURI(file.getAbsolutePath()), true);
		// Get the first model element and cast it to the right type, in my
		// example everything is hierarchical included in this first node
		return cls.cast(resource.getContents().get(0));
	}

	/**
	 * Builds the OS dependent path to given workspace-dependant path and create dirs.
	 * 
	 * @param relativePath
	 * @return
	 */
	public static String getLocation(String relativePath) {
		File file = Paths.get(Platform.getLocation().toString(), relativePath).toFile();
		return file.toString();
	}

	public static File getTempDir() {
		File tmpDir = getWorkspacePath("tmp").toFile();
		if(!tmpDir.exists())
			tmpDir.mkdir();
		return tmpDir;
	}

	public static void deleteTermSuiteTempFiles() {
		getTempDir().delete();
	}
	
}
