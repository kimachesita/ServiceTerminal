package PetService;
public class Mouse extends Animal{

	private static final int slugRate = 200;	
	
	public Mouse(String n) {
		super(n,slugRate);
		System.out.println("Creating Mouse " + n);
	}
	
}
