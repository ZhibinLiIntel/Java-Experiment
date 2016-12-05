package experiment_6_1;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.io.*;
public class Server {
	public static void main(String args[])throws IOException{
		
		ServerSocket ss=new ServerSocket(9001);
		Socket socket=ss.accept();
		InputStream in=socket.getInputStream();
		OutputStream out=socket.getOutputStream();
		System.out.println();
	}
}
