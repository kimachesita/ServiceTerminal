package PetService;
public class Mouse extends Animal{

	private static final int slugRate = 200;	
	
	public Mouse(String n,IOInterface io) {
		super(n,slugRate, io);
		io.writeln("Creating Mouse " + n);
	}
	
}
