package MainService;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Scanner;

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
		Scanner scanner = new Scanner(this.in);
		Controller controller = new Controller(serviceDirectoryTable,out);
		String input;
		Integer returnValue;
		
		write("=============================================\n");
		write("Welcome to Service Terminal\n");
		write("Type \"show\" to show available options.\n");
		
		do {
			write("Main: Enter your option here >>");
			
			input = scanner.nextLine();
			returnValue = controller.process(input);
			
			if(returnValue > -1) {
				selectService(serviceDirectory.get(serviceDirectoryTable.get(returnValue)));
			}
			
		}while(returnValue != -1);
		scanner.close();
		write("Sevice Exiting...\n");
		return ServiceReturnType.EXIT;
	}	
}
