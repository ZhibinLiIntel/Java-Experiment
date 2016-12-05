package experiment_1_4;
public class Test {
	public static void main(String args[]){
		Comparison test=new Comparison();
		for(int i=1;i<40;i++)
		{
			System.out.print("("+i+","+test.Test(i)+")");
			System.out.print(" ");
		}
	}
}