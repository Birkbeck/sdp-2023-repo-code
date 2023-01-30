package two;

import java.util.List;
import java.util.Optional;

//Demonstrate the reduce() method.
public class StreamDemo {
    public static void main(String[] args) {
        // Create a list of Integer values.
        List<Integer> myList = List.of(7, 18, 10, 24, 17, 5);
        // Two ways to obtain the integer product of the elements
        // in myList by use of reduce().
        Optional<Integer> productObj = myList.stream()
                .reduce((a, b) -> a * b);
        if (productObj.isPresent())
            System.out.println("Product as Optional: " + productObj.get());
        int product = myList.stream().reduce(1, (a, b) -> a * b);
        System.out.println("Product as int: " + product);
    }
}