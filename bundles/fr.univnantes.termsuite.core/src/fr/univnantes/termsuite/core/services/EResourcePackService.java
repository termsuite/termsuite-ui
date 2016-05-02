package fr.univnantes.termsuite.core.services;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

import org.eclipse.core.runtime.FileLocator;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;
import org.osgi.framework.BundleException;
import org.osgi.framework.FrameworkUtil;
import org.osgi.framework.wiring.BundleWiring;

public class EResourcePackService {
	
	/**
	 * Loads the given jar or directory as an OSGi Bundle, which 
	 * makes its content available in classpath at runtime.
	 * 
	 * @param dirOrJar
	 */
	public void loadResourcePack(String dirOrJar) {
		Bundle bundle = FrameworkUtil.getBundle(this.getClass());
		bundle.adapt(BundleWiring.class).getClassLoader();

		System.out.println(bundle.getBundleId());
		System.out.println(bundle.getLocation());
		System.out.println(bundle.getState());
		System.out.println(bundle.getSymbolicName());
		System.out.println(bundle.getVersion());
		BundleContext bundleContext = bundle.getBundleContext();
//		showContext(bundleContext);
		System.out.println("----");
		System.out.println("Installing new bundle from scratch");
		try {
			Bundle b = bundleContext.installBundle("file:" + dirOrJar, null);
			showContext(bundleContext);
			b.start();
			System.out.println(b.getLocation());
			System.out.println(b.getBundleId());
			System.out.println(b.getSymbolicName());
			System.out.println(b.getHeaders());
			
//			showFile(b, "fr/Prefix.French");
		} catch (BundleException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void showFile(Bundle bundle, String path) {
		URL fileURL = bundle.getEntry(path);
		File file = null;
		if(fileURL == null) {
			System.err.format("Null: %s in bundle %s\n", path, bundle);
			return;
		}
		try {
			URL resolve = FileLocator.resolve(fileURL);
			URI uri = resolve.toURI();
			System.out.println("URI: "+uri);
			file = new File(uri);
			System.out.println(file.getAbsolutePath());
		} catch (URISyntaxException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

	private void showContext(BundleContext bundleContext) {
		System.out.println("---");
		for(Bundle b:bundleContext.getBundles())
			System.out.format("%s:%s\n", b.getSymbolicName(), b.getVersion());
		System.out.format("Nb bundles: %d\n", bundleContext.getBundles().length);
	}
}
