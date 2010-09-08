

public class UDPManager{

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Thread server_thread = new Thread(new UDPServer(),"server_thread");
		Thread client_thread = new Thread(new UDPClient(),"client_thread");
		
		server_thread.start();
		client_thread.start();

		
	}

}
