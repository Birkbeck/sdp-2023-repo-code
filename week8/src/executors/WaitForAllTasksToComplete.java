package executors;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;
import java.util.stream.IntStream;

public class WaitForAllTasksToComplete {
    public static void main(String[] args) throws Exception {

        System.out.println("1 - Runnable and Future.get()");
        try (ExecutorService executor = Executors.newFixedThreadPool(5)) {

            List<Future<?>> futures = new ArrayList<>();
            for (int i = 1; i <= 10; i++)
                futures.add(executor.submit(new DemoRunnable(i)));

            System.out.println("###### All tasks are submitted.");

            for (Future<?> f : futures)
                f.get();

            System.out.println("###### All tasks are completed.");
        }

        System.out.println("2 - Runnable and ExecutorService.awaitTermination()");
        try (ExecutorService executor = Executors.newFixedThreadPool(5)) {

            for (int i = 1; i <= 10; i++)
                executor.submit(new DemoRunnable(i));

            System.out.println("###### All tasks are submitted.");
        }
        System.out.println("###### All tasks are completed.");


        System.out.println("3 - Callable");
        List<Future<Integer>> listOfFutures;
        try (ExecutorService executor = Executors.newFixedThreadPool(10)) {

            List<DemoCallable> tasks = IntStream.rangeClosed(1, 10)
                    .mapToObj(i -> new DemoCallable(i))
                    .toList();

            System.out.println("###### Submitting all tasks.");

            listOfFutures = executor.invokeAll(tasks);
        }
        System.out.println("###### All tasks are completed. Results: ");
        for (Future<Integer> f : listOfFutures)
            System.out.print(f.get() + " ");
        System.out.println();

        System.out.println("4-ExecutorCompletionService");
        try (ExecutorService executor = Executors.newFixedThreadPool(10)) {
            CompletionService<Integer> service
                    = new ExecutorCompletionService<>(executor);

            listOfFutures = IntStream.rangeClosed(1, 10)
                    .mapToObj(i -> new DemoCallable(i))
                    .map(task -> service.submit(task))
                    .toList();
        }

        System.out.println("###### All tasks are completed. Results: ");
        for (Future<Integer> f : listOfFutures)
            System.out.print(f.get() + " ");
        System.out.println();
    }
}

class DemoRunnable implements Runnable {
    private final int jobNum;

    DemoRunnable(int jobNum) {
        this.jobNum = jobNum;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(new Random(0).nextLong(1000));
        }
        catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("DemoRunnable completed for index : " + jobNum);
    }
}

class DemoCallable implements Callable<Integer> {
    private final int jobNum;

    DemoCallable(int jobNum) {
        this.jobNum = jobNum;
    }

    @Override
    public Integer call() throws Exception {
        try {
            Thread.sleep(new Random(0).nextLong(1000));
        }
        catch (InterruptedException ex) {
            throw new RuntimeException();
        }
        System.out.println("DemoCallable completed for job number : " + jobNum);
        return jobNum;
    }
}