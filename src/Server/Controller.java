package Server;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Stack;

import MainService.MainService;

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

		//set initial serviceTree to main
		serviceTree.push(serviceDirectory.get("Main"));
	}

	public void route() throws IOException {
		while(!serviceTree.isEmpty()) {
			if(serviceTree.peek().start() == ServiceReturnType.EXIT) {
				serviceTree.pop();
			}
		}
		//Client Exiting code here
	}
}
