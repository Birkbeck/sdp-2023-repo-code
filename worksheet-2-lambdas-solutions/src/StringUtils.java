import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

abstract class StringUtils {

    /**
     * Compares two Strings so that Strings that include the letter
     * e are listed before Strings without a letter e.
     *
     * @param s1 String to be compared
     * @param s2 String to be compared
     * @return -1 if s1 contains e and s2 does not, 1 if s2 contains e and s1 does not
     * and 0 if both contain e.
     */
    public static int eChecker(String s1, String s2) {
        if (s1.contains("e") && !s2.contains("e")) return -1;
        if (s2.contains("e") && !s1.contains("e")) return 1;
        return 0;
    }

    /**
     * Applies a lambda to two Strings to define which of the Strings is better.
     * The method should return the better string
     *
     * @param s1     String to be compared
     * @param s2     String to be compared
     * @param lambda implementation of TwoStringPredicate that compares the two Strings
     * @return the better String
     */
    public static String betterString(String s1, String s2, TwoStringPredicate lambda) {
        return lambda.findBest(s1, s2) ? s1 : s2;
    }

    /**
     * Applies a lambda to two Objects of type T to define
     * which of the Objects is better.
     * The method should return the better Object
     *
     * @param t1     object of type T to be compared
     * @param t2     object of type T to be compared
     * @param lambda implementation of TwoElementPredicate that compares the two objects of Type R
     * @param <T>    the generic type
     * @return the better Object of type T
     */
    public static <T> T betterElement(T t1, T t2, TwoElementPredicate<T> lambda) {
        return lambda.findBest(t1, t2) ? t1 : t2;
    }

    /**
     * Should take a List of Strings and a Predicate<String>,
     * and return a new List of all the values that passed the test.
     *
     * @param lst  List of String
     * @param func java.util.function.Predicate
     * @return List of Strings that pass the function
     */
    public static List<String> allStringMatches(List<String> lst, Predicate<String> func) {
        List<String> result = new ArrayList<>();
        for (String s : lst)
            if (func.test(s))
                result.add(s);

        return result;
    }


    /**
     * Should take a List of Strings and a Predicate<String>,
     * and return a new List of all the values that passed the test.
     *
     * @param lst  List of Type T
     * @param func java.util.function.Predicate
     * @param <T>  Generic type
     * @return List of type T that pass the function
     */
    public static <T> List<T> allMatches(List<T> lst, Predicate<T> func) {
        List<T> result = new ArrayList<>();
        for (T s : lst)
            if (func.test(s))
                result.add(s);

        return result;
    }

    /**
     * Should take a List of Type String and a Function<String,String>
     * and return a new List that contains the results of applying the function to
     * each element of the original list.
     *
     * @param lst  List of String
     * @param func java.util.function.Function that will be applied to each
     * @return List of Strings after the application of the function
     */

    public static List<String> transformedStringList(List<String> lst, Function<String, String> func) {
        List<String> result = new ArrayList<>();
        for (String s : lst)
            result.add(func.apply(s));

        return result;
    }


    /**
     * Should take a List of Type T and a Function<T,T> and return a new List that
     * contains the results of applying the function to each element of the original list.
     *
     * @param lst  List of Type T
     * @param func java.util.function.Function that will be applied to each
     * @param <T>  Generic type
     * @return List of type T values after the application of the function
     */
    public static <T> List<T> transformedList(List<T> lst, Function<T, T> func) {
        List<T> result = new ArrayList<>();
        for (T s : lst)
            result.add(func.apply(s));

        return result;
    }
}
