package PetService;
public class Dog extends Animal{

	private static final int slugRate = 700;	
	
	public Dog(String n,IOInterface io) {
		super(n,slugRate, io);
		io.writeln("Creating Dog " + n);
	}
	
}
