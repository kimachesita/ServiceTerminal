package PetService;

import java.util.HashMap;

public class Controller {

	private HashMap<String,Handler> hm;
	
	public IOInterface io;
	
	public Controller(IOInterface o) {
		io = o;
		
		AnimalList list = new AnimalList("Animal List", o);
		hm = new HashMap<>();
		hm.put("help", new HelpHandler(list, o));
		hm.put("show", new ShowHandler(list, o));
		hm.put("add", new AddPetHandler(list, o));
		hm.put("simulate", new SimulateHandler(list, o));
		hm.put("exit", new ExitHandler(list, o));
		
		((HelpHandler) hm.get("help")).setDirectory(hm);
		
	}
	
	public int process(String input){
		Handler h;
		String handlerName = new String();
		
		try {
			if(input.matches("\\w*:.+")) {
				handlerName = "add";
			}else if(input.matches("add\\s.+:.+")) {
				handlerName = "add";
				input = input.split("\\s",2)[1];
			}else{
				handlerName = input;
			}
			h = hm.get(handlerName);
			return h.execute(input);
		} catch (NullPointerException e) {
			io.writeln("No handler for command.");
			return 0;
		}
		
		
		
	}
}
