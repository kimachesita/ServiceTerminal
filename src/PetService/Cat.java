package PetService;
public class Cat extends Animal{

	private static final int slugRate = 1200;	
	
	public Cat(String n) {
		super(n,slugRate);
		System.out.println("Creating Cat " + n);
	}
		
}
