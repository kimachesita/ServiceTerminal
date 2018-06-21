package PetService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;

import Server.Service;
import Server.ServiceReturnType;

public class PetService extends Service{
	
	public IOInterface outbox;
	
	public PetService(InputStream in, OutputStream out) {
		super(in, out);
		outbox = new IOInterface(in,out);
	}


	@Override
	public ServiceReturnType start() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(this.in));
		String input;
		Controller controller = new Controller(outbox);
	
		do {
			outbox.write("Pet: pet to create >> ");
			input = br.readLine();
			
		}while(controller.process(input) == 0);
	
		return ServiceReturnType.EXIT;
	}
}
