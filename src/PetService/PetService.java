package PetService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;

import Server.Service;
import Server.ServiceReturnType;

public class PetService extends Service{
	

	public IOInterface io;
	
	public PetService(InputStream in, OutputStream out) {
		super(in, out);
		io = new IOInterface(in,out);
		description = "Your One Stop Pet Experimentation Lab";
	}

	@Override
	public ServiceReturnType start() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(this.in));
		String input;
		Controller controller = new Controller(io);
	
		//show welcome message
		io.writeln("========================================================");
		io.writeln("Welcome to Pet Service.");
		io.writeln("Your one stop Pet experimentation lab");
		io.writeln("To begin, type \"help\" to see available options.");
		io.writeln("========================================================");
		io.writeln("");
		
		do {
			io.write("[Pet] pet to create >> ");
			input = br.readLine();
			
		}while(controller.process(input) == 0);
	
		return ServiceReturnType.EXIT;
	}
}
