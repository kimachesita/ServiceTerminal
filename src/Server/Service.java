package Server;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Stack;

public abstract class Service {
	
	protected InputStream in;
	protected OutputStream out;
	protected HashMap<String,Service> serviceDirectory = new HashMap<>();
	protected HashMap<Integer,String> serviceDirectoryTable = new HashMap<>();
	protected Stack<Service> serviceTree = new Stack<>();
	protected String serviceName;
	public String description;
	
	public Service(InputStream s, OutputStream d) {
		in = s;
		out = d;
		serviceName = this.getClass().getSimpleName();
	}
		
	public void write(String s) throws IOException {
		out.write(s.getBytes());
	}
	
	public String getServiceName() {
		return serviceName;
	}
	
	public void addService(Service s) {
		serviceDirectory.put(s.serviceName,s);
		serviceDirectoryTable.put(serviceDirectoryTable.size(), s.serviceName);
	}
	
	public void selectService(Service s) throws IOException {
		serviceTree.push(s);
		while(!serviceTree.isEmpty()) {
			if(serviceTree.peek().start() == ServiceReturnType.EXIT) {
				serviceTree.pop();
			}
		}
		//exiting service
	}
	
	public abstract ServiceReturnType start() throws IOException;
}
