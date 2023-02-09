package helloworld;

public class HelloWorldDecoupledInterface {
    public static void main(String... args) {
        // The interface names on the left should *not* be replaced with var.
        // For otherwise, what is the point of having interfaces in the first place?
        MessageRenderer mr = new StandardOutMessageRenderer();
        MessageProvider mp = new HelloWorldMessageProvider();
        mr.setMessageProvider(mp);
        mr.render();
    }
}