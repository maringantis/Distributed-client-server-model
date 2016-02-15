import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class TestServerSocket {

	public static void main(String args[]) throws IOException {
		final int portNumber = 81; // NameServer 1 portNumber
		final int ns2portNumber = 82; // NameServer 2 portNumber
		final String host = "localhost"; //Name of the host
		System.out.println("Creating server socket on port " + portNumber);
		ServerSocket serverSocket = new ServerSocket(portNumber);
		
		
		
		while (true) {
			Socket socket = serverSocket.accept(); //Create socket named socket
			OutputStream os = socket.getOutputStream(); // Creating Output stream object named os
			PrintWriter pw = new PrintWriter(os, true); // Creating Output stream object named pw
			
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			int fnum= Integer.parseInt(br.readLine()); //First number
			int snum= Integer.parseInt(br.readLine());// Second number
			
			pw.println("The entered numbers are: " + fnum + " " + snum);
			
			String oper = br.readLine();

			pw.println("The entered operation is " + oper);
			
			// Comparing the operation 
			
			if (oper.equals("+")) 
			{
			final int addPort=10000; // Port number of addition 
			System.out.println("The operation requested is: " + oper);
			System.out.println("The address is found in this name server at port: " + addPort);
			pw.println("The address is found in this name server at port: " + addPort);
			pw.println(addPort);
			}
			else if (oper.equals("-")) 
			{
			 final int subPort=10001;// Port number of subtraction
			 System.out.println("The operation requested is: " + oper);
			System.out.println("The address is found in this name server at port:"+subPort);
			pw.println("The address is found in this name server at port:"+subPort);
			pw.println(subPort);
			}
			else if (oper.equals("*"))
			{
			final int mulPort=10002;// Port number of multipilcation
			System.out.println("The operation requested is: " + oper);
			System.out.println("The address is found in this name server at port:" +mulPort);
			pw.println("The address is found in this name server at port:" +mulPort);
			pw.println(mulPort);
			}
			
			else if (oper.equals("/"))
			{
			System.out.println("The address is found in this name server will search in nameserver 2 and return the port number is available");
			pw.println("The address is found in this name server will search in nameserver 2 and return the port number is available");
			{
			Socket nameSocket = new Socket(host, ns2portNumber);
					PrintWriter out1 = new PrintWriter(nameSocket.getOutputStream(), true);
					out1.println(oper);
					BufferedReader br2 = new BufferedReader(new InputStreamReader(nameSocket.getInputStream()));
					System.out.println("NameServer 2 says:" + br2.readLine());
					System.out.println("NameServer 2 says:" + br2.readLine());
					int divPort= Integer.parseInt(br2.readLine());
					System.out.println("divPort:"+divPort);
					pw.println(divPort);
					nameSocket.close();
			}
			
			}
			else if (oper.equals("%"))
			{
			System.out.println("The address is found in this name server will search in nameserver 2 and return the port number is available");
			pw.println("The address is found in this name server will search in nameserver 2 and return the port number is available");
			{
			Socket modnameSocket = new Socket(host, ns2portNumber);
					PrintWriter out2 = new PrintWriter(modnameSocket.getOutputStream(), true);
					out2.println(oper);
					BufferedReader br3 = new BufferedReader(new InputStreamReader(modnameSocket.getInputStream()));
					System.out.println("NameServer 2 says:" + br3.readLine());
					System.out.println("NameServer 2 says:" + br3.readLine());
					int modPort= Integer.parseInt(br3.readLine());
					System.out.println("modPort:"+modPort);
					pw.println(modPort);
					modnameSocket.close();			
			}
			}
				
			else
			pw.println("Not found");
			
			pw.close();
			socket.close();

		}
	}
	}
