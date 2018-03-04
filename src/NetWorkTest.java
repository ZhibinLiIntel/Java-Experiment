import java.net.*;
public class NetWorkTest {
	public static void main(String args[]) throws UnknownHostException {
		InetAddress test=InetAddress.getByName("www.baidu.com");
		System.out.println(test.getHostAddress());

		byte[] addr=test.getAddress();
		System.out.println(addr);
		System.out.println(addr[3]);
		System.out.println((addr[0]&0xff)+"."+(addr[1]&0xff)+"."+(addr[2])+"."+(addr[3]));
		System.out.println(test.getHostName());
	}
}
