package PetService;
public class Pig extends Animal{

	private static final int slugRate = 1500;	
	
	public Pig(String n,IOInterface io) {
		super(n,slugRate, io);
		io.writeln("Creating Pig " + n);
	}
		
}
