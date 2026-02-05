package MultiThreading;

import java.util.Arrays;
import java.util.List;

public class ListMultiThreading extends Thread {

	private final List<Integer> list;

	private static final Object lock = new Object();
	private static boolean thread1Turn = true;

	public ListMultiThreading(List<Integer> list) {
		this.list = list;
	}

	public static void main(String[] args) {
		List<Integer> l1 = Arrays.asList(1, 3, 5, 7, 9);
		List<Integer> l2 = Arrays.asList(2, 4, 6, 8, 10);

		ListMultiThreading thread1 = new ListMultiThreading(l1);
		ListMultiThreading thread2 = new ListMultiThreading(l2);

		thread1.setName("T1");
		thread2.setName("T2");

		thread1.start();
		thread2.start();
	}

	@Override
	public void run() {
		for (Integer element : list) {
			synchronized (lock) {

				boolean myTurn = Thread.currentThread().getName().equals("T1");

				while (thread1Turn != myTurn) {
					try {
						lock.wait();
					} catch (InterruptedException e) {
						Thread.currentThread().interrupt();
					}
				}

				System.out.println(Thread.currentThread().getName() + " " + element);

				thread1Turn = !thread1Turn;
				lock.notifyAll();
			}
		}
	}
}
