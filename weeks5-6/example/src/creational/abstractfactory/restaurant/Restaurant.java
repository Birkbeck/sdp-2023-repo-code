package creational.abstractfactory.restaurant;

public interface Restaurant {
    Appetizer getAppetizer();

    Entree getEntree();

    Dessert getDessert();
}