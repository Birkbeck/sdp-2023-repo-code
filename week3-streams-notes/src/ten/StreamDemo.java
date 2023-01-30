package ten;

import java.util.List;
import java.util.Spliterator;
import java.util.stream.Stream;

//Demonstrate trySplit().
public class StreamDemo {
    public static void main(String[] args) {
        // Create a list of Strings.
        List<String> myList = List.of("Alpha", "Beta", "Gamma", "Delta", "Phi", "Omega");
        // Obtain a Stream to the array list.
        Stream<String> myStream = myList.stream();
        // Obtain a Spliterator.
        Spliterator<String> splitItr = myStream.spliterator();
        // Now, split the first iterator.
        Spliterator<String> splitItr2 = splitItr.trySplit();
        // If splitItr could be split, use splitItr2 first.
        if (splitItr2 != null) {
            System.out.println("Output from splitItr2: ");
            splitItr2.forEachRemaining(n -> System.out.println(n));
        }
        // Now, use the splitItr.
        System.out.println("\nOutput from splitItr: ");
        splitItr.forEachRemaining(n -> System.out.println(n));
    }
}