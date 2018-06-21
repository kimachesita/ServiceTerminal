package PetService;

public class ExitHandler extends Handler {

	
	public ExitHandler(AnimalList t, IOInterface o) {
		super(t, o);
		description = "Exit Service";
	}

	@Override
	public int execute(String val) {
		io.writeln("Exiting Service...");
		return 1;
	}

}
