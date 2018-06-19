package Server;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import Parser.*;

public class Connection extends Thread{
	
	private InputStream in;
	private OutputStream out;

	Connection(){
		in = System.in;
		out = System.out;
		this.start();
	}
	
	public void run() {
		Message m = new ResMessage("Hello\\nWorld");
		m.addHeaderOrigin("192.76.23.23");
		System.out.println(Parser.encode(m));
	}
	
}
