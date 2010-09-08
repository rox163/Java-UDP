import java.io.IOException;
import java.net.*;


public class UDPServer extends Thread{

	private DatagramSocket m_serverSocket;
		
	public void run() {
		
		UDPServer udpServer = new UDPServer();
		try {
			udpServer.startUDPServer();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void startUDPServer() throws IOException { 
		
		boolean complete = false;
		
		m_serverSocket = new DatagramSocket(6067);
		
		while (!complete) {

			DatagramPacket packet = new DatagramPacket(new byte[64],64);
			m_serverSocket.receive(packet);
			String message = new String(packet.getData(),0,packet.getLength());
			
			System.out.println(message);
			
			if (message.compareTo("exit") == 0) {

				complete = true;
			}
			
		}
		m_serverSocket.close();
		System.out.println("Server socket closed");
		
		
	}

}
