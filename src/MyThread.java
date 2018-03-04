public class MyThread{
	public MyThread(){
		FirstThread first=new FirstThread();
		SecondThread second=new SecondThread();
		first.start();
		second.start();
	}
	public static void main(String args[]){
		new MyThread();
	}
}
class FirstThread extends Thread{
	public void run(){
			System.out.println("First thread starts running.");
			for(int i=0;i<10;i++){
				System.out.println("First"+i);
				
			}
			System.out.println("First thread finishes running.");
	
	}
}
class SecondThread extends Thread{
	public void run(){
	
			System.out.println("Second thread starts running.");
			for(int i=0;i<10;i++){
				System.out.println("Second"+i);
				
			}
			System.out.println("Second thread finishes running.");

	}
}