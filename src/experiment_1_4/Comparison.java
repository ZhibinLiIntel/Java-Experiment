package experiment_1_4;
import java.math.BigDecimal;

class Comparison{
	int Test(int num){
		Fibonacci i=new Fibonacci();
		if(num==1||num==2)
			return 0;
		BigDecimal a1=new BigDecimal(i.Fib(num));
		BigDecimal a2=new BigDecimal(i.Fib(num+1));
		BigDecimal a3=new BigDecimal((Math.sqrt(5)-1)/2);
		String test=String.valueOf(a1.divide(a2,50,BigDecimal.ROUND_HALF_UP));
		String test2=String.valueOf(a3);
		char[] accuracy=test2.toCharArray();
		char[] array=test.toCharArray();
		int j;
		for(j=0;j<51;j++){
			if(accuracy[j]!=array[j])
				break;
		}
		return j-2;
	}
}   