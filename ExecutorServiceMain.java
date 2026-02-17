
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ExecutorServiceMain {

	public static void main(String[] args) throws InterruptedException {

		long startTime = System.currentTimeMillis();
		ExecutorService executorService = Executors.newFixedThreadPool(2);

		for (int i = 1; i <= 1000; i++) {
			int finalI = i;

			executorService.submit(() -> {
				long result = 0;
				try {
					result = factorial(finalI);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println(result);
			});
		}

		executorService.shutdown();
		executorService.awaitTermination(100, TimeUnit.SECONDS);

		System.out.println("Total time: " + (System.currentTimeMillis() - startTime));
	}

	private static long factorial(int n) throws InterruptedException {
		Thread.sleep(1000);
		long result = 1;

		for (int i = 1; i <= n; i++) {
			result *= i;
		}
		return result;
	}
}
