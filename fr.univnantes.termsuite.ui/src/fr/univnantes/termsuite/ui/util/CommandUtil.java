package fr.univnantes.termsuite.ui.util;

import java.util.Map;

import com.google.common.collect.Maps;

public class CommandUtil {
	public static Map<String, Object> params() {
		return Maps.newHashMap();
	}

	public static Map<String, Object> params(String param1, Object value1) {
		Map<String, Object> map = Maps.newHashMap();
		map.put(param1, value1);
		return map;
	}

	public static Map<String, Object> params(String param1, Object value1, String param2, Object value2) {
		Map<String, Object> map = Maps.newHashMap();
		map.put(param1, value1);
		map.put(param2, value2);
		return map;
	}
}
