package programs;

public class PingPong {
    private static final Object lock = new Object(); // Object used for synchronization
    
    public static void main(String[] args) {
        Thread pingThread = new Thread(new PingRunnable());
        Thread pongThread = new Thread(new PongRunnable());
        
        pingThread.start();
        pongThread.start();
    }
    
    static class PingRunnable implements Runnable {
        @Override
        public void run() {
            synchronized (lock) {
                try {
                    for (int i = 0; i < 10; i++) {
                        System.out.println("Ping");
                        lock.notify(); // Notify other thread to proceed
                        lock.wait(); // Wait for other thread to notify
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    
    static class PongRunnable implements Runnable {
        @Override
        public void run() {
            synchronized (lock) {
                try {
                    for (int i = 0; i < 10; i++) {
                        System.out.println("Pong");
                        lock.notify(); // Notify other thread to proceed
                        lock.wait(); // Wait for other thread to notify
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

