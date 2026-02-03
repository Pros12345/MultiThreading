
public class PriorityThread extends Thread {

	public static void main(String[] args) {

		PriorityThread pt = new PriorityThread();
		pt.start();
	}

	@Override
	public void run() {

		for (int i = 0; i < 5; i++) {
			System.out.println(Thread.currentThread().getName() + " - Priority: " + Thread.currentThread().getPriority()
					+ " - Count: " + i);

			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}