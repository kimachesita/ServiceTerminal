package MainService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;

import PetService.PetService;
import Server.Service;
import Server.ServiceReturnType;

public class MainService extends Service {
	
	public MainService(InputStream in,OutputStream out) {
		super(in,out);
		
		//insert services under main service
		addService(new PetService(in,out));
	}
	
	@Override
	public ServiceReturnType start() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(this.in));
		Controller controller = new Controller(serviceDirectoryTable,out);
		String input;
		Integer returnValue;
		
		write("=============================================\n");
		write("Welcome to Service Terminal\n");
		write("Type \"show\" to show available options.\n");
		
		do {
			write("Main: Enter your option here >> ");
			
			input = br.readLine();
			returnValue = controller.process(input);
			
			if(returnValue > -1) {
				selectService(serviceDirectory.get(serviceDirectoryTable.get(returnValue)));
			}
			
		}while(returnValue != -1);
		write("Exiting Service...\n");
		return ServiceReturnType.EXIT;
	}	
}
