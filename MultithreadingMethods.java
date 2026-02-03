
public class MultithreadingMethods extends Thread {

	public static void main(String[] args) throws InterruptedException {

		MultithreadingMethods t1 = new MultithreadingMethods();

		t1.start();

		t1.join();

		System.out.println("Hello");
	}

	@Override

	public void run() {

		System.out.println("Thread is running...");

		for (int i = 0; i <= 5; i++) {

			try {

				Thread.sleep(5000);

			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			System.out.println(i);
		}
	}
}