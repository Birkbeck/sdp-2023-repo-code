package memento;

// Memento Design Pattern Tutorial

import java.util.ArrayList;
import java.util.List;

class Caretaker {

    // Where all mementos are saved

    List<Memento> savedArticles = new ArrayList<>();

    // Adds memento to the ArrayList

    public void addMemento(Memento m) {
        savedArticles.add(m);
    }

    // Gets the memento requested from the ArrayList

    public Memento getMemento(int index) {
        return savedArticles.get(index);
    }
}