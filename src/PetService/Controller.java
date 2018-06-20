package PetService;
import java.util.HashMap;

public class Controller {

	private HashMap<String,Handler> hm;
	
	public Controller() {
		AnimalList list = new AnimalList("Animal List");
		hm = new HashMap<>();
		hm.put("show", new ShowHandler(list));
		hm.put("add", new AddPetHandler(list));
		hm.put("simulate", new SimulateHandler(list));
		hm.put("exit", new ExitHandler(list));
	}
	
	public int process(String input) {
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
			System.out.println("No handler for command.");
			return 0;
		}
		
		
		
	}
}
