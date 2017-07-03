package fr.univnantes.termsuite.ui.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.google.common.base.Preconditions;

public class BrokerUtil {

	public static Map<Class<?>, Object> toParamMap(Object... params) {
		Map<Class<?>, Object> map = new HashMap<>();
		for(Object p:params) {
			Preconditions.checkArgument(
					!map.containsKey(p.getClass()),
					"Got at least two params of type %s. At most one param for each type allowed.",
					p.getClass().getSimpleName());
			map.put(p.getClass(), p);
		}
		return map;
	}

	public static <T> T get(Map<Class<?>, Object> params, Class<T> cls) {
		if(params.containsKey(cls))
			return cls.cast(params.get(cls));
		else {
			List<Object> candidates = new ArrayList<>();
			for(Entry<Class<?>, Object> e:params.entrySet()) {
				if(cls.isInstance(e.getValue()))
					candidates.add(e.getValue());
			}
			Preconditions.checkArgument(!candidates.isEmpty(),
					"Found no parameter of type %s in %s", 
					cls, params);
			Preconditions.checkArgument(candidates.size()<2,
					"Amibiguous query. There ara several params of type %s in %s", 
					cls, params);
			return cls.cast(candidates.get(0));
		}
	}
}
