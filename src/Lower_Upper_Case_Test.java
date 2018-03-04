class Transform{
	void Upper_To_Lower(String s){
		char[] test=s.toCharArray();
		for(int i=0;i<test.length;i++)
		{
			if('A'<=test[i]&&test[i]<='Z')
				test[i]=(char)(test[i]+32);
			System.out.print(test[i]);
		}
	}
	void Lower_To_Upper(String s){
		char[] test=s.toCharArray();
		for(int i=0;i<test.length;i++)
		{
			if('a'<=test[i]&&test[i]<='z')
				test[i]=(char)(test[i]-32);
			System.out.print(test[i]);
		}
	}
}
public class Lower_Upper_Case_Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s="AbCdEfG";
		Transform b=new Transform();
		b.Upper_To_Lower(s);
		System.out.println("");
		b.Lower_To_Upper(s);
	}

}
