package Server;

import java.io.IOException;


public class Connection extends Thread{
	

	private Controller ctr;

	//connection constructor, add param Socket in the future and give it to controller as param also
	public Connection(){
		ctr = new Controller(System.in, System.out);
		this.start();
	}
	
	public void run() {
		try {
			ctr.route();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
