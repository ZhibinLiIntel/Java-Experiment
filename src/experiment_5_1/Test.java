package experiment_5_1;

public class Test {

	public static void main(String[] args){
		try{
			throw new MyException("This is my own exception.");
		}
		catch(MyException e){
			e.printMessage();
		}
	}

}
