//CSCC 33 A 4 - NETWORKS AND DATA COMMUNICATION
//Andrei Jan D. Lao
// Kent Delgado

package sockets.programming;



import java.net.*; 
import java.io.*; 

public class Client 
{ 
	// We initialize
	// we will take the input
	private Socket socket;
	private BufferedReader input;
	private DataOutputStream out;

	// constructor that takes the IP Address and the Port
	public Client(String address, int port) 
	{ 
		//create a connection 
		try
		{ 
			//socket
			socket = new Socket(address, port); 
			System.out.println("Connected"); 

			//input reader 
			input = new BufferedReader(new InputStreamReader(System.in));

			//output
			out = new DataOutputStream(socket.getOutputStream()); 
		} 
		catch(UnknownHostException u) 
		{ 
			System.out.println(u); 
		} 
		catch(IOException i) 
		{ 
			System.out.println(i); 
		} 

		// read message from input
		String line = ""; 

		//stops the reading 
		while (!line.equals("Stop")) 
		{ 
			try
			{ 
				line = input.readLine(); 
				
				out.writeUTF(line); 
			} 
			catch(IOException i) 
			{ 
				System.out.println(i); 
			} 
		} 

		//close 
		try
		{ 
			input.close(); 
			out.close(); 
			socket.close(); 
		} 
		catch(IOException i) 
		{ 
			System.out.println(i); 
		} 
	} 

	public static void main(String args[]) 
	{ 
		Client client = new Client("127.0.0.1", 6666); 
	} 
} 
