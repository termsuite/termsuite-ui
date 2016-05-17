package fr.univnantes.termsuite.ui.util;

import java.io.Closeable;

public class IOUtil {
	
	public static void closeSilently(Closeable... ary) {
		for(Closeable c:ary)
			try {
				c.close();
			} catch(Exception e){}		
	}
}
