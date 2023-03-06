package locks;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.stream.IntStream;

public class ExampleSemaphore {
    private static final int NUM_INCREMENTS = 10_000;

    private static final Semaphore semaphore = new Semaphore(1);

    private static int count = 0;

    public static void main(String[] args) {
        testIncrement();
    }

    private static void testIncrement() {
        try (ExecutorService executor = Executors.newFixedThreadPool(2)) {
            IntStream.range(0, NUM_INCREMENTS)
                    .forEach(i -> executor.submit(ExampleSemaphore::increment));
        }

        System.out.println("Increment: " + count);
    }

    private static void increment() {
        boolean permit = false;
        try {
            semaphore.acquire();
            permit = true;
            count++;
        }
        catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        finally {
            if (permit) {
                semaphore.release();
            }
        }
    }
}
