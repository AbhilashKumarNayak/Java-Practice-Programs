package programs;

import java.util.concurrent.locks.ReentrantLock;

class Display{
	ReentrantLock lock=new ReentrantLock(true);
	
	/*
	 * String name;
	 * 
	 * Display(String name){ this.name=name; }
	 */
	
	public void  wish(String name) {
		
		lock.lock();
		for(int i=0;i<5;i++) {
			System.out.print("Good Morning: ");
			
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(name);
		}
		lock.unlock();
		
		System.out.println("Abhilash");
		
	}
	
}

public class ReentrantLockExample extends Thread{
	
	Display display;
	String name;
	
	@Override
	public void run() {
		this.display.wish(this.name);
	}
	
	
	
	ReentrantLockExample(Display display,String name){
		this.display=display;
		this.name=name;
	}
	
	
	public static void main(String[] args) {
		Display display1=new Display();
		//Display display1=new Display("dhoni");
		
		ReentrantLockExample reentrantLockExample1=new ReentrantLockExample(display1,"dhoni");
		ReentrantLockExample reentrantLockExample2=new ReentrantLockExample(display1,"yuvraj");
		
		reentrantLockExample1.start();
		reentrantLockExample2.start();

	}
	

}
