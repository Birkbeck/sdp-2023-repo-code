package nine;

import java.util.List;
import java.util.Spliterator;
import java.util.stream.Stream;

//Use a Spliterator.
public class StreamDemo {
    public static void main(String[] args) {
        // Create a list of Strings.
        List<String> myList = List.of("Alpha", "Beta", "Gamma", "Delta", "Phi", "Omega");
        // Obtain a Stream to the array list.
        Stream<String> myStream = myList.stream();
        // Obtain a Spliterator.
        Spliterator<String> splitItr = myStream.spliterator();
        // Iterate the elements of the stream.
        while (splitItr.tryAdvance(n -> System.out.println(n)))
            ;
    }
}