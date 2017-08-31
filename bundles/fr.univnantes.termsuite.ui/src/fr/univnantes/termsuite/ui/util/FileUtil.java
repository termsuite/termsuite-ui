package fr.univnantes.termsuite.ui.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.Scanner;

import com.google.common.base.Preconditions;
import com.google.common.base.Splitter;
import com.google.common.io.ByteStreams;

public class FileUtil {

	public static String toString(File file) throws FileNotFoundException {
		Scanner scanner = new Scanner(file, "UTF-8");
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
		byte[] buffer = ByteStreams.toByteArray(is);
		OutputStream outStream = new FileOutputStream(targetFile);
		outStream.write(buffer);
		outStream.flush();
		outStream.close();
	}
	
	public static String getFilename(String path) {
		List<String> list = Splitter.on(File.separator).splitToList(path);
		return list.get(list.size() - 1);
	}

	public static long folderSize(File directory) {
		Preconditions.checkArgument(directory.isDirectory());
	    long length = 0;
	    for (File file : directory.listFiles()) {
	        if (file.isFile())
	            length += file.length();
	        else
	            length += folderSize(file);
	    }
	    return length;		
	}
}
