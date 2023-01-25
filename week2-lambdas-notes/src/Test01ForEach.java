import java.util.List;

public class Test01ForEach {

    public static void main(String[] args) {

        List<Person> pl = Person.createShortList();

        System.out.println("\n=== Style 1 Phone List ===");
        pl.forEach(p -> p.printNameStyle1());

        System.out.println("\n=== Style 2 Phone List ===");
        pl.forEach(Person::printNameStyle2);

        System.out.println("\n=== Custom Phone List ===");
        pl.forEach(p -> {
            System.out.println(p.printCustom(r -> "Name: "
                    + r.getGivenName() + " EMail: " + r.getEmail()));
        });
    }
}