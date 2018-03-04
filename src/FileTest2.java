import java.io.*;
public class FileTest2 {
	public static void main(String args[]){
		File dir,subdir;
		dir=new File(args[0]);
		
		
			    dir.mkdirs();
				System.out.println("Creadted directory:"+dir.getAbsolutePath());
				subdir=new File(dir,"newSub");
				if(subdir.mkdir()){
					System.out.println("Created subdirectory:"+subdir.getAbsolutePath());
				
				}
				else
					System.out.println("Could not create subdirectory:"+subdir.getAbsolutePath());
				
			
	}
}
