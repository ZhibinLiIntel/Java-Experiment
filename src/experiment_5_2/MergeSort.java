package experiment_5_2;

import java.util.concurrent.CountDownLatch;

public class MergeSort {
	static void merge(int low,int high,int[] array){
		if(low<high){
			int mid=(low+high)/2;
			merge(low,mid,array);
			merge(mid+1,high,array);
			sort(low,mid,high,array);
		}
	}
	static void sort(int low,int mid,int high,int[] array){
		int i=low;
		int j=mid+1;
		int k=0;
		int[] tmp=new int[array.length];
		while(i<=mid&&j<=high){
			if(array[i]<=array[j])
				tmp[k++]=array[i++];	
			else
				tmp[k++]=array[j++];
		}
		while(i<=mid)
			tmp[k++]=array[i++];
		while(j<=high)
			tmp[k++]=array[j++];
		for(k=0,i=low;i<=high;i++,k++){
			array[i]=tmp[k];
		}
	}
	static void mergesort(int[] array){
		CountDownLatch latch=new CountDownLatch(2);
		int mid=array.length/2;
		new Thread(new Runnable(){
			public void run(){
				merge(0,mid,array);
				latch.countDown();
			}
		}).start();
		new Thread(new Runnable(){
			public void run(){
				merge(mid+1,array.length-1,array);
				latch.countDown();
			}
		}).start();
		try {
			latch.await();
			sort(0,mid,array.length-1,array);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	
	}
}
