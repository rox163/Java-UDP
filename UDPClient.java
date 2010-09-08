import java.io.IOException;
import java.net.*;
import java.util.*;


public class UDPClient extends Thread {

	private DatagramSocket m_clientSocket;

	public void run() {
		
		UDPClient udpclient = new UDPClient();
		try {
			udpclient.startUDPClient();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void startUDPClient() throws IOException {

		boolean complete = false;

		m_clientSocket = new DatagramSocket(6069);
		
		while (!complete) {
			
			Scanner input = new Scanner(System.in);
			String message = new String(input.next());
			byte[] packet = message.getBytes();
			
			DatagramPacket client_packet = new DatagramPacket(packet, packet.length, InetAddress.getLocalHost(), 6067);
			
			m_clientSocket.send(client_packet);
			System.out.println("Sent!");
			
			if (message.compareTo("exit") == 0) {
				complete = true;
			}
			
		}
		
		m_clientSocket.close();
		System.out.println("Client socket closed");
	}

}
