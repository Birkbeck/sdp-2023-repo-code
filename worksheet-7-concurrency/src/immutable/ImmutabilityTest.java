package immutable;

import immutable.Citizen;
import immutable.DataGenerator;

import java.util.Date;

public class ImmutabilityTest {
    public static void main(String[] args) {
        String name = DataGenerator.getNextName();
        Date dateOfBirth = DataGenerator.getNextDate();

        MutableIDCard id = new MutableIDCard(name, dateOfBirth);

        // Make an officer and a citizen with the same ID (John)?
        Runnable officer = new Officer(id);

        // HOW TO MAKE CITIZEN'S ID FINAL (but not officer's)
        // ..... make all IDs final, just make a new one for the officer when needed
        Runnable citizen = new Citizen(id);

        // Change officer's details
        Thread t1 = new Thread(officer);
        // Print citizen's details
        Thread t2 = new Thread(citizen);
        // But only one ID. So does citizen change to Mary?
        t1.start();
        t2.start();
    }
}
