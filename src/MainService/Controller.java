package MainService;
import java.util.HashMap;
import java.util.Map;

import Server.Service;

public class Controller {

	private HashMap<String,Handler> directoryList;
	
	public Controller(HashMap<String,Service> d) {
		for(Map.Entry<String, Service> entry : d.entrySet()) {
			directoryList.put(entry.getKey(),new OptionHandler(entry.getKey()));
		}
		
	}
	
	public int process(String input) {
		Handler h;

		
		try {
			if(input.matches("\\w*:.+")) {
				word = "add";
			}else {
				word = input;
			}
			h = hm.get(word);
			return h.execute(input);
		} catch (NullPointerException e) {
			System.out.println("No handler for command.");
			return 0;
		}
		
		
		
	}
}
