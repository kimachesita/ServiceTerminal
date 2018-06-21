package PetService;
public abstract class Animal implements Runnable{
	
	public String name;
	private int slugRate;
	public String title;
	public IOInterface io;
	
	public void breakfast() {
		io.writeln(title + " is eating breakfast...");
	}
	public void poo() {
		io.writeln(title + " is eating doing poo...");
	}
	public void play() {
		io.writeln(title + " is playing...");
	}
	public void nap() {
		io.writeln(title + " is napping...");
	}
	public void lunch() {
		io.writeln(title + " is eating lunch...");
	}
	public void sleep() {
		io.writeln(title + " is now sleeping...");
	}
	
	protected Animal(String n, int r, IOInterface o) {
		name = n;
		slugRate = r;
		title = name + " the " + this.getClass().getName();
		io = o;
	}
	
	protected Animal(String n, IOInterface o) {
		name = n;
		slugRate = 1000;
		title = name + " the " + this.getClass().getName();
		io = o;
	}
		
	private void dayLifeCycle() {
		try {
			io.writeln(title + " begins day.");
			this.breakfast();
			Thread.sleep(slugRate);
			this.poo();
			Thread.sleep(slugRate);
			this.play();
			Thread.sleep(slugRate);
			this.nap();
			Thread.sleep(slugRate);
			this.lunch();
			Thread.sleep(slugRate);
			this.play();
			Thread.sleep(slugRate);
			this.sleep();
			io.writeln(title +  " ends day.");
		} catch (InterruptedException e) {
			System.err.println(e);
		}
	}
	
	public void run() {
		this.dayLifeCycle();
	}
	
}
