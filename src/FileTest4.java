import java.io.*;
public class FileTest4 {
	public static void main(String args[]){
		File file=new File(args[0]);
		try{
			FileInputStream in=new FileInputStream(file);
			int c;
			int i=0;
			while((c=in.read())>-1){
				if((char)c=='\n')
					i++;
				System.out.print((char)c);
			}
			in.close();
			System.out.flush();
			System.out.println("\n\n\n-----------");
			System.out.println("File"+args[0]+"Lines:"+i);
		}
		catch(FileNotFoundException e){
			System.err.println(file+"is not found");
		}
		catch(IOException e){
			e.printStackTrace();
		}
	}
}
