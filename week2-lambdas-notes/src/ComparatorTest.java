import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ComparatorTest {

    public static void main(String[] args) {

        List<Person> personList = Person.createShortList();

        // Sort with Inner Class
        Collections.sort(personList, new Comparator<Person>() {
            public int compare(Person p1, Person p2) {
                return p1.getSurname().compareTo(p2.getSurname());
            }
        });

        System.out.println("=== Sorted Asc Surname ===");
        for (Person p : personList) {
            p.printName();
        }

        // Use Lambda instead

        // Print Asc
        System.out.println("=== Sorted Asc Surname ===");
        Collections.sort(personList, (Person p1, Person p2)
                -> p1.getSurname().compareTo(p2.getSurname()));

        for (Person p : personList) {
            p.printName();
        }

        // Print Desc
        System.out.println("=== Sorted Desc Surname ===");
        Collections.sort(personList, (p1, p2)
                -> p2.getSurname().compareTo(p1.getSurname()));

        for (Person p : personList) {
            p.printName();
        }
    }
}