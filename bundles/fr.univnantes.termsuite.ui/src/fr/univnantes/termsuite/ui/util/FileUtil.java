package fr.univnantes.termsuite.ui.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;

import com.google.common.base.Splitter;
import com.google.common.collect.Lists;

public class FileUtil {

	public static String toString(File file) throws FileNotFoundException {
		Scanner scanner = new Scanner(file);
		String next = scanner.useDelimiter("\\Z").next();
		scanner.close();
		return next;
	}

	public static void mkdirs(File file) {
		if (file.isDirectory()) {
			file.mkdirs();
		} else {
			file.getParentFile().mkdirs();
		}
	}

	public static void inputStreamToFile(InputStream is, File targetFile) throws IOException {
		byte[] buffer = new byte[is.available()];
		is.read(buffer);
		OutputStream outStream = new FileOutputStream(targetFile);
		outStream.write(buffer);
		outStream.close();
	}
	
	public static final Collection<String> removeTermSuiteTempFiles() {
		Collection<String> remPaths = Lists.newArrayList();
		File tmpDir = new File(System.getProperty("java.io.tmpdir"));
		for(File tmpFile:tmpDir.listFiles()) {
			if(tmpFile.getName().startsWith("termsuite-")) {
				remPaths.add(tmpFile.getPath());
				tmpFile.delete();
			}
		}
		return remPaths;
	}

	public static String getFilename(String path) {
		List<String> list = Splitter.on(File.separator).splitToList(path);
		return list.get(list.size() - 1);
	}
}
