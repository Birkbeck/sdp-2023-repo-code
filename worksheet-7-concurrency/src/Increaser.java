public class Increaser implements Runnable {
    private final Counter c;

    public Increaser(Counter counter) {
        this.c = counter;
    }

    public static void main(String[] args) {
        Counter counter = new Counter();
        for (int i = 0; i < 100; i++) {
            Increaser increaserTask = new Increaser(counter);
            Thread t = new Thread(increaserTask);
            t.start();
            System.out.println("The number of active threads: " + Thread.activeCount());
        }
    }

    @Override
    public void run() {
        System.out.println("Starting at " + c.getCount());
        for (int i = 0; i < 1000; i++) {
            try {
                Thread.sleep(10);
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
            c.increase();
        }
        System.out.println("Stopping at " + c.getCount());
    }
}

class Counter {
    private int n = 0;

    public void increase() {
        n++;
    }

    public int getCount() {
        return n;
    }
}
