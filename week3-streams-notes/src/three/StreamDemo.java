package three;
import java.util.List;

//Demonstrate the use of a combiner with reduce()
public class StreamDemo {
    public static void main(String[] args) {
        // This is now a list of double values.
        List<Double> myList = List.of(7.0, 18.0, 10.0, 24.0, 17.0, 5.0);
        double productOfSqrRoots = myList.parallelStream().reduce(1.0,
                (a, b) -> a * Math.sqrt(b), (a, b) -> a * b);
        System.out.println("Product of square roots: " + productOfSqrRoots);
    }
}