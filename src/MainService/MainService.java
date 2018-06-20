package MainService;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Scanner;
import Server.Service;

public class MainService extends Service {
	

	private HashMap<String,Service> directory = new HashMap<>();
	
	public MainService(InputStream in,OutputStream out) {
		super(in,out);
	}
	
	//populate local directory copy
	public void setDirectory(HashMap<String,Service> d) {
		directory = d;
	}
	
	@Override
	public int start() throws IOException {
		Scanner scanner = new Scanner(super.in);
		String input;
		Controller controller = new Controller(directory);
		
		super.write("=============================================\n");
		super.write("Welcome to Service Terminal\n");
		super.write("Type: \"show\" to show available options.\n");
		
		do {
			super.write("Enter your option here >>");
			input = scanner.nextLine();
		}while(controller.process(input) == 0);
		scanner.close();
		return 0;
	}
	
}
