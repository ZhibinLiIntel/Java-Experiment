package mergeSortTest;

public class Test {
	public static void main(String[] args){
		int[] array={4,9,5,13,15,8};
		long time1=System.currentTimeMillis();
		MergeSort.sort(array);
		long time2=System.currentTimeMillis();
		System.out.println("Hello world");
		System.out.println((long)(time2-time1));
		
	}
	
}
