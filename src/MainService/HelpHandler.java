package MainService;

import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

public final class HelpHandler extends Handler {

	HashMap<String,Handler> handlerList = new HashMap<>();
	private OutputStream out;
	
	public HelpHandler() {
		description = "Show Service Command Options";
	}
	
	public void setConfig(HashMap<String,Handler> h, OutputStream o) {
		handlerList = h;
		out = o;
	}

	public void write(String s) throws IOException {
		out.write(s.getBytes());
	}
		
	@Override
	public int execute() throws IOException {
		Integer i = 1;
		write("\nAvailable Options:\n");
		for(Map.Entry<String,Handler> entry: handlerList.entrySet()) {
			write(i++ + ": " + entry.getKey() + " (" + entry.getValue().description +")\n");
		}
		return -2;
	}

}
