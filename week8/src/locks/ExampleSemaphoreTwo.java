package locks;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class ExampleSemaphoreTwo {
    private static final Semaphore semaphore = new Semaphore(5);

    public static void main(String[] args) {
        try (ExecutorService executor = Executors.newFixedThreadPool(10)) {

            IntStream.range(0, 10)
                    .forEach(i -> executor.submit(ExampleSemaphoreTwo::doWork));
        }
    }

    private static void doWork() {
        boolean permit = false;
        try {
            permit = semaphore.tryAcquire(1, TimeUnit.SECONDS);
            if (permit) {
                System.out.println("Semaphore acquired by " + Thread.currentThread().getName());
                Utils.sleep(5);
            }
            else {
                System.out.println("Could not acquire semaphore: " + Thread.currentThread().getName());
            }
        }
        catch (InterruptedException e) {
            throw new IllegalStateException(e);
        }
        finally {
            if (permit) {
                semaphore.release();
            }
        }
    }
}
