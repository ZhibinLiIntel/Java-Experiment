package mergeSortTest;

import java.util.concurrent.CountDownLatch;

public class TestMergeSort{
	public static void main(String args[]){
		int[] array={2,7,3,4,5,0};
		int mid=array.length/2;
		int[] a1=new int[mid];
		int[] a2=new int[mid];
		for(int i=0;i<mid;i++){
			a1[i]=array[i];
			
		}
		for(int j=mid;j<array.length;j++){
			a2[j-a1.length]=array[j];
	
		}
		try{
		CountDownLatch latch = new CountDownLatch(2);  
	new Thread(new Runnable(){  
        public void run() {  
            MergeSort.sort(a1);    
        }
    }).start();  
	new Thread(new Runnable(){  
        public void run() {  
            MergeSort.sort(a2);    
        }
    }).start();  
	latch.await();  
	merge(a1,a2,array);
		}
		catch(InterruptedException e){
			for(int i=0;i<array.length;i++){
				System.out.println(array[i]);
			}
		}
	
}
	
private static void merge(int[] a1, int[] a2, int[] tmpArray){  
        int length1 = a1.length;  
        int length2 = a2.length;  
  
        int left = 0;  
        int right = 0;  
        int pos = 0;  
  
        while(left < length1 && right < length2){  
            if(a1[left] <= a2[right]){  
                tmpArray[pos] = a1[left];  
                left++;  
            }else{  
                tmpArray[pos] = a2[right];  
                right++;  
            }  
            pos++;  
        }  
        while(left < length1){  
            tmpArray[ pos++ ] = a1[ left++ ];  
        }  
  
        while(right < length2){  
            tmpArray[ pos++ ] = a2[ right++ ];  
        }  
    }  
	
}
  
