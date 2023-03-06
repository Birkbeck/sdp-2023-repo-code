package threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class SyncProblems {
    private static int count = 0;

    public static void main(String[] args) {
        for (int x = 0; x < 10; x++) {
            addNumbersInParallel();
        }
    }

    static void addNumbersInParallel() {
        count = 0;
        try (ExecutorService executor = Executors.newFixedThreadPool(2)) {

            IntStream.range(0, 10_000)
                    .forEach(i -> executor.submit(SyncProblems::increment));
        }

        System.out.println(count);  // 9965
    }

    static void increment() {
        count++;
    }

    synchronized static void incrementSync() {
        count++;
    }

}
