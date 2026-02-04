

public class Interrupted extends Thread {

    public static void main(String[] args) {
        Interrupted t1 = new Interrupted();
        t1.start();
        t1.interrupt();
    }

    @Override
    public void run() {
        try {
            Thread.sleep(100);
            System.out.println("Thread is running...");
        } catch (InterruptedException e) {
            System.out.println("Thread Interrupted: " + e);
        }
    }
}