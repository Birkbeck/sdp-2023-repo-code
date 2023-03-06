package executors;


import java.time.LocalDateTime;
import java.util.concurrent.*;

public class ScheduledExecutorServiceExample {
    public static void main(String[] args) throws InterruptedException, ExecutionException {

        //1
        try (ScheduledExecutorService executor = Executors.newScheduledThreadPool(1)) {
            System.out.println("Task scheduled to execute after 10 seconds at : " + LocalDateTime.now());
            DemoTask task = new DemoTask("App-Task");
            ScheduledFuture<?> result = executor.schedule(task, 10, TimeUnit.SECONDS);

            System.out.println("Shutdown and await requested at : " + LocalDateTime.now());
        }

        //2
        try (ScheduledExecutorService executor1 = Executors.newScheduledThreadPool(1)) {
            DemoTask task1 = new DemoTask("App-Task");
            ScheduledFuture<?> result1 = executor1.scheduleWithFixedDelay(task1, 0, 10, TimeUnit.SECONDS);
        }

        //3
        try (ScheduledExecutorService executor2 = Executors.newScheduledThreadPool(1)) {
            DemoTask task2 = new DemoTask("App-Task");
            ScheduledFuture<?> result2 = executor2.scheduleAtFixedRate(task2, 0, 10, TimeUnit.SECONDS);
        }
    }
}


class DemoTask implements Runnable {
    private final String name;

    public DemoTask(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    @Override
    public void run() {
        System.out.println("Executing : " + name);
        try {
            Thread.sleep(1000);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
