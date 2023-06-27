package programs;

import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadSafePrintingExample {
	
	static boolean isThread1Turn=true;
	public static final Object lock=new Object();
	
	static int[] intArray= {1,2,3,4,5,6,7,8,9,10};
	
	private static void printOddNumber(int[] intArray2) {
            synchronized (lock) {
				if(isThread1Turn) {
					try {
						lock.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				Arrays.stream(intArray2).filter(number->number%2!=0).forEach(value->System.out.println(Thread.currentThread().getName()+" : "+value));

			}	
	}

	private static void printEvenNumber(int[] intArray2) {
		synchronized (lock) {
			if(!isThread1Turn) {
				try {
					lock.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}	
		
			
			Arrays.stream(intArray2).filter(number->number%2==0).forEach(value->System.out.println(Thread.currentThread().getName()+" : "+value));
			isThread1Turn=false;
			lock.notify();
		}
	}
	
	public static void main(String[] args) {
		
		ExecutorService executorService=Executors.newFixedThreadPool(2);
		
		Runnable runnable1=()->{
			printEvenNumber(intArray);
		};
		
		Runnable runnable2=()->{
			printOddNumber(intArray);
		};
		
		executorService.submit(runnable1);
		executorService.submit(runnable2);
		executorService.shutdown();
		
		
		
	}

	
}


