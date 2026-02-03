
public class PriorityThread extends Thread {

	public PriorityThread(String name) {
		super(name);
	}

	public static void main(String[] args) {

		PriorityThread t1 = new PriorityThread("MIN_PRIORITY");
		PriorityThread t2 = new PriorityThread("NORM_PRIORITY");
		PriorityThread t3 = new PriorityThread("MAX_PRIORITY");
		t1.setPriority(MIN_PRIORITY);
		t2.setPriority(NORM_PRIORITY);
		t3.setPriority(MAX_PRIORITY);
		t1.start();
		t2.start();
		t3.start();
	}

	@Override
	public void run() {

		for (int i = 0; i < 5; i++) {
			String s = "";
			for (int j = 0; j < 10000; j++) {
				s += "s";
			}
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