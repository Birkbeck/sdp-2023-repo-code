import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class Person {
    private int age;
    private String givenName;
    private String surname;
    private Gender gender;
    private String phone;
    private String address;
    private String email;

    public int getAge() { return age; }
    public String getGivenName() { return givenName; }
    public String getSurname() { return surname; }
    public Gender getGender() { return gender; }
    public String getPhone() { return phone; }
    public String getAddress() { return address; }
    public String getEmail() { return email; }

    public void printName() {
        System.out.println("\nName: " + getGivenName() + " "
                + getSurname() + "\n" +
                "Age: " + getAge() + " " + "Gender: "
                + getGender() + "\n" +
                "EMail: " + getEmail() + "\n" +
                "Phone: " + getPhone() + "\n" +
                "Address: " + getAddress());
    }

    private static class Builder {
        Person person;

        Builder givenName(String givenName) { person.givenName = givenName; return this; }
        Builder surname(String surname) { person.surname = surname; return this; }
        Builder age(int age) { person.age = age; return this; }
        Builder gender(Gender gender) { person.gender = gender; return this; }
        Builder email(String email) { person.email = email; return this; }
        Builder phone(String phone) { person.phone = phone; return this; }
        Builder address(String address) { person.address = address; return this; }
        Person build() { return person; }
    }

    public static List<Person> createShortList() {
        List<Person> people = new ArrayList<>();

        people.add(
                new Builder()
                        .givenName("Bob")
                        .surname("Baker")
                        .age(21)
                        .gender(Gender.MALE)
                        .email("bob.baker@example.com")
                        .phone("201-121-4678")
                        .address("44 4th St, Smallville, KS 12333")
                        .build()
        );

        people.add(
                new Builder()
                        .givenName("Jane")
                        .surname("Doe")
                        .age(25)
                        .gender(Gender.FEMALE)
                        .email("jane.doe@example.com")
                        .phone("202-123-4678")
                        .address("33 3rd St, Smallville, KS 12333")
                        .build()
        );

        people.add(
                new Builder()
                        .givenName("John")
                        .surname("Doe")
                        .age(25)
                        .gender(Gender.MALE)
                        .email("john.doe@example.com")
                        .phone("202-123-4678")
                        .address("33 3rd St, Smallville, KS 12333")
                        .build()
        );
        return people;
    }

    public void printNameStyle1() {
        System.out.println("\nName: " + this.getGivenName() + " "
                + this.getSurname() + "\n" +
                "Age: " + this.getAge() + " " + "Gender: "
                + this.getGender() + "\n" +
                "EMail: " + this.getEmail() + "\n" +
                "Phone: " + this.getPhone() + "\n" +
                "Address: " + this.getAddress());
    }

    public void printNameStyle2() {
        System.out.println("\nName: " + this.getSurname() + " "
                + this.getGivenName() + "\n" +
                "Age: " + this.getAge() + " " + "Gender: "
                + this.getGender() + "\n" +
                "EMail: " + this.getEmail() + "\n" +
                "Phone: " + this.getPhone() + "\n" +
                "Address: " + this.getAddress());
    }

    public String printCustom(Function<Person,String> f){
        return f.apply(this);
    }
}
