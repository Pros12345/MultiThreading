package lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class FairedLock {

	private final Lock unfairLock = new ReentrantLock(true);

	public void accessResources() {
		unfairLock.lock();

		try {
			System.out.println(Thread.currentThread().getName() + " aquired the lock");
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		} finally {
			System.out.println(Thread.currentThread().getName() + " release the lock");
			unfairLock.unlock();
		}
	}

	public static void main(String[] args) {

		FairedLock fairedLock = new FairedLock();

		Runnable task = new Runnable() {
			@Override
			public void run() {
				fairedLock.accessResources();
			}
		};

		Thread thread1 = new Thread(task, "Thread 1");
		Thread thread2 = new Thread(task, "Thread 2");
		Thread thread3 = new Thread(task, "Thread 3");

		thread1.start();
		try {
			Thread.sleep(50);
			thread2.start();
			Thread.sleep(50);
			thread3.start();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
