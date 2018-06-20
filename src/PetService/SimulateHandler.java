package PetService;
public class SimulateHandler extends Handler {

	public SimulateHandler(AnimalList t) {
		super(t);
	}

	@Override
	public int execute(String input) {
		super.simulate();
		return 0;
	}

}
