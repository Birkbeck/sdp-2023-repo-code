import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Semaphore;
import java.util.stream.Collectors;

public class DiningPhilosophersProblem {
    static int NUMBER_OF_PHILOSOPHERS = 5;

    static final List<Philosopher> philosophers = new ArrayList<>();
    static final List<Fork> forks = new ArrayList<>();

    static class Fork {
        Semaphore mutex = new Semaphore(1);

        void grab() {
            try {
                mutex.acquire();
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        void release() {
            mutex.release();
        }

        boolean isFree() {
            return mutex.availablePermits() > 0;
        }
    }

    static class Philosopher extends Thread {
        int id;
        Fork left, right;
        volatile boolean eating = false;

        Philosopher(int id, Fork left, Fork right) {
            this.id = id;
            this.left = left;
            this.right = right;
        }

        @Override
        public void run() {
            while (true) {
                left.grab();
                log("grabs left fork.");
                right.grab();
                log("grabs right fork.");
                eat();
                right.release();
                log("puts down right fork.");
                left.release();
                log("puts down left fork.");
            }
        }

        void log(String action) {
            System.out.println(System.nanoTime()  + ": Philosopher " + id +  " " + action);
        }

        void eat() {
            eating = true;
            try {
                try {
                    int sleepTime = (int) (Math.random() * 1000);
                    log("eats for " + sleepTime + "ms");
                    Thread.sleep(sleepTime);
                }
                catch (Exception e) {
                    e.printStackTrace();
                }
            }
            finally {
                eating = false;
            }
        }

        boolean isEating() { return eating; }
    }

    public static void main(String[] args) {
        for (int i = 0; i < NUMBER_OF_PHILOSOPHERS; i++) {
            forks.add(new Fork());
        }
        for (int i = 0; i < NUMBER_OF_PHILOSOPHERS; i++) {
            Fork leftFork = forks.get(i);
            Fork rightFork = forks.get((i + 1) % NUMBER_OF_PHILOSOPHERS);
            philosophers.add(new Philosopher(i + 1, leftFork, rightFork));
            //philosophers.add((i == NUMBER_OF_PHILOSOPHERS - 1)
            //        // breaking the deadlock:
            //        // the last philosopher picks up the right fork first
            //    ? new Philosopher(i + 1, rightFork, leftFork)
            //    : new Philosopher(i + 1, leftFork, rightFork));
        }

        philosophers.forEach(Thread::start);

        while (true) {
            try {
                Thread.sleep(200);

                System.out.println(System.nanoTime()  + ": Waiter checks " + getForkStatus());
                boolean allForksTaken = forks.stream().noneMatch(Fork::isFree);

                System.out.println(System.nanoTime()  + ": Waiter checks " + getPhilosopherStatus());
                boolean noOneIsEating = philosophers.stream().noneMatch(Philosopher::isEating);

                if (allForksTaken && noOneIsEating) {
                    System.out.println("Everyone is starving: " + getForkStatus() + " " + getPhilosopherStatus());
                    break;
                }
            }
            catch (Exception e) {
                e.printStackTrace(System.out);
            }
        }
        System.out.println("Enf of story");
        System.exit(0);
    }

    static private String getForkStatus() {
        return "forks " + forks.stream().map(f -> f.isFree() ? "1" : "0").collect(Collectors.joining(""));
    }

    static private String getPhilosopherStatus() {
        return "eating " + philosophers.stream().map(ph -> ph.isEating() ? "1" : "0").collect(Collectors.joining(""));
    }
}
