package Server;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public abstract class Service {
	
	protected InputStream in;
	protected OutputStream out;
	
	public Service(InputStream source, OutputStream destination) {
		in = source;
		out = destination;
	}
	
	public void write(String s) throws IOException {
		out.write(s.getBytes());
	}
	
	public abstract int start() throws IOException;
}
