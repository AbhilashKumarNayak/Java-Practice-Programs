package programs;

//import java.awt.PrintJob;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class PrintJob implements Runnable{
	String name;
	
	PrintJob(String name){
		this.name=name;
		//System.out.println(name);
	}

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName());
		
		
		System.out.println(this.name);
		
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
}

public class ExecutorServiceExample{
	
	
	public static void main(String[] args) {
		ExecutorService executorService=Executors.newFixedThreadPool(4);
		
		PrintJob[] printJobs= {new PrintJob("Abhilash"),new PrintJob("Abhshek"),new PrintJob("Anuj"),
				new PrintJob("Ajay"),new PrintJob("Akshay"),new PrintJob("Aman"),new PrintJob("khushi"),new PrintJob("gagan")
				,new PrintJob("urmila"),new PrintJob("aaksh"),new PrintJob("Shubham")};
		
		for(PrintJob job:printJobs) {
			executorService.submit(job);
		}
		executorService.shutdown();
		
	}

}
