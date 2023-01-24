package functionalinterfaces;

public class CustomInterfacePrinter {
    static class IntContainer {
        int v;
    }
    public static void main(String[] args) {
        CustomInterfacePrinter printer = new CustomInterfacePrinter();
        int i = 0; // effectively final
        IntContainer c = new IntContainer(); // c is effectively final
        c.v = 22; // but the instance variable of IntContainer is not final
        printer.print(new CustomFunctionalInterface() {
            @Override
            public void singleMethod(String param) {
                // can refer to effectively final variables
                System.out.println("My lambda says " + param + " " + i + c.v);
            }
        });
        printer.print(param -> System.out.println("My lambda says " + param + " " + i + c.v));
    }

    public void print(CustomFunctionalInterface firstInterface) {
        firstInterface.singleMethod("apple");
    }
}
