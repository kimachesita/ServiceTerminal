package PetService;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Scanner;

import Server.Service;

public class PetService extends Service{
	
	
	public PetService(InputStream in,OutputStream out) {
		super(in, out);
	}

	@Override
	public int start() throws IOException {
		Scanner scanner = new Scanner(super.in);
		String input;
		Controller controller = new Controller();
	
		do {
			super.write("pet to create >> ");
			input = scanner.nextLine();
			
		}while(controller.process(input) == 0);
		
		scanner.close();
		return 0;
	}
	
}
