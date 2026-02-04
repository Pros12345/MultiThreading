package Synchoronization;

public class SynchronizationTest {

	public static void main(String[] args) {

		Synchronization s = new Synchronization();

		SynchronizationMyThread t1 = new SynchronizationMyThread(s);
		SynchronizationMyThread t2 = new SynchronizationMyThread(s);

		t1.start();
		t2.start();

		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println(s.getCount());
	}
}