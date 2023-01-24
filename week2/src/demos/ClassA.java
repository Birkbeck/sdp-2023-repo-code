package demos;

public class ClassA {

    boolean method(ClassA a) {
        System.out.println("ClassA.method");
        return true;
    }
}

class SubClassOfClassA extends ClassA {
    @Override
    boolean method(ClassA a) {
        System.out.println("SubClassOfClassA.method");
        return true;
    }
}

