package five;

import java.util.ArrayList;
import java.util.stream.Stream;

//Use map() to create a new stream that contains only
//selected aspects of the original stream.
public class StreamDemo {
    public static void main(String[] args) {
    // A list of names, phone numbers, and e-mail addresses.
        ArrayList<NamePhoneEmail> myList = new ArrayList<>();
        myList.add(new NamePhoneEmail("Fred", "555-5555", "Fred@dodgy.com"));
        myList.add(new NamePhoneEmail("James", "555-4444", "James@dodgy.com"));
        myList.add(new NamePhoneEmail("Mary", "555-3333", "Mary@dodgy.com"));
        System.out.println("Original values in myList: ");
        myList.stream().forEach((a) -> {
            System.out.println(a.getName() + " " + a.getPhonenum() + " "
                    + a.getEmail());
        });
        System.out.println();
        // Map just the names and phone numbers to a new stream.
        Stream<NamePhone> nameAndPhone = myList.stream()
                .map((a) -> new NamePhone(a.getName(), a.getPhonenum()));
        System.out.println("List of names and phone numbers: ");
        nameAndPhone.forEach((a) -> {
            System.out.println(a.getName() + " " + a);
        });
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