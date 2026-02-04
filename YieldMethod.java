

public class YieldMethod extends Thread {

    public YieldMethod(String name) {
        super(name);
    }

    public static void main(String[] args) {
        YieldMethod t1 = new YieldMethod("t1");
        YieldMethod t2 = new YieldMethod("t2");

        t1.start();
        t2.start();
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getName() + " is running");
            Thread.yield();
        }
    }
}