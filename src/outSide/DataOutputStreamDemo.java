package outSide;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
  
public class DataOutputStreamDemo{
   public static void main(String[] args) throws IOException{
       File file = new File("D:/test.txt");
       DataInputStream input = new DataInputStream(new FileInputStream(file));
       char[] ch = new char[20];
       int count = 0;
       char temp;
       while((temp = input.readChar()) != '.'){
           ch[count++] = temp;
       }
       input.close();
       System.out.println(ch);
    }
}
