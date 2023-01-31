import java.util.Arrays;
import java.util.List;
import java.util.function.BiPredicate;

public class Outline {
    public static String[] getWords() {
        return new String[] {
                "fly",
                "ants",
                "bats",
                "piglets",
                "gorillas",
                "cat",
                "hamster",
                "emus",
                "tiger" };
    }

    // Create an array containing some Strings.
    // Sort the array by length (i.e., shortest to longest)
    public static void question1_1() {
        String[] words = getWords();
        Arrays.sort(words, (a, b) -> Integer.compare(a.length(), b.length()));
        // alternatively
        // Arrays.sort(words, Comparator.comparingInt(String::length));
        System.out.println("1.1: " + Arrays.asList(words));
    }

    // Sort the array by reverse length (i.e., longest to shortest)
    public static void question1_2() {
        String[] words = getWords();
        Arrays.sort(words, (a, b) -> Integer.compare(b.length(), a.length()));
        // alternatively
        // Arrays.sort(words, Comparator.comparingInt(String::length).reversed());
        System.out.println("1.2: " + Arrays.asList(words));
    }

    // Sort the array by first character
    public static void question1_3() {
        String[] words = getWords();
        Arrays.sort(words, (a, b) -> Character.compare(a.charAt(0), b.charAt(0)));
        // alternatively
        // Arrays.sort(words, Comparator.comparingInt(a -> a.charAt(0)));
        System.out.println("1.3: " + Arrays.asList(words));
    }

    // Strings that contain "e" first, everything else second.
    public static void question1_4() {
        String[] words = getWords();
        Arrays.sort(words, (a, b) -> {
                    if (a.contains("e") && !b.contains("e")) return -1;
                    if (b.contains("e") && !a.contains("e")) return 1;
                    return 0;
                });
        System.out.println("1.4: " + Arrays.asList(words));
    }

    // Rewrite the final lambda sorting example,
    // but use a method reference in place of an explicit lambda.
    public static void question2() {
        String[] words = getWords();
        Arrays.sort(words, StringUtils::eChecker);
        System.out.println("2: " + Arrays.asList(words));
    }

    // Create a class with a static method called betterString which should take two Strings
    // and a lambda as its arguments;
    public static void question3() {
        System.out.println("3:");

        String test1 = "gorillas";
        String test2 = "emus and turkeys";
        System.out.println(StringUtils.betterString(test1, test2, (s1, s2) -> s1.length() > s2.length()));
        System.out.println(StringUtils.betterString(test1, test2, (s1, s2) -> true));
    }

    // Use generics to replace betterString with betterEntry and to
    // replace TwoStringPredicate with TwoElementPredicate.
    public static void question4() {
        System.out.println("4:");

        String test1 = "gorillas";
        String test2 = "emus and turkeys";
        System.out.println(StringUtils.betterElement(test1, test2, (s1, s2) -> s1.length() > s2.length()));
        System.out.println(StringUtils.betterElement(test1, test2, (s1, s2) -> true));

        int i1 = 3;
        int i2 = 455;
        System.out.println(StringUtils.betterElement(i1, i2, (s1, s2) -> s1 > s2));
        System.out.println(StringUtils.betterElement(i1, i2, (s1, s2) -> true));
    }

    // Create a static method called allMatches. It should take a List of Strings and a
    // Predicate<String>, and return a new List of all the values that passed the test.
    public static void question5() {
        List<String> list = List.of(getWords());
        System.out.println("5:");

        List<String> shortWords = StringUtils.allStringMatches(list, s -> s.length() < 4);
        System.out.println(shortWords);
        List<String> wordsWithB = StringUtils.allStringMatches(list, s -> s.contains("b"));
        System.out.println(wordsWithB);
        List<String> evenLengthWords = StringUtils.allStringMatches(list, s -> (s.length() % 2) == 0);
        System.out.println(evenLengthWords);
    }

    // Rewrite allMatches so that it works on any List and associated Predicate,
    // not just on Strings. Verify that the examples from the previous question still work.
    public static void question6() {
        System.out.println("6:");

        List<String> list = List.of(getWords());
        List<String> shortWords = StringUtils.allMatches(list, s -> s.length() < 4);
        System.out.println(shortWords);
        List<String> wordsWithB = StringUtils.allMatches(list, s -> s.contains("b"));
        System.out.println(wordsWithB);
        List<String> evenLengthWords = StringUtils.allMatches(list, s -> s.length() % 2 == 0);
        System.out.println(evenLengthWords);

        List<Integer> integerList = List.of(2, 34, 55, 345, 57, 243, 24);
        List<Integer> evenIntegers = StringUtils.allMatches(integerList, n -> (n % 2) == 0);
        System.out.println(evenIntegers);
    }

    // Create a static method called transformedList. It should take a List of Strings and a
    // Function<String,String> and return a new List that contains the results of applying the
    // function to each element of the original list.
    public static void question7() {
        System.out.println("7:");

        List<String> list = List.of(getWords());
        List<String> excitingWords = StringUtils.transformedStringList(list, s -> s + "!");
        System.out.println(excitingWords);
        List<String> eyeWords = StringUtils.transformedStringList(list, s -> s.replace("i", "eye"));
        System.out.println(eyeWords);
        List<String> upperCaseWords = StringUtils.transformedStringList(list, String::toUpperCase);
        System.out.println(upperCaseWords);
    }

    // Rewrite transformedList so it works with generic types.
    public static void question8() {
        System.out.println("8:");

        List<String> list = List.of(getWords());
        List<String> excitingWords = StringUtils.transformedList(list, s -> s + "!");
        System.out.println(excitingWords);
        List<String> eyeWords = StringUtils.transformedList(list, s -> s.replace("i", "eye"));
        System.out.println(eyeWords);
        List<String> upperCaseWords = StringUtils.transformedList(list, String::toUpperCase);
        System.out.println(upperCaseWords);

        List<Integer> integerList = List.of(2, 34, 55, 345, 57, 243, 24);
        List<Integer> multiIntegers = StringUtils.transformedList(integerList, n -> n * 2);
        System.out.println(multiIntegers);
    }

    public static void main(String... args) { // varargs alternative to String[]
        question1_1();
        question1_2();
        question1_3();
        question1_4();
        question2();
        question3();
        question4();
        question5();
        question6();
        question7();
        question8();
    }
}
