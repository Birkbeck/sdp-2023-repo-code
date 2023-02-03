import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamDemo {

    public static Set<Dish> getSet(Dish d1, Dish d2) {
        Set<Dish> s = new HashSet<>();
        s.add(d1);
        s.add(d2);
        return s;
    }
    public static void main(String... args) {
        List<Dish> list = Dish.getMenu();

        //System.out.println(list.stream()
        //        .filter(Dish::vegetarian)
        //        .toList());

        //list.stream()
        //        .map(d -> d.name())
        //        .forEach(n -> System.out.println(n));

        System.out.println(list.stream()
                .flatMap(d -> list.stream()
                        .filter(Dish::vegetarian)
                        .map(d1 -> Stream.of(d, d1).collect(Collectors.toSet())))
                .distinct()
                .toList());

//        List<List<Dish>> result = new ArrayList<>();
//        for (Dish d : list) {
//            for (Dish d1 : list)
//                result.add(List.of(d, d1));
//        }

//        System.out.println(list.stream()
//                .map(d -> list.stream()
//                        .map(d1 -> List.of(d, d1)))
//                .toList());
//
//        List<List<List<Dish>>> result1 = new ArrayList<>();
//        for (Dish d : list) {
//            List<List<Dish>> r = new ArrayList<>();
//            for (Dish d1 : list)
//                r.add(List.of(d, d1));
//            result1.add(r);
//        }
//
    }

    public static List<String> getList() {
        return List.of("hi", "bat", "ear", "hello", "iguana",
                "beaver", "winterland", "elephant", "eye", "qi");
    }
}
