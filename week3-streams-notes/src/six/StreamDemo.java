package six;

import java.util.*;
import java.util.stream.*;

//Map a Stream to an intStream.
public class StreamDemo {
    public static void main(String[] args) {
        // A list of double values.
        List<Double> myList = List.of(1.1, 3.6, 9.2, 4.7, 12.1, 5.0);
        System.out.print("Original values in myList: ");
        myList.stream().forEach(a -> System.out.print(a + " "));
        System.out.println();
        // Map the ceiling of the elements in myList to an InStream.
        IntStream cStrm = myList.stream().mapToInt(a -> (int) Math.ceil(a));
        System.out.print("The ceilings of the values in myList: ");
        cStrm.forEach(a -> System.out.print(a + " "));
    }
}