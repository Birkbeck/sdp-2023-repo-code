package four;
import java.util.List;
import java.util.stream.Stream;
//Map one stream to another.
public class StreamDemo {
    public static void main(String[] args) {
        // A list of double values.
        List<Double> myList = List.of(7.0, 18.0, 10.0, 24.0, 17.0, 5.0);
        // Map the square root of the elements in myList to a new stream.
        Stream<Double> sqrtRootStrm = myList.stream()
                .map(a -> Math.sqrt(a));

        // Find the product to the square roots.
        double productOfSqrRoots = sqrtRootStrm.reduce(1.0,
                (a, b) -> a * b);
        System.out.println("Product of square roots is "
                + productOfSqrRoots);
    }
}