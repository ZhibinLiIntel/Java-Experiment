
public class TestPartOne {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s="aBcDeF";
		char[] test=s.toCharArray();
		System.out.print(test[2]);
		if(test[3]<'E')
			System.out.print((char)(test[3]+32));
		s.toLowerCase();
	}
 
}
