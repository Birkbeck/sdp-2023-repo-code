package creational.factorymethod.pc;

public class Main {
    public static void main(String[] args) {
        System.out.println(
                ComputerFactory.getComputer(
                        "PC",
                        "4 GB",
                        "256 GB SSD",
                        "Intel Core i3-122OP"));
    }

}
