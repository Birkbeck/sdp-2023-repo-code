import java.util.List;
import java.util.function.Function;

public class NameTestNew {

    public static void main(String[] args) {

        System.out.println("\n==== NameTestNew ===");

        List<Person> list1 = Person.createShortList();

        // Print Custom First Name and e-mail
        System.out.println("===Custom List===");
        for (Person person : list1) {
            System.out.println(
                    person.printCustom(p -> "Name: " + p.getGivenName()
                    + " EMail: " + p.getEmail())
             );
        }

        // Define Lambdas for the two style

        Function<Person, String> style1 = p -> {
            return "\nName: " + p.getGivenName() + " "
                    + p.getSurname() + "\n" +
                    "Age: " + p.getAge() + " " + "Gender: "
                    + p.getGender() + "\n" +
                    "EMail: " + p.getEmail() + "\n" +
                    "Phone: " + p.getPhone() + "\n" +
                    "Address: " + p.getAddress();
        };

        Function<Person, String> style2 = p -> "\nName: "
                + p.getSurname() + " "
                + p.getGivenName() + "\n" + "Age: " + p.getAge() + " " +
                "Gender: " + p.getGender() + "\n" +
                "EMail: " + p.getEmail() + "\n" +
                "Phone: " + p.getPhone() + "\n" +
                "Address: " + p.getAddress();

        // Print using Style 1
        System.out.println("\n===List in Style 1===");
        for (Person person : list1) {
            System.out.println(
                    person.printCustom(style1)
            );
        }

        // Print using Style 2
        System.out.println("\n===List in Style 2===");
        for (Person person : list1) {
            System.out.println(
                    person.printCustom(style2)
            );
        }
    }
}