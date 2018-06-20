package PetService;

public class ExitHandler extends Handler {

	public ExitHandler(AnimalList t) {
		super(t);
	}

	@Override
	public int execute(String val) {
		System.out.println("Exiting Program...");
		return 1;
	}

}
