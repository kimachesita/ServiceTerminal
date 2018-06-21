package PetService;

import java.util.HashMap;
import java.util.Map;

public class HelpHandler extends Handler {
	
	private HashMap<String,Handler> directory;

	public HelpHandler(AnimalList t, IOInterface o) {
		super(t, o);
		description = "Show available options.";
	}
	
	public void setDirectory( HashMap<String,Handler> h ) {
		directory = h;
	}

	@Override
	public int execute(String val) {
		
		io.writeln("\nAvailable Options: ");
		Integer i = 0;
		for(Map.Entry<String, Handler> entry : directory.entrySet()) {
			io.writeln(++i + " : " + entry.getKey() + " (" + entry.getValue().description + ")");
		}
		return 0;
	}

}
