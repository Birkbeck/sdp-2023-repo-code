package demos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;
import java.util.function.BiPredicate;

public class MethodReferenceDemo {
    public static void main(String[] args) {
        String[] strings = {"Mary", "had", "a", "little", "lamb"};
        Arrays.sort(strings, String::compareToIgnoreCase);
        System.out.println(Arrays.toString(strings));
        // [a, had, lamb, little, Mary]

        MethodReferenceDemo o1 = new MethodReferenceDemo();
        MethodReferenceDemo o2 = new MethodReferenceDemo();
        o1.methodWithNewUseOfThis(o2);

        caller(MethodReferenceDemo::methodStandard);
        caller(MethodReferenceDemo::methodWithNewUseOfThis);
        caller(MethodReferenceDemo::staticMethod);

        callerA(ClassA::method);
        // is equivalent to (and thus, which implementation of method
        // is called depends on the type of a1 (ClassA or SubClassOfClassA)
        // at run-time)
        callerA((a1, a2) -> a1.method(a2));

        ArrayList<String> list = new ArrayList<>(Arrays.asList("Malfoy", "Crabbe", "Goyle", null));
        list.removeIf(Objects::isNull);
        list.forEach(System.out::println);
        // Malfoy
        // Crabbe
        // Goyle
    }

    public static void caller(BiPredicate<MethodReferenceDemo, MethodReferenceDemo> p) {

    }

    public static void callerA(BiPredicate<ClassA, ClassA> p) {
        ClassA a = new ClassA();
        SubClassOfClassA subA = new SubClassOfClassA();
        p.test(a, subA);
        p.test(subA, a);
    }

    public boolean methodStandard(MethodReferenceDemo other) {
        return false;
    }

    public boolean methodWithNewUseOfThis(
            /* this refers to the object on which the method is called */
                            MethodReferenceDemo this,
                            MethodReferenceDemo other) {
        return false;
    }

    public static boolean staticMethod(MethodReferenceDemo first, MethodReferenceDemo other) {
        return false;
    }

}
