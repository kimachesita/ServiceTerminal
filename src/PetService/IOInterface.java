package PetService;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;


public class IOInterface {
	public OutputStream out;
	public InputStream in;
	
	public IOInterface(InputStream i, OutputStream o){
		in = i;
		out = o;
	}
	
	public void write(String s) {
		try {
			out.write(s.getBytes());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void writeln(String s) {
		try {
			out.write((s + "\n").getBytes());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
