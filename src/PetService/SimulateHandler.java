package PetService;
public class SimulateHandler extends Handler {

	public SimulateHandler(AnimalList t, IOInterface o) {
		super(t, o);
	}

	@Override
	public int execute(String input) {
		super.simulate();
		return 0;
	}

}
