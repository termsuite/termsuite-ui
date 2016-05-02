package fr.univnantes.termsuite.ui.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileUtil {

	public static String toString(File file) throws FileNotFoundException {
		Scanner scanner = new Scanner(file);
		String next = scanner.useDelimiter("\\Z").next();
		scanner.close();
		return next;
	}

	public static void mkdirs(File file) {
		if(file.isDirectory()) {
			file.mkdirs();
		} else {
			file.getParentFile().mkdirs();
		}
	}
}
