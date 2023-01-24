package classes;

class OuterClass {
    private int variable = 1;
    class InnerClass {
        private int variable = 2; // shadows var from OuterClass

        int method1() {
            return variable; // refers to var from InnerClass
        }
        int method2() {
            return OuterClass.this.variable; // refers to var from OuterClass
        }
    }

    static class StaticNestedClass {
        int method() {
            //return var; // not accessible
            //return OuterClass.this.var; // Outer.this not available
            return 0;
        }
    }

    InnerClass method() { return new InnerClass(); }
}



public class NestedClassDemo {

    /*
       for varargs (...) - read
            https://docs.oracle.com/javase/tutorial/java/javaOO/arguments.html
            https://docs.oracle.com/javase/8/docs/technotes/guides/language/non-reifiable-varargs.html
     */
    public static void main(String... args) {
        OuterClass outer = new OuterClass();
        OuterClass.InnerClass inner = outer.new InnerClass();
        System.out.println(inner.method1());
        System.out.println(inner.method2());

        OuterClass.StaticNestedClass nested = new OuterClass.StaticNestedClass();
        System.out.println(nested.method());
    }
}
