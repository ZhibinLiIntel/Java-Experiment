package experiment_6_1;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.*;
import java.net.UnknownHostException;
import java.net.*;
public class Client {

	public static void main(String[] args) throws UnknownHostException,
	IOException {
		// TODO Auto-generated method stub

		Socket s = new Socket("192.168.1.113", 8001);

		InputStream is = s.getInputStream();
		OutputStream os = s.getOutputStream();

		PrintWriter pw = new PrintWriter(os);
		DataInputStream dis = new DataInputStream(is);

		System.out.println(dis.readLine());

		pw.println("hello...");
		pw.flush();

		is.close();
		os.close();
		s.close();

	}

}
