import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;
import java.io.OutputStream;
import java.net.ServerSocket;

public class TestClientSocket {
		
	public static void main(String args[]) throws IOException {
		final String host = "localhost"; // Name of the host
		final int portNumber = 81;// Port numbe of NameServer 1
		System.out.println("Creating socket to '" + host + "' on port " + portNumber);
		Socket socket;
			try{

		while (true) {
		
			socket = new Socket(host, portNumber);
			Scanner in = new Scanner(System.in);
			PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
			

			System.out.println("Enter the numbers");//Taking the Inputs
			String fnum= in.nextLine();// First Number
			String snum= in.nextLine();// Second Number
			out.println(fnum);
			out.println(snum);
			

			System.out.println("Enter the operation:"); //Taking the Inputs
			String oper= in.nextLine();
			out.println(oper);
			
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));// Creating buffered reader object br


			System.out.println("NameServer1 says:" + br.readLine());
			
		
			
			System.out.println("NameServer1 says:" + br.readLine());
			System.out.println("NameServer1 says:" + br.readLine());
			
			int otherPort= Integer.parseInt(br.readLine());// Typecasting the string to int
			
			System.out.println("Connecting to Add server at port:" + otherPort);
				if (otherPort == 10000)// Connecting to port 10000
					{
					Socket addSocket = new Socket(host, otherPort);
					PrintWriter out1 = new PrintWriter(addSocket.getOutputStream(), true);
					out1.println(fnum);
					out1.println(snum);
					BufferedReader br1 = new BufferedReader(new InputStreamReader(addSocket.getInputStream()));
					System.out.println("AddServer says:" + br1.readLine());
					System.out.println("AddServer says:" + br1.readLine());
					addSocket.close();
					}
					else if (otherPort == 10001)// Connecting to port 10001
					{
					Socket subSocket = new Socket(host, otherPort);
					PrintWriter out1 = new PrintWriter(subSocket.getOutputStream(), true);
					out1.println(fnum);
					out1.println(snum);
					BufferedReader br2 = new BufferedReader(new InputStreamReader(subSocket.getInputStream()));
					System.out.println("SubServer says:" + br2.readLine());
					System.out.println("SubServer says:" + br2.readLine());
					subSocket.close();
					}
					else if (otherPort == 10002)// Connecting to port 10002
					{
					
					Socket mulSocket = new Socket(host, otherPort);
					PrintWriter out1 = new PrintWriter(mulSocket.getOutputStream(), true);
					out1.println(fnum);
					out1.println(snum);
					BufferedReader br2 = new BufferedReader(new InputStreamReader(mulSocket.getInputStream()));
					System.out.println("MulServer says:" + br2.readLine());
					System.out.println("MulServer says:" + br2.readLine());
					mulSocket.close();
					}
					else if (otherPort == 10003)// Connecting to port 10003
					{
					Socket divSocket = new Socket(host, otherPort);
					PrintWriter out1 = new PrintWriter(divSocket.getOutputStream(), true);
					out1.println(fnum);
					out1.println(snum);
					BufferedReader br3 = new BufferedReader(new InputStreamReader(divSocket.getInputStream()));
					System.out.println("DivServer says:" + br3.readLine());
					System.out.println("SubServer says:" + br3.readLine());
					divSocket.close();
					}
					else if (otherPort == 10004)// Connecting to port 10005
					{
					Socket modSocket = new Socket(host, otherPort);
					PrintWriter out2 = new PrintWriter(modSocket.getOutputStream(), true);
					out2.println(fnum);
					out2.println(snum);
					BufferedReader br4 = new BufferedReader(new InputStreamReader(modSocket.getInputStream()));
					System.out.println("ModServer says:" + br4.readLine());
					System.out.println("ModServer says:" + br4.readLine());
					modSocket.close();
					}
					
					
			
				socket.close();// Close the socket
			}
				
			
		}
		catch(NumberFormatException ne)// Catch the excecption
	{
	
	//System.out.println("Exception is:" + ne);
	}
	
	}
}