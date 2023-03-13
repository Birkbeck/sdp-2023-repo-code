package threadpool;

import java.util.concurrent.LinkedBlockingQueue;

public class CustomThreadPoolExample {
    public static void main(String[] args) {
        CustomThreadPool customThreadPool = new CustomThreadPool(2);

        for (int i = 1; i <= 5; i++) {
            DemoTask task = new DemoTask("Task " + i);
            System.out.println("Created: " + task.getName());

            customThreadPool.execute(task);
        }
    }
}

class CustomThreadPool {
    //Internally pool is an array
    private final WorkerThread[] workers;

    // FIFO ordering
    private final LinkedBlockingQueue<Runnable> queue = new LinkedBlockingQueue<>();

    public CustomThreadPool(int poolSize) {
        this.workers = new WorkerThread[poolSize];

        for (int i = 0; i < workers.length; i++) {
            workers[i] = new WorkerThread();
            workers[i].start();
        }
    }

    public void execute(Runnable task) {
        synchronized (queue) {
            queue.add(task);
            queue.notify();
        }
    }

    public void shutdown() {
        System.out.println("Shutting down thread pool");
        for (int i = 0; i < workers.length; i++) {
            workers[i] = null;
        }
    }

    private class WorkerThread extends Thread {
        @Override
        public void run() {

            while (true) {
                Runnable task;
                synchronized (queue) {
                    while (queue.isEmpty()) {
                        try {
                            queue.wait();
                        }
                        catch (InterruptedException e) {
                            System.out.println("An error occurred while queue is waiting: " + e.getMessage());
                        }
                    }
                    task = queue.poll();
                }

                try {
                    task.run();
                }
                catch (RuntimeException e) {
                    System.out.println("Thread pool is interrupted due to an issue: " + e.getMessage());
                }
            }
        }
    }
}