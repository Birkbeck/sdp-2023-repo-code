package defaultmethods;

public class MyClass implements Alpha, Beta {
    @Override
    // must override reset as Alpha and Beta's default implementations
    // are unrelated (neither interface extends the other)
    public void reset() {
        Alpha.super.reset();
        Beta.super.reset();
        System.out.println("MyClass.reset");
    }
}
