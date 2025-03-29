package util;

import java.util.HashMap;
import java.util.Map;

public class TestVariables {

	public static final Map<String, Object> map = new HashMap<>();

	public void store(String label, Object data) {
		if (data != null) {
			this.map.put(label, data);
		}
	}
}
