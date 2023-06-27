package programs;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PrintingEvenOddByTwoThreads {
	
	public synchronized void printEven(int[] intArray) {
		Arrays.stream(intArray).filter(number->number%2==0).forEach(value1->System.out.println("thread 1 "+value1));

	}
public synchronized void printOdd(int[] intArray) {
	Arrays.stream(intArray).filter(number->number%2!=0).forEach(value2->System.out.println("thread 2 "+value2));

	}
	
	public static void main(String[] args) {
		PrintingEvenOddByTwoThreads byTwoThreads=new PrintingEvenOddByTwoThreads();
		ExecutorService executorService=Executors.newFixedThreadPool(2);
	 
		Scanner scanner=new Scanner(System.in);
		
		System.out.println("enter length");
		
		int length=scanner.nextInt();
		
		scanner.close();
		
		int[] intArray=new int[length];
		int value=1;
		
		for(int i=0;i<length;i++) {
			intArray[i]=value;
			value++;
		}
		
		Arrays.stream(intArray).forEach(System.out::println);
		
		Runnable runnableTask1=()->{
			byTwoThreads.printEven(intArray);
		};
		Runnable runnableTask2=()->{
			byTwoThreads.printOdd(intArray);	
};
		
		executorService.submit(runnableTask1);
		executorService.submit(runnableTask2);

	

		
	}

}
