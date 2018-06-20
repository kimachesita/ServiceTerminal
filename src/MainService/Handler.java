package MainService;
public abstract class Handler {
	
	private AnimalList list;
	
	public Handler(AnimalList t) {
		list = t;
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
