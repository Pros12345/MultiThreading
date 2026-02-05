package lock;

import java.util.concurrent.locks.ReentrantLock;

class Counter {
	private int count = 0;
	private ReentrantLock lock = new ReentrantLock();

	public void increment() {
		lock.lock(); // acquire lock
		try {
			count++;
			System.out.println(Thread.currentThread().getName() + " -> " + count);
		} finally {
			lock.unlock(); // always release lock
		}
	}
}

public class ReentrantLockBasicDemo {
	public static void main(String[] args) {
		Counter counter = new Counter();

		Runnable task = () -> {
			for (int i = 0; i < 5; i++) {
				counter.increment();
			}
		};

		Thread t1 = new Thread(task, "Thread-1");
		Thread t2 = new Thread(task, "Thread-2");

		t1.start();
		t2.start();
	}
}
