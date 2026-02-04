package Synchoronization;

public class SynchronizationMyThread extends Thread {

	private Synchronization synchronization;

	public SynchronizationMyThread(Synchronization synchronization) {
		this.synchronization = synchronization;
	}

	@Override
	public void run() {
		for (int i = 0; i < 10000; i++) {
			synchronization.increment();
		}
	}
}