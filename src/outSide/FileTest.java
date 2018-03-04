package outSide;
import java.io.*;
public class FileTest{
   public static void main(String[] args) throws IOException {
       String fileName="d:/test.txt";
       File f=new File(fileName);
       InputStream in=new FileInputStream(f);
       byte[] b=new byte[1024];
       in.read(b);
       in.close();
       System.out.println(new String(b));
    }
}