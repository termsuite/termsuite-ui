package fr.univnantes.termsuite.ui.util;

public class OSUtil {
	public static boolean isWindows() {
		return (getOSProperty().indexOf("win") >= 0);
	}

	public static boolean isMac() {
		return (getOSProperty().indexOf("mac") >= 0);
	}

	public static boolean isUnix() {
		return (getOSProperty().indexOf("nix") >= 0 || getOSProperty().indexOf("nux") >= 0 || getOSProperty().indexOf("aix") > 0 );
	}

	public static boolean isSolaris() {
		return (getOSProperty().indexOf("sunos") >= 0);
	}
	
	public static String getOSProperty() {
		return System.getProperty("os.name").toLowerCase();
	}

}
