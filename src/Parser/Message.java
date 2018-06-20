package Parser;

import java.util.HashMap;

public class Message {

	public HashMap<String,String> header = new HashMap<>();
	public String body;
	
	
	public void addHeaderOrigin(String s) {
		header.put("Origin", s);
	}
	
	public void addHeaderDestination(String s) {
		header.put("Destination", s);
	}
	
	public void addHeaderStatus(String s) {
		header.put("Status", s);
	}
	
	public void addHeaderService(String s) {
		header.put("Service", s);
	}
	
	public void addHeaderType(String s) {
		header.put("Type", s);
	}
	
	public void addHeaderMsgCode(String s) {
		header.put("Code", s);
	}
	
}



