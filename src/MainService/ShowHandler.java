package MainService;

import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

public final class ShowHandler extends Handler {

	HashMap<String,Handler> handlerList = new HashMap<>();
	private OutputStream out;
	
	public ShowHandler() {
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
		write("Available Options:\n");
		for(Map.Entry<String,Handler> entry: handlerList.entrySet()) {
			write(i++ + ": " + entry.getKey() + "\n");
		}
		return -2;
	}

}
