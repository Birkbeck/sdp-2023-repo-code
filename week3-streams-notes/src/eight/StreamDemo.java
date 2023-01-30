package eight;

import java.util.List;
import java.util.Iterator;
import java.util.stream.Stream;

//Use an iterator with a stream.
public class StreamDemo {
    public static void main(String[] args) {
        // Create a list of Strings.
        List<String> myList = List.of("Alpha", "Beta", "Gamma", "Delta", "Phi", "Omega");
        // Obtain a Stream to the array list.
        Stream<String> myStream = myList.stream();
        // Obtain an iterator to the stream.
        Iterator<String> itr = myStream.iterator();
        // Iterate the elements in the stream.
        while (itr.hasNext())
            System.out.println(itr.next());
    }
}