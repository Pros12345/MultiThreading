
public class ThreadLifeCycle extends Thread {

	public static void main(String[] args) throws InterruptedException {

		ThreadLifeCycle threadLifeCycle = new ThreadLifeCycle();

		System.out.println(threadLifeCycle.getState()); // NEW
		threadLifeCycle.start();
		System.out.println(threadLifeCycle.getState()); // RUNNABLE

		Thread.sleep(100);
		System.out.println(threadLifeCycle.getState()); // TIMED_WAITING / RUNNABLE

		threadLifeCycle.join();
		System.out.println(threadLifeCycle.getState()); // TERMINATED
	}

	@Override
	public void run() {
		System.out.println("RUNNING");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			System.out.println(e);
		}
	}
}