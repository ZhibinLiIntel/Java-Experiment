public class TestException{
	public TestException(){
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
		System.out.println("No Exception?");
	}
public static void main(String args[]){
		new TestException();
	}
}