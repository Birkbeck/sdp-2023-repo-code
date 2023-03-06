package threadpool;

import java.util.concurrent.*;

public class BlockingThreadPoolExecutorDemo {
    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<Runnable> blockingQueue = new ArrayBlockingQueue<>(1);
        try (BlockingThreadPoolExecutor executor = new BlockingThreadPoolExecutor(1, 1, 5000, TimeUnit.MILLISECONDS, blockingQueue)) {
            executor.setRejectedExecutionHandler(new CustomRejectedExecutionHandler());

            executor.prestartAllCoreThreads();

            for (int threadCounter = 1; threadCounter < 100; threadCounter++) {
                // Adding threads one by one
                System.out.println("Adding DemoTask : " + threadCounter);
                blockingQueue.offer(new DemoTask(Integer.toString(threadCounter)));
            }

            Thread.sleep(1_000_000);
        }
    }
}

class CustomRejectedExecutionHandler implements RejectedExecutionHandler {
    @Override
    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
        try {
            Thread.sleep(1000);
            System.out.println("Try again : " + ((DemoTask) r).getName());
            executor.execute(r);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}

