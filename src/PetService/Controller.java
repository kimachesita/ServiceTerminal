package PetService;

import java.util.HashMap;

public class Controller {

	private HashMap<String,Handler> hm;
	
	public IOInterface io;
	
	public Controller(IOInterface o) {
		AnimalList list = new AnimalList("Animal List", o);
		hm = new HashMap<>();
		hm.put("show", new ShowHandler(list, o));
		hm.put("add", new AddPetHandler(list, o));
		hm.put("simulate", new SimulateHandler(list, o));
		hm.put("exit", new ExitHandler(list, o));
		io = o;
	}
	
	public int process(String input){
		Handler h;
		String word = new String();
		
		try {
			if(input.matches("\\w*:.+")) {
				word = "add";
			}else {
				word = input;
			}
			h = hm.get(word);
			return h.execute(input);
		} catch (NullPointerException e) {
			io.writeln("No handler for command.");
			return 0;
		}
		
		
		
	}
}
