//CSCC 33 A 4 - NETWORKS AND DATA COMMUNICATION
//Andrei Jan D. Lao
// Kent Delgado

package sockets.programming;

import java.net.*; 
import java.io.*; 

public class Server 
{ 
	//initialize socket and input stream 
	private Socket socket;
	private ServerSocket server;
	private DataInputStream in;

	
	// creates a server  
	public Server(int port) 
	{ 
		// starts server  
		try
		{ 
			// we start our server
			server = new ServerSocket(port); 
			System.out.println("Server started"); 

			System.out.println("Waiting for a client ..."); 

			// we accept the client in the given port
			// and create a socket
			// we now have an established connection between our client and our server on the 
			socket = server.accept(); 
			System.out.println("Client accepted"); 

			// takes input 
			in = new DataInputStream( 
				new BufferedInputStream(socket.getInputStream())); 

			String line = ""; 

			// reads message 
			while (!line.equals("Stop")) 
			{ 
				try
				{ 
					line = in.readUTF(); 
					System.out.println(line); 

				} 
				catch(IOException i) 
				{ 
					System.out.println(i); 
				} 
			} 
			System.out.println("Closing connection"); 

			// close connection 
			socket.close(); 
			in.close(); 
		} 
		catch(IOException i) 
		{ 
			System.out.println(i); 
		} 
	} 

	public static void main(String args[]) 
	{ 
		Server server = new Server(6666); 
	} 
} 
