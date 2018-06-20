package Server;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Stack;

import MainService.MainService;
import PetService.PetService;

public class Controller {
	//in and out corresponds to io streams from network utility
	private InputStream in;
	private OutputStream out;
	private HashMap<String,Service> serviceDirectory = new HashMap<>();
	private Stack<Service> serviceTree = new Stack<>();
	
	public Controller(InputStream i, OutputStream o ) {
		in = i;
		out = o;
		
		//populate serviceDirectory
		serviceDirectory.put("Main", new MainService(in,out));
		serviceDirectory.put("Pet", new PetService(in,out));
		
		
		//pass serviceDirectory to "Main" for reference
		((MainService) serviceDirectory.get("Main")).setDirectory(serviceDirectory);
		
		//set initial serviceTree to main
		serviceTree.push(serviceDirectory.get("Main"));
	}
	
	public void route() throws IOException {
		int returnValue = serviceTree.peek().start();
	}
	
}
