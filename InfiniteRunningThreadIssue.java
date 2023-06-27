package programs;



class MyThread {
    private boolean isReady = false;

    public synchronized void waitForSignal() {
        while (!isReady) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        // Continue with the rest of the work after Thread A notifies
        System.out.println("Thread B: Received signal from Thread A");
    }

    public synchronized void signal() {
        isReady = true;
        notify();
        // Thread A has signaled Thread B
        System.out.println("Thread A: Signaled Thread B");
    }
}

class ThreadA extends Thread {
    private MyThread myThread;

    public ThreadA(MyThread myThread) {
        this.myThread = myThread;
    }

    public void run() {
        while (true) {
            // Do some work
            myThread.signal();
            // Do some more work
            try {
                Thread.sleep(2000); // Sleep for 2 seconds before signaling again
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class ThreadB extends Thread {
    private MyThread myThread;

    public ThreadB(MyThread myThread) {
        this.myThread = myThread;
    }

    public void run() {
        // Do some work
        myThread.waitForSignal();
        // Continue with the remaining code after Thread A notifies
        System.out.println("Thread B: Resuming execution");
    }
}

public class InfiniteRunningThreadIssue {
    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        ThreadA threadA = new ThreadA(myThread);
        ThreadB threadB = new ThreadB(myThread);

        threadA.start();
        threadB.start();
    }
}

