package immutable;

import java.util.Random;

public class Citizen implements Runnable {
    private final MutableIDCard id;

    public Citizen(MutableIDCard id) {
        this.id = id;
    }

    @Override
    public void run() {
        Random r = new Random();
        try {
            Thread.sleep(r.nextInt(2000));
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
        String message = "The name on this ID is " + id.getName() + "\n"
                    + "and the date of birth is " + id.getDateOfBirth() + ".";
        System.out.println(message);
    }
}
