package no.hvl.dat110.messaging;


import java.io.IOException;

import java.net.Socket;
import java.net.UnknownHostException;

public class MessagingClient {
	
	private String server;
	private int port;
	
	public MessagingClient(String server, int port) {
		this.server = server;
		this.port = port;
	}
	
	// connect to messaging server
	
	public Connection connect () {
			
		Socket clientSocket = null;
		Connection connection = null;
		
		// TODO - START
		// create TCP socket for client and connection
		
		try {
		
			clientSocket = new Socket(server, port); //lage socket
			
			connection = new Connection(clientSocket);//koble socket
			
		} catch (IOException e) {
		
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// TODO - END
		return connection;
	}
}
