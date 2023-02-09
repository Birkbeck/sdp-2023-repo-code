import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Outline {

    public static List<String> getList() {
        return List.of("hi", "bat", "ear", "hello", "iguana",
                "beaver", "winterland", "elephant", "eye", "qi");
    }

    // Loop through the words and print each one on a separate line,
    // with two spaces in front of each word.
    public static void question1() {
        List<String> words = getList();
        System.out.println("1: ");
        words.stream().forEach(w -> System.out.println("  " + w));
    }

    // Repeat this problem but without two spaces in front of each word.
    // This should be trivial if you use the same approach as the previous
    // question; the point here is to make use of a method reference.
    public static void question2() {
        List<String> words = getList();
        System.out.println("2: ");
        words.stream().forEach(System.out::println);
    }

    // For each of the following lambda expressions (see Question 5 in Worksheet 2),
    // produce the list that contains the elements of the original list
    // that satisfy the predicate defined by the lambda expression
    // (use the filter stream operation):
    //  - s -> s.length() < 4 (strings with no more than 3 characters),
    //  - s -> s.contains("b") (strings containing "b"),
    //  - s -> (s.length() % 2) == 0 (strings of even length).

    public static void question3() {
        List<String> words = getList();
        System.out.println("3:");

        List<String> shortWords = words.stream()
                .filter(s -> s.length() < 4)
                .collect(Collectors.toList());
        System.out.println(shortWords);

        List<String> wordsWithB = words.stream()
                .filter(s -> s.contains("b"))
                .collect(Collectors.toList());
        System.out.println(wordsWithB);

        List<String> evenLengthWords = words.stream()
                .filter(s -> (s.length() % 2) == 0)
                .collect(Collectors.toList());
        System.out.println(evenLengthWords);
    }


    // For each of the following lambda expressions (see Question 7 in Worksheet 2),
    // produce the list that contains the results of applying the function
    // defined by the lambda expression to each element of the original list
    // (use the map stream operation):
    // - s -> s + "!",
    //  s -> s.replace("i", "eye"),
    //  s -> s.toUpperCase().

    public static void question4() {
        List<String> words = getList();
        System.out.println("4:");

        List<String> excitingWords = words.stream()
                .map(s -> s + "!")
                .collect(Collectors.toList());
        System.out.println(excitingWords);

        List<String> eyeWords = words.stream()
                .map(s -> s.replace("i", "eye"))
                .collect(Collectors.toList());
        System.out.println(eyeWords);

        List<String> upperCaseWords = words.stream()
                .map(String::toUpperCase)
                .collect(Collectors.toList());
        System.out.println(upperCaseWords);
    }


    // (*) Turn the strings in the list into uppercase, keep only the
    // ones that are shorter than four characters, and, of what is remaining,
    // keep only the ones that contain "E", and print the first result.
    // Repeat the process, except checking for a "Q" instead of an "E".

    public static void question5() {
        List<String> words = getList();
        System.out.println("5a:");
        words.stream()
                .map(String::toUpperCase)
                .filter(s -> s.length() < 4)
                .filter(s -> s.contains("E"))
                .limit(1)
                .forEach(System.out::println);

        // Alternatively, with findFirst:
        Optional<String> result = words.stream()
                .map(String::toUpperCase)
                .filter(s -> s.length() < 4)
                .filter(s -> s.contains("E"))
                .findFirst();
        result.ifPresent(System.out::println);

        System.out.println("5b.");
        words.stream()
                .map(String::toUpperCase)
                .filter(s -> s.length() < 4)
                .filter(s -> s.contains("Q"))
                .limit(1)
                .forEach(System.out::println);
    }


    // (**) The above example uses lazy evaluation, but it is not easy to see
    // that it is doing so. Create a variation of the above example that shows
    // that it is doing lazy evaluation. The simplest way is to track which
    // entries are turned into upper case.

    public static void question6() {
        List<String> words = getList();
        System.out.println("6:");

        Optional<String> result = words.stream()
                .map(String::toUpperCase)
                // an alternative to peek
                //.filter(s -> {
                //    System.out.println("pre-filter1: " + s);
                //    return s.length() < 4;
                //})
                .peek(s -> System.out.println("pre-filter1: " + s))
                .filter(s -> s.length() < 4)
                .peek(s -> System.out.println("pre-filter2: " + s))
                .filter(s -> s.contains("E"))
                .findFirst();
/*
        Optional<String> r = Optional.empty();
        for (String s : words) {
            String s1 = s.toUpperCase();
            if (s1.length() < 4) {
                if (s1.contains("E")) {
                    r = Optional.of(s1);
                    break;
                }
            }
        }
*/
        System.out.println(result);
    }

    // (*) Produce a single String that is the result of concatenating the
    // uppercase versions of all the Strings.
    // For example, the result should be "HIHELLO...".
    // Hint: use a map operation that turns the words into upper case,
    // followed by a reduce operation that concatenates them.

    public static void question7() {
        List<String> words = getList();
        System.out.println("7:");

        String concat = words.stream()
                .map(String::toUpperCase)
                .reduce("", (a, e) -> a + e);
        System.out.println(concat);
    }


    // (*) Produce a single String that is the result of concatenating the
    // uppercase versions of all the Strings.
    // For example, the result should be "HIHELLO...".
    // Use a single reduce operation, without using map.

    public static void question8() {
        List<String> words = getList();
        System.out.println("8:");

        String concat = words.stream()
                // note that only the second parameter needs to be transformed into upper case
                // the first parameter (the accumulated result) is already upper-case
                .reduce("", (sA, sB) -> sA + sB.toUpperCase());
        System.out.println(concat);
    }

    // (*) Produce a String that is all the words concatenated together, but
    // with commas in between. For example, the result should be "hi,hello,...".
    // Note that there is no comma at the beginning, before "hi", and also no comma
    // at the end, after the last word.

    public static void question9() {
        List<String> words = getList();
        System.out.println("9:");

        String concat = words.stream()
                .collect(Collectors.joining(","));
        System.out.println(concat);
    }

    // Use streams to filter the first two meat dishes.

    public static void question10() {
        System.out.println("10:");
        List<Dish> d = Dish.getMenu().stream()
                .filter(dish -> dish.type() == Dish.Type.MEAT)
                .limit(2)
                .collect(Collectors.toList());
        System.out.println(d);
    }

    // Count the number of dishes in a stream using the map and reduce methods.

    public static void question11() {
        System.out.println("11:");
        long numberOfDishes = Dish.getMenu().stream()
                // map(dish -> 1) is a Supplier function taking a Dish object and returning an int.
                .mapToInt(dish -> 1)
                // reduce(identity, accumulator), where
                //      - the identity is a starting value and
                //      - the accumulator is a binary function that adds the identity to
                //        the int passed from the preceding operation
                // the following is a shortcut for .reduce(0, (a,b) -> a + b)
                .reduce(0, Integer::sum);

        System.out.println(numberOfDishes);
    }



    public static Integer[] getIntegerArray() {
        return new Integer[] { 1, 7, 3, 4, 8, 2 };
    }
    public static int[] getIntArray() {
        return new int[] { 1, 7, 3, 4, 8, 2 };
    }

    // Given a list of numbers, print out the list of the squares
    // of each number. For example, given [1, 2, 3, 4, 5] you should print [1, 4, 9, 16, 25].

    public static void question12() {
        System.out.println("12:");
        List<Integer> squares = IntStream.of(getIntArray())
                .mapToObj(x -> x * x)
                .collect(Collectors.toList());
        System.out.println(squares);
    }

    // Given two lists of numbers, print out all pairs of numbers. For example,
    // given a list [1, 2, 3] and a list [3, 4] you should print:
    // [[1, 3], [1, 4], [2, 3], [2, 4], [3, 3], [3, 4]].
    // For simplicity, you can represent each pair as a list with two elements.

    public static void question13() {
        System.out.println("13:");
        List<Integer> list1 = List.of(5, 2, 3);
        List<Integer> list2 = List.of(3, 4);

        List<List<Integer>> output = list1.stream()
                .flatMap(num1 -> list2.stream()
                        .map(num2 -> List.of(num1, num2)))
                .collect(Collectors.toList());

        System.out.println(output);
    }

    // Extend the previous example to return only pairs whose
    // sum is divisible by 3. For example, [2, 4] and [3, 3] are valid.

    public static void question14() {
        System.out.println("14:");
        List<Integer> list1 = List.of(5, 2, 3);
        List<Integer> list2 = List.of(3, 4);

        List<List<Integer>> output = list1.stream()
                .flatMap(num1 -> list2.stream()
                        .filter(num2 -> (num1 + num2) % 3 == 0)
                        .map(num2 -> List.of(num1, num2)))
                .collect(Collectors.toList());
        System.out.println(output);
    }

    // (*) Provide three ways to use streams to compute the sum of a list of
    // numbers.

    public static void question15() {
        System.out.println("15:");

        int sum1 = Stream.of(getIntegerArray())
                .reduce((n1, n2) -> n1 + n2)
                .get();
        System.out.println(sum1);

        int sum2 = Stream.of(getIntegerArray())
                .reduce(0, Integer::sum);
        System.out.println(sum2);

        int sum3 = Stream.of(getIntegerArray())
                .collect(Collectors.summingInt(n -> n));
        System.out.println(sum3);

        int sum4 = Stream.of(getIntegerArray())
                .mapToInt(n -> n)
                .sum();
        System.out.println(sum4);

        int sum5 = Stream.of(getIntegerArray())
                .collect(Collectors.reducing(0, (n1, n2) -> n1 + n2));
        System.out.println(sum5);
    }

    // (*) Write a static method that produces a List of a specified length of
    // random numbers. For example,
    // List<Double> nums = randomNumberList(someSize);
    // Result is something like [0.7096867136897776, 0.09894202723079482, ...].

    public static void question16() {
        System.out.println("16:");
        List<Double> randDoubles = randomNumberList(4);
        System.out.println(randDoubles);
    }

    static List<Double> randomNumberList(int size) {
        return Stream.generate(new Random()::nextDouble) // unspecified size - lazy evaluation (!)
                .limit(size)
                .collect(Collectors.toList());
    }

    // (*) Write a static method that produces a List of numbers that go in order
    // by a step size. For example,
    // List<Integer> nums = orderedNumberList(50, 5, someSize);
    // Result is [50, 55, 60, ...].

    public static void question17() {
        System.out.println("17:");
        List<Integer> stepInts = orderedNumberList(50, 5, 4);
        System.out.println(stepInts);
    }

    static List<Integer> orderedNumberList(int start, int step, int size) {
        return Stream.iterate(start, n -> n + step) // unspecified size - lazy evaluation (!)
                .limit(size)
                .collect(Collectors.toList());
    }


    // (*) Rewrite one of the solutions to Question 15 so that
    // it can be executed in parallel; verify that you get the same answer as for
    // the sequential code.

    public static void question18() {
        System.out.println("18:");
        int sumP = Stream.of(getIntegerArray())
                .parallel()
                .reduce(0, Integer::sum);
        System.out.println(sumP);
    }


    //  (**) Now, use streams to compute the product of some doubles. Show that
    // the serial and parallel versions do not always result in the same answer.

    public static void question19() {
        System.out.println("19:");
        Double[] doubleArray = { 2.0, 7.0, 3.0, 4.0, 8.0, 2.0, 3.0, 10.0, 11.2, 44.2, 54.1, 1120.1, 2345.6 };
        double productDouble = Stream.of(doubleArray)
                .reduce(1.0, (d1, d2) -> d1 * d2);
        System.out.println(productDouble);

        // try a few times
        for (int i = 0; i < 10_000_000; i++) {
            double productDoubleP = Stream.of(doubleArray)
                    .parallel()
                    .reduce(1.0, (d1, d2) -> d1 * d2);

            if (productDouble != productDoubleP) {
                System.out.println("Not equal (step " + i + "): " + productDouble + " v " + productDoubleP);
                break;
            }
        }
    }


    public static void main(String... args) { // varargs alternative to String[]
        question6();
    }

}