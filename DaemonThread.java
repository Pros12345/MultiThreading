

public class DaemonThread extends Thread {

    public static void main(String[] args) {
        DaemonThread t1 = new DaemonThread();
        t1.setDaemon(true);
        t1.start();

        System.out.println("Main done");
    }

    @Override
    public void run() {
        while (true) {
            System.out.println("Hello World");
        }
    }
}