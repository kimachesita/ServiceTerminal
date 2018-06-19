package Parser;

import java.util.HashMap;

public abstract class Message {
	public String type; //"RES", "REQ"
	public HashMap<String,String> header;
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
	
}



