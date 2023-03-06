package locks;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;

public class ExampleReentrantLockTwo {
    public static void main(String[] args) {
        try(ExecutorService executor = Executors.newFixedThreadPool(2)) {
            ReentrantLock lock = new ReentrantLock();

            executor.submit(() -> {
                lock.lock();
                try {
                    Utils.sleep(1);
                }
                finally {
                    lock.unlock();
                }
            });

            executor.submit(() -> {
                System.out.println("Locked: " + lock.isLocked());
                System.out.println("Held by me: " + lock.isHeldByCurrentThread());
                boolean locked = lock.tryLock();
                System.out.println("Lock acquired: " + locked);
            });
        }
    }
}
