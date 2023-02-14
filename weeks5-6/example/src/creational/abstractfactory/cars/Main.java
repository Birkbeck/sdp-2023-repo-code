package creational.abstractfactory.cars;

public class Main {

    public static void main(String[] args) {
        Car fordcar = new Car(new FordFactory());
        System.out.println(fordcar);

        Car bmwcar = new Car(new BMWFactory());
        System.out.println(bmwcar);
    }
}
