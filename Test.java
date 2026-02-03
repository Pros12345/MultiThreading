
class Test extends Thread {

	@Override
	public void run() {
		super.run(); // Running
		for (;;) {
			System.out.println(Thread.currentThread().getName());
		}
	}
}