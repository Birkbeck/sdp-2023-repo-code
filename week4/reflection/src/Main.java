import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;
import java.lang.reflect.Parameter;

public class Main {
    public static void main(String[] args) throws Exception {
        // fully qualified class names!
        // everything from the java.lang package is imported automatically;
        // all other classes (except from the default package) will have
        // fully qualified names consisting of the package name and the class name
        Class<?> classObject = Class.forName("java.lang.String");

        // list all the methods (including inherited from Object, for example)
        for (java.lang.reflect.Method m : classObject.getMethods())
            System.out.println(m);

        // list all constructors with their parameter types
        for (Constructor<?> c : classObject.getDeclaredConstructors()) {
            System.out.println("constructor with modifiers " + Modifier.toString(c.getModifiers()));
            for (Parameter p : c.getParameters()) {
                System.out.println("  " + p.getType());
            }
            if (c.getParameters().length == 1
                    && c.getParameters()[0].getType().equals(String.class)) {
                // found constructor String(String s)
                System.out.println("Hooray!");
            }
        }
    }
}

class B {
    int p = 3;
}

class D extends B {
    int p; // this p shadows the p from B
           // (this can happen incidentally, as you have
           // no control over the names in existing superclasses
    void m() {
        p = 2;  // refers to p in D
        this.p = 3;  // refers to p in D
        super.p = 4;  // refers to p in B (but should be avoided)
    }
}

