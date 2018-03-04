package outSide;

import java.io.*;
class hello{
   public static void main(String[] args) throws IOException {
       String fileName="D:/test.txt";
       File f=new File(fileName);
       
       Reader read=new FileReader(f);
       int count1=0;
       int temp;
       while((temp=read.read())!=-1){
    	   if(temp<'\u4e00'||temp>'\u9fa5'){
    		   count1++;
    	   }
    	   
       }
       read.close();
       System.out.println("读入的长度为："+count1);
    }
}