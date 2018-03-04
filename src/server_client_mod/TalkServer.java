package server_client_mod;
import java.io.*;
import java.net.*;
import java.applet.Applet;
import java.awt.*;
public class TalkServer {
	public static void main(String args[]){
		Frame frame=new Frame("ÁÄÌì");
		Panel p=new Panel();
		frame.setLayout(new BorderLayout());
		frame.add(p);
		frame.setSize(400,300);
		frame.setVisible(true);
		TextField tf=new TextField(20);
		p.add(tf);
		
		try{
			ServerSocket server=null;
			try{
				server=new ServerSocket(9006);
			}catch(Exception e){
				System.out.println("cannot listen to:"+e);
			}
			Socket socket=null;
			try{
				socket=server.accept();
			}catch(Exception e){
				System.out.println("Error."+e);
			}
			String line;
			BufferedReader is=new BufferedReader(new InputStreamReader(socket.getInputStream()));
			PrintWriter os=new PrintWriter(socket.getOutputStream());
			BufferedReader sin=new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Client:"+is.readLine());
			line=sin.readLine();
			while(!line.equals("bye")){
				os.println(line);
				os.flush();
				System.out.println("Server:"+line);
				System.out.println("Client:"+is.readLine());
				line=sin.readLine();
			}
			os.close();
			is.close();
			socket.close();
			server.close();
		}catch(Exception e){
			System.out.println("Error:"+e);
		}
	}
}
