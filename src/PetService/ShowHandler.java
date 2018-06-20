package PetService;
public final class ShowHandler extends Handler {

	public ShowHandler(AnimalList t) {
		super(t);
	}

	@Override
	public int execute(String input) {
		super.getList().showAll();
		return 0;
	}

}
