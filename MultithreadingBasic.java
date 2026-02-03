
public class MultithreadingBasic {

	public static void main(String[] args) {

		// creating normal thread
		Test t = new Test();
		Thread t1 = new Thread(t);
		t1.start();

		for (;;) {
			System.out.println(Thread.currentThread().getName());
		}
	}
}