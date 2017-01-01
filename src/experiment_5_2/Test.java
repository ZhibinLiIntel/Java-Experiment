package experiment_5_2;

import java.util.Random;

public class Test {
	public static void main(String[] args){
		Random random=new Random();
		int length=10000;
		int[] array=new int[length];
		for(int i=0;i<length;i++){
			array[i]=random.nextInt();
		}
		long time1=System.nanoTime();
		MergeSort.mergesort(array);
		long time2=System.nanoTime();
		System.out.println("运行时间："+(long)(time2-time1));
		
	}
}
