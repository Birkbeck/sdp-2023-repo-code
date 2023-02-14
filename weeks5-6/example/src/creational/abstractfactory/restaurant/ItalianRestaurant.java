package creational.abstractfactory.restaurant;

public class ItalianRestaurant implements Restaurant {
    public Appetizer getAppetizer() {
        return new Pizzette();
    }

    public Entree getEntree() {
        return new Pasta();
    }

    public Dessert getDessert() {
        return new Gelato();
    }
}