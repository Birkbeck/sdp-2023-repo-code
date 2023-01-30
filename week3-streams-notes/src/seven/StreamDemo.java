package seven;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

//Use collect() to create a List and a Set from a stream.
public class StreamDemo {
    public static void main(String[] args) {
        // A list of names, phone numbers, and e-mail addresses.
        List<NamePhoneEmail> myList = List.of(
            new NamePhoneEmail("Larry", "555-5555", "Larry@dodgy.com"),
            new NamePhoneEmail("James", "555-4444", "James@dodgy.com"),
            new NamePhoneEmail("Mary", "555-3333", "Mary@dodgy.com"));

        // Map just the names and phone numbers to a new stream.
        Stream<NamePhone> nameAndPhone = myList.stream()
                .map(a -> new NamePhone(a.getName(), a.getPhonenum()));

        // Use collect to create a List of the names and phone numbers.
        List<NamePhone> npList = nameAndPhone.collect(Collectors.toList());
        System.out.println("Names and phone numbers in a List:");
        for (NamePhone e : npList)
            System.out.println(e.getName() + ": " + e.getPhonenum());

        // Obtain another mapping of the names and phone numbers.
        nameAndPhone = myList.stream().map(a ->
                new NamePhone(a.getName(), a.getPhonenum()));

        // Now, create a Set by use of collect().
        Set<NamePhone> npSet = nameAndPhone.collect(Collectors.toSet());
        System.out.println("\nNames and phone numbers in a Set:");
        for (NamePhone e : npSet)
            System.out.println(e.getName() + ": " + e.getPhonenum());
    }
}

class NamePhoneEmail {
    private final String name;
    private final String phonenum;
    private final String email;

    public NamePhoneEmail(String n, String p, String e) {
        name = n;
        phonenum = p;
        email = e;
    }

    public String getName() {
        return name;
    }

    public String getPhonenum() {
        return phonenum;
    }

    public String getEmail() {
        return email;
    }
}

class NamePhone {
    private final String name;
    private final String phonenum;

    public NamePhone(String n, String p) {
        name = n;
        phonenum = p;
    }

    public String getName() {
        return name;
    }

    public String getPhonenum() {
        return phonenum;
    }
}