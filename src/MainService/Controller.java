package MainService;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

import Server.Service;

public class Controller {

	private HashMap<String,Handler> handlerList = new HashMap<>();
	private OutputStream out;
	
	public Controller(HashMap<Integer, String> t, HashMap<String,Service> h, OutputStream o) {
		out = o;
		for(Map.Entry<Integer, String> entry : t.entrySet()) {
			handlerList.put(entry.getValue(),new OptionHandler(entry.getKey(),h.get(entry.getValue()).description));
		}
		handlerList.put("help", new HelpHandler());
		handlerList.put("exit", new ExitHandler());
		((HelpHandler) handlerList.get("help")).setConfig(handlerList,out);
		
	}
	
	public int process(String input) throws IOException {
		Handler h;
		
		try {
			h = handlerList.get(input);
			return h.execute();
		} catch (NullPointerException e) {
			out.write(("No handler for command \"" + input + "\" \n").getBytes());
			//e.printStackTrace();
			return -2;
		}
	}
}
