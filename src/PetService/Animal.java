package PetService;
public abstract class Animal implements Runnable{
	
	public String name;
	private int slugRate;
	public String title;
	
	public void breakfast() {
		System.out.println(title + " is eating breakfast...");
	}
	public void poo() {
		System.out.println(title + " is eating doing poo...");
	}
	public void play() {
		System.out.println(title + " is playing...");
	}
	public void nap() {
		System.out.println(title + " is napping...");
	}
	public void lunch() {
		System.out.println(title + " is eating lunch...");
	}
	public void sleep() {
		System.out.println(title + " is now sleeping...");
	}
	
	protected Animal(String n, int r) {
		name = n;
		slugRate = r;
		title = name + " the " + this.getClass().getName();
	}
	
	protected Animal(String n) {
		name = n;
		slugRate = 1000;
		title = name + " the " + this.getClass().getName();
	}
		
	private void dayLifeCycle() {
		try {
			System.out.println(title + " begins day.");
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
			System.out.println(title +  " ends day.");
		} catch (InterruptedException e) {
			System.err.println(e);
		}
	}
	
	public void run() {
		this.dayLifeCycle();
	}
	
}
