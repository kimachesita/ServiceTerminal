package PetService;
public final class ShowHandler extends Handler {

	public ShowHandler(AnimalList t, IOInterface o) {
		super(t, o);
		description = "Show animal list.";
	}

	@Override
	public int execute(String input) {
		super.getList().showAll();
		return 0;
	}

}
