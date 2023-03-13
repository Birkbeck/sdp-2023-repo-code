import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ResponsiveUserInterface  {

   private final List<Integer> finishedTasks = new ArrayList<>();

   private int activeTaskCount = 0;

   public static void main(String[] args) {
       ResponsiveUserInterface ui = new ResponsiveUserInterface();
       ui.launch();
   }

   private void launch() {
       for (int i = 0; i < 10; i++) {
           reportOnFinishedTasks();
           System.out.print("Enter the duration (in ms) of task " + i + ": ");
           Scanner scanner = new Scanner(System.in);
           int duration = Integer.parseInt(scanner.nextLine());
           Runnable task = new ResponsiveUserInterfaceTask(i, duration, this);
           Thread t = new Thread(task);
           t.start();
           synchronized (this) {
               activeTaskCount++;
           }
       }
       while (!allTasksFinished()) {
           waitForAWhile();
       }
       reportOnFinishedTasks();
   }

   private synchronized void waitForAWhile() {  
       try {
           wait();
       }
       catch (InterruptedException ex) {
           ex.printStackTrace();
           // we do not wait as much, fine
       }
   }

   public synchronized boolean allTasksFinished() {
       return activeTaskCount == 0;
   }

   public synchronized void reportFinished(int id) {
       finishedTasks.add(id);
       activeTaskCount--;
       notifyAll();
   }

   private synchronized void reportOnFinishedTasks() {
       if (finishedTasks.size() == 0) {
          return;
       }
       System.out.println("Finished tasks: " + finishedTasks.stream()
               .map(Object::toString)
               .collect(Collectors.joining(", ")));
       finishedTasks.clear();
   }
}

class ResponsiveUserInterfaceTask implements Runnable {

    private final int duration;

    private final int id;

    private final ResponsiveUserInterface origin;

    public ResponsiveUserInterfaceTask(int id, int duration, ResponsiveUserInterface origin) {
        this.id = id;
        this.duration = duration;
        this.origin = origin;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(duration);
        }
        catch (InterruptedException ex) {
            ex.printStackTrace(); // we will just wait a little less
        }
        origin.reportFinished(this.id);
    }
}



