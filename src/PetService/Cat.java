package PetService;
public class Cat extends Animal{

	private static final int slugRate = 1200;	
	
	public Cat(String n,IOInterface io) {
		super(n,slugRate, io);
		io.writeln("Creating Cat " + n);
	}
		
}
