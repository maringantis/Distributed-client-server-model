import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class TestServerSocket1 {

	public static void main(String args[]) throws IOException {
		final int portNumber = 82;// NameServer 2 portNumber
		System.out.println("Creating server socket on port " + portNumber);
		ServerSocket serverSocket = new ServerSocket(portNumber);
		while (true) {
			Socket socket = serverSocket.accept();//Create socket named socket
			OutputStream os = socket.getOutputStream(); // Creating Output stream object named os
			PrintWriter pw = new PrintWriter(os, true);// Creating Output stream object named pw
						
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			String oper = br.readLine();
			
			pw.println("The operation searched for is : " + oper);
			
			
			if (oper.equals("/"))
			{
			final int divPort=10003;//The division port number
			System.out.println("The address is found in this name server at port: " + divPort);
			pw.println("The address is found in this name server at port: " + divPort);
			pw.println(divPort);
			}
			else if (oper.equals("%"))
			{
			final int modPort=10004;//The modulus port number
			pw.println("The address is found in this name server at port:"+modPort);
			pw.println(modPort);
			}	
			else
			pw.println("Not found");
			
			pw.close();
			socket.close();

		}
	}
}