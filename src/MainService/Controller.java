package MainService;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

public class Controller {

	private HashMap<String,Handler> handlerList = new HashMap<>();
	private OutputStream out;
	
	public Controller(HashMap<Integer, String> t, OutputStream o) {
		out = o;
		for(Map.Entry<Integer, String> entry : t.entrySet()) {
			handlerList.put(entry.getValue(),new OptionHandler(entry.getKey()));
		}
		handlerList.put("show", new ShowHandler());
		handlerList.put("exit", new ExitHandler());
		((ShowHandler) handlerList.get("show")).setConfig(handlerList,out);
		
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
