package helloworld;

public class HelloWorldCommandLineArguments {

    // Use Run > Edit Configurations in IntelliJ to set up the command-line arguments
    // Alternatively, use the terminal window from the *production* root of the module
    // (so that the .class file is in the helloworld folder)
    // Then, run with java helloworld.HelloWorldCommandLineArguments
    // (The class name is the path to the .class file with / replaced by . and .class removed.)
    public static void main(String... args) {
        if (args.length > 0) {
            System.out.println(String.join(" ", args));
        } else {
            System.out.println("Hello World!");
        }
    }
}