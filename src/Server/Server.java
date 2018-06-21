package Server;

public class Server {

	private ConnectionsManager connectionsManager;
	
	public Server(int p) {
		this.connectionsManager = new ConnectionsManager(p);
	}
	
	public void listen() {
		this.connectionsManager.listen();
	}
		
	public static void main(String[] args) {
		System.out.println("Starting Server...");
		Server server = new Server(8000);
		server.listen();
	}	
}
