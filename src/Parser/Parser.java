package Parser;

import org.json.simple.JSONObject;

public class Parser {
	
	@SuppressWarnings("unchecked")
	public static String encode(Message m) {
		JSONObject obj = new JSONObject();
		obj.put("type", m.type);
		obj.put("header", m.header);
		obj.put("body", m.body);
		return obj.toJSONString();
	}
	
}
