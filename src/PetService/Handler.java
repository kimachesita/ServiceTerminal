package PetService;
public abstract class Handler {
	
	private AnimalList list;
	public IOInterface io;
	
	public Handler(AnimalList t, IOInterface o) {
		list = t;
		io = o;
	}
	
	public abstract int execute(String val);

	public AnimalList getList() {
		return list;
	}
	
	public void addToList(Animal a) {
		list.addPet(a);
	}
	
	public void simulate() {
		list.simulate();
	}

}
