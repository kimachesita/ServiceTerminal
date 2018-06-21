package PetService;
public class SimulateHandler extends Handler {

	public SimulateHandler(AnimalList t, IOInterface o) {
		super(t, o);
		description = "Simulate a day.";
	}

	@Override
	public int execute(String input) {
		super.simulate();
		return 0;
	}

}
