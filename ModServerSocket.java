import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.util.Scanner;
public class ModServerSocket{

	public static void main(String args[]) throws IOException {
		final int portNumber = 10004;// The port number of ModServerSocket
		System.out.println("Creating mod server socket on port " + portNumber);
		ServerSocket serverSocket = new ServerSocket(portNumber);
		
		while (true) {
			Socket socket = serverSocket.accept();
			OutputStream os = socket.getOutputStream();
			PrintWriter pw = new PrintWriter(os, true);
			
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			int fnum= Integer.parseInt(br.readLine());// Typecasting the string to int
			int snum= Integer.parseInt(br.readLine());// Typecasting the string to int
			System.out.println("The numbers  to be mod are: " + fnum + " " + snum);
			pw.println("The numbers  to be mod are: " + fnum + " " + snum);
			int mod = fnum / snum;
			pw.println("Mod :  " + mod);//Returning the mod
			
			
			pw.close();
			socket.close();
			}
}
}