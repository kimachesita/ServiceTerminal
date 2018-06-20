package Parser;

import java.util.HashMap;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Parser {
	
	@SuppressWarnings("unchecked")
	public static String encode(Message m) {
		JSONObject obj = new JSONObject();
		obj.put("header", m.header);
		obj.put("body", m.body);
		return obj.toJSONString();
	}
	
	@SuppressWarnings("unchecked")
	public static Message decode(String s) throws ParseException {
		 Message m = new Message(); 
		 JSONParser parser = new JSONParser();
		 JSONObject obj = (JSONObject)parser.parse(s);
		m.header = (HashMap<String, String>) obj.get("header");
		m.body = (String) obj.get("body");

		 return m;
	}	
}
