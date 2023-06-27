package programs;

public class DeadlockExample {
	
	
	
	public static void main(String[] args) {
		
		final Object resource1=new Object();
		final Object resource2=new Object();
		
		Thread thread1=new Thread(()->{
			synchronized (resource1) {
				System.out.println("Thread 1 acquired Resource 1");
				
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				synchronized (resource2){ 
				System.out.println("Thread 1 acquired Resource 2");
				}
			}
		});
		
		Thread thread2=new Thread(()->{
			synchronized (resource2) {
				System.out.println("Thread 2 acquired Resource 2");
				
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				synchronized (resource1){ 
				System.out.println("Thread 2 acquired Resource 1");
				}
			}
		});
		
		thread1.start();
		thread2.start();

		
	}

}
