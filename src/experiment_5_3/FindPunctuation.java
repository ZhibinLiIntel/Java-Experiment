package experiment_5_3;

import java.io.*;

public class FindPunctuation {
	 public static void main(String[] args) throws IOException {
	       String fileName="D:/JAVA/ÊµÑé/°×Ò¹ÐÐ.txt";
	       FileInputStream inputstream=new FileInputStream(fileName);
	       InputStreamReader reader=new InputStreamReader(inputstream,"UTF-8");
	       int temp=0;
	       int count=0;
	       char[] ch=new char[10000];
	       while((temp=reader.read())!=-1){
	    	if((char)temp=='£¬'||(char)temp=='¡£'||(char)temp=='£¿'||(char)temp=='¡°'||(char)temp=='¡±'||(char)temp=='£º'||(char)temp=='£¨'||(char)temp=='£©'||(char)temp=='¡¢')
	    		count++;
	       }
	       reader.close();
	       System.out.println(count);
	    }
}
