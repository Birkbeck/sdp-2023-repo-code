package atomic;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

public class Atom {

    private static final int NUM_INCREMENTS = 1000;

    private static final AtomicInteger atomicInt = new AtomicInteger(0);

    public static void main(String[] args) {
        testIncrement();
        testAccumulate();
        testUpdate();
    }

    private static void testIncrement() {
        atomicInt.set(0);

        try (ExecutorService executor = Executors.newFixedThreadPool(2)) {

            IntStream.range(0, NUM_INCREMENTS)
                    .forEach(i -> executor.submit(atomicInt::incrementAndGet));
        }

        System.out.format("Increment: expected=%d; is=%d\n", NUM_INCREMENTS, atomicInt.get());
    }

    private static void testAccumulate() {
        atomicInt.set(0);

        try (ExecutorService executor = Executors.newFixedThreadPool(2)) {

            IntStream.range(0, NUM_INCREMENTS)
                    .<Runnable>mapToObj(i -> (() ->
                                atomicInt.accumulateAndGet(i, (n, m) -> n + m)))
                    .forEach(executor::submit);
        }

        System.out.format("Accumulate: %d\n", atomicInt.get());
    }

    private static void testUpdate() {
        atomicInt.set(0);

        try (ExecutorService executor = Executors.newFixedThreadPool(2)) {

            IntStream.range(0, NUM_INCREMENTS)
                    .<Runnable>mapToObj(i -> (() ->
                            atomicInt.updateAndGet(n -> n + 2)))
                    .forEach(executor::submit);
        }

        System.out.format("Update: %d\n", atomicInt.get());
    }
}