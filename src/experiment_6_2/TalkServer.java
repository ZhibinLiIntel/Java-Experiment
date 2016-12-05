package experiment_6_2;

import java.io.*;
import java.net.*;
import java.util.*;
public class TalkServer{
	ServerSocket ss;
	Socket socket;
	static List<TalkClients> clients=new ArrayList<TalkClients>();
	TalkServer(){
		try{
			ss=new ServerSocket(8004);
		}catch(IOException e){
			e.printStackTrace();
		}
		try{
			while(true){
				socket=ss.accept();
				TalkClients tc=new TalkClients(socket);
				new Thread(tc).start();
				clients.add(tc);
			}
		}catch(IOException e){
			e.printStackTrace();
		}finally{
			try{
				ss.close();
			}catch(IOException e){
				e.printStackTrace();
			}
		}
	}
	public static void main(String args[]){
		new TalkServer();
	}
}
class TalkClients implements Runnable{
	Socket socket;
	DataInputStream dis;
	DataOutputStream dos;
	TalkClients(Socket socket){
		this.socket=socket;
	}
	public void run(){
		try{
			dis=new DataInputStream(socket.getInputStream());
			dos=new DataOutputStream(socket.getOutputStream());
		}catch(IOException e){
			e.printStackTrace();
		}
		try{
			while(true){
				String str;
				str=dis.readUTF();
				for(int i=0;i<TalkServer.clients.size();i++){
					TalkClients tc=TalkServer.clients.get(i);
					tc.dos.writeUTF(str);
				}
			}
		}catch(IOException e){
			e.printStackTrace();
		}finally{
			if(dis!=null)
				if(socket!=null)
					try {
                        dis.close();
                        socket.close();
                        dos.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
		}
	}
}

	