package PetService;
import java.util.ArrayList;

public class AnimalList {
	private ArrayList<Animal> list = new ArrayList<>();
	private ArrayList<Thread> tList = new ArrayList<>();
	public String listName;
	public IOInterface io;
	
	public AnimalList(String name, IOInterface o) {
		this.listName = name;
		io = o;
	}
	
	public void addPet(Animal pet) {
		list.add(pet);
		io.writeln(pet.name + " added to " + this.listName);
	}
	
	public void showAll() {
		io.writeln("There are " + list.size() + " pet(s) currently onboard.");
		for(Animal pet : list) {
			io.writeln("Pet: " +  pet.name + " the " + pet.getClass().getSimpleName());
		}
	}
	
	public void simulate() {
		for(Animal pet : list) {
			Thread t = new Thread(pet);
			t.start();
			tList.add(t);
		}
		while(!tList.isEmpty()) {
			try {
				tList.remove(0).join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}
	}	
}



