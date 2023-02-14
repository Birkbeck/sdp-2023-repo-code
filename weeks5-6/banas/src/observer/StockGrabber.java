package observer;

import java.util.ArrayList;
import java.util.List;

// Uses the Subject interface to update all Observers

public class StockGrabber implements Subject {

    private final List<Observer> observers = new ArrayList<>();
    private double ibmPrice;
    private double aaplPrice;
    private double googPrice;


    @Override
    public void register(Observer newObserver) {
        // Adds a new observer to the ArrayList
        observers.add(newObserver);
    }

    @Override
    public void unregister(Observer deleteObserver) {

        // Get the index of the observer to delete
        int observerIndex = observers.indexOf(deleteObserver);

        // Print out message (Have to increment index to match)
        System.out.println("Observer " + (observerIndex + 1) + " deleted");

        // Removes observer from the ArrayList
        observers.remove(observerIndex);
    }

    @Override
    public void notifyObserver() {
        // Cycle through all observers and notifies them of
        // price changes
        for (Observer observer : observers)
            observer.update(ibmPrice, aaplPrice, googPrice);

    }

    // Change prices for all stocks and notifies observers of changes

    public void setIBMPrice(double ibmPrice) {
        this.ibmPrice = ibmPrice;
        notifyObserver();
    }

    public void setAAPLPrice(double aaplPrice) {
        this.aaplPrice = aaplPrice;
        notifyObserver();
    }

    public void setGOOGPrice(double googPrice) {
        this.googPrice = googPrice;
        notifyObserver();
    }
}