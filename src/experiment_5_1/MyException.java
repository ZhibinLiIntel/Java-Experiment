package experiment_5_1;

public class MyException extends Exception{
	String s;
	public MyException(String s){
		this.s=s;
	}
	public void printMessage(){
		System.out.println(s);
	}
}
