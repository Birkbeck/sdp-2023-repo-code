package nine;

import java.util.ArrayList;
import java.util.Spliterator;
import java.util.stream.Stream;

//Use a Spliterator.
public class StreamDemo {
    public static void main(String[] args) {
        // Create a list of Strings.
        ArrayList<String> myList = new ArrayList<>();
        myList.add("Alpha");
        myList.add("Beta");
        myList.add("Gamma");
        myList.add("Delta");
        myList.add("Phi");
        myList.add("Omega");
        // Obtain a Stream to the array list.
        Stream<String> myStream = myList.stream();
        // Obtain a Spliterator.
        Spliterator<String> splitItr = myStream.spliterator();
        // Iterate the elements of the stream.
        while (splitItr.tryAdvance(n -> System.out.println(n)))
            ;
    }
}