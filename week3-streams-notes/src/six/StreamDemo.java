package six;

import java.util.*;
import java.util.stream.*;

//Map a Stream to an intStream.
public class StreamDemo {
    public static void main(String[] args) {
        // A list of double values.
        ArrayList<Double> myList = new ArrayList<>();
        myList.add(1.1);
        myList.add(3.6);
        myList.add(9.2);
        myList.add(4.7);
        myList.add(12.1);
        myList.add(5.0);
        System.out.print("Original values in myList: ");
        myList.stream().forEach(a -> System.out.print(a + " "));
        System.out.println();
        // Map the ceiling of the elements in myList to an InStream.
        IntStream cStrm = myList.stream().mapToInt(a -> (int) Math.ceil(a));
        System.out.print("The ceilings of the values in myList: ");
        cStrm.forEach(a -> System.out.print(a + " "));
    }
}