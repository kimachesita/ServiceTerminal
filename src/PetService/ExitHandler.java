package PetService;

public class ExitHandler extends Handler {

	
	public ExitHandler(AnimalList t, IOInterface o) {
		super(t, o);
	}

	@Override
	public int execute(String val) {
		io.writeln("Exiting Service...");
		return 1;
	}

}
