public class TextLoop implements Runnable {
    public static final int COUNT = 10;

    private final String name;

    public TextLoop(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        for (int i = 0; i < COUNT; i++) {
            System.out.println("Loop:" + name + ", iteration:" + i + "");
        }
    }

    public static void main(String[] args) {
        if (args.length < 1) {
            printUsageAndExit();
        }
        switch (args[0]) {
            case "0" -> {
                for (int i = 0; i < 10; i++) {
                    Runnable r = new TextLoop("Thread " + i);
                    r.run();
                }
            }
            case "1" -> {
                for (int i = 0; i < 10; i++) {
                    Runnable r = new TextLoop("Thread " + i);
                    Thread t = new Thread(r);
                    t.start();
                }
            }
            default -> printUsageAndExit();
        }
    }

    private static void printUsageAndExit() {
        System.out.println("USAGE: java TextLoop <mode>");
        System.out.println("     mode 0: without threads");
        System.out.println("     mode 1: with threads");
        System.exit(-1);
    }
}
