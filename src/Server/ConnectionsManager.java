package Server;

import java.io.IOException;
import java.net.*;
import java.util.ArrayList;

public class ConnectionsManager {
	private ArrayList<Connection> connectionList = new ArrayList<>();
	private ServerSocket serverSocket;
	
	ConnectionsManager(int p){
		try {
			serverSocket = new ServerSocket(p);
		} catch (IOException e) {
			System.out.println("Server Error: Cannot Start Server at Port " + p);
		}
	}
	
	public void listen() {
		//listen for new connections
		connectionList.add(new Connection());
		//while(true);
	}
}
