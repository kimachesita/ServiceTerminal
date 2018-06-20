package PetService;
public class Pig extends Animal{

	private static final int slugRate = 1500;	
	
	public Pig(String n) {
		super(n,slugRate);
		System.out.println("Creating Pig " + n);
	}
		
}
