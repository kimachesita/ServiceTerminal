package PetService;
import java.util.ArrayList;

public class AnimalList {
	private ArrayList<Animal> list = new ArrayList<>();
	private ArrayList<Thread> tList = new ArrayList<>();
	public String listName;
	
	public AnimalList(String name) {
		this.listName = name;
	}
	
	public void addPet(Animal pet) {
		list.add(pet);
		System.out.println(pet.name + " added to " + this.listName);
	}
	
	public void showAll() {
		System.out.println("There are " + list.size() + " pets currently onboard.");
		for(Animal pet : list) {
			System.out.println("Pet: " +  pet.name + " the " + pet.getClass().getName());
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



