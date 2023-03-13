package immutable;

import immutable.DataGenerator;
import immutable.MutableIDCard;

import java.util.Date;
import java.util.Random;

class Officer implements Runnable {
    private final MutableIDCard id;

    public Officer(MutableIDCard id) {
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
        String name = DataGenerator.getNextName();
        Date dateOfBirth = DataGenerator.getNextDate();
        id.set(name, dateOfBirth);
        System.out.println("OFFICER IS: " + id.getName());
    }
}
