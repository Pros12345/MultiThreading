package lock;
import java.util.concurrent.locks.ReentrantLock;

class TryLockDemo {
    private ReentrantLock lock = new ReentrantLock();

    public void accessResource() {
        if (lock.tryLock()) {
            try {
                System.out.println(Thread.currentThread().getName() + " got the lock");
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        } else {
            System.out.println(Thread.currentThread().getName() + " could not get the lock");
        }
    }

    public static void main(String[] args) {
        TryLockDemo demo = new TryLockDemo();

        new Thread(demo::accessResource, "Thread-1").start();
        new Thread(demo::accessResource, "Thread-2").start();
    }
}
