package PetService;
public class Bird extends Animal{

	private static final int slugRate = 800;	
	
	public Bird(String n, IOInterface io) {
		super(n,slugRate, io);
		io.writeln("Creating Bird " + n);
	}	
}
