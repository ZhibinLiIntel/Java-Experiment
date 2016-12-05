package experiment_5_1;

public class Exception_Handling {
	public Exception_Handling(){
		try{
			int a[]=new int[2];
			a[4]=3;
		}
		catch(IndexOutOfBoundsException e){
			System.out.println("Exception msg:"+e.getMessage());
			System.out.println("Exception string:"+e.toString());
			e.printStackTrace();
		}
		finally{
			System.out.println("--------");
			System.out.println("finally");
		}
    }
public static void main(String args[]){
		new Exception_Handling();
	}
}

