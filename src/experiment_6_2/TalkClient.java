package experiment_6_2;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.*;
import java.net.*;
public class TalkClient implements ActionListener,Runnable{
	Frame fr=new Frame("Chatting");
	TextField tf=new TextField();
	TextArea ta=new TextArea();
	Socket socket;
	DataInputStream dis;
	DataOutputStream dos;
	TalkClient(){
		ta.setEditable(false);
		fr.setLayout(new BorderLayout());
		fr.setSize(400, 200);
		fr.setLocation(900, 200);
		fr.setVisible(true);
		fr.add(tf,BorderLayout.SOUTH);
		fr.add(ta,BorderLayout.NORTH);
		fr.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e) {
				disconnect();
                System.exit(0);
            }
        });
		tf.addActionListener(this);
		connect();
	}
	public void connect(){
		try{
			socket=new Socket("192.168.1.103",8004);
			dis=new DataInputStream(socket.getInputStream());
			dos=new DataOutputStream(socket.getOutputStream());
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public void disconnect(){
		try{
			socket.close();
			dis.close();
			dos.close();
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	public void actionPerformed(ActionEvent e){
		String str=tf.getText();
		tf.setText("");
		try{
			dos.writeUTF(str);
			dos.flush();
		}catch(Exception e1){
			e1.printStackTrace();
		}
	}
	public void run(){
		try{
			while(true){
				String str;
				str=dis.readUTF();
				ta.setText(ta.getText()+str+'\n');
			}
		}catch(SocketException e){
			System.out.println("Client is offline");
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
	public static void main(String args[]){
		new Thread(new TalkClient()).start();
	}
}
