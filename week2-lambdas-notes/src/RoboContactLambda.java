import java.util.List;
import java.util.function.Predicate;

public class RoboContactLambda {
    public void phoneContacts(List<Person> pl, Predicate<Person> pred) {
        for (Person p : pl) {
            if (pred.test(p)) {
                roboCall(p);
            }
        }
    }

    public void emailContacts(List<Person> pl, Predicate<Person> pred) {
        for (Person p : pl) {
            if (pred.test(p)) {
                roboEmail(p);
            }
        }
    }

    public void mailContacts(List<Person> pl, Predicate<Person> pred) {
        for (Person p : pl) {
            if (pred.test(p)) {
                roboMail(p);
            }
        }
    }

    public void roboCall(Person p) {
        System.out.println("Calling " + personInfo(p)
                + " at " + p.getPhone());
    }

    public void roboEmail(Person p) {
        System.out.println("EMailing " + personInfo(p)
                + " at " + p.getEmail());
    }

    public void roboMail(Person p) {
        System.out.println("Mailing " + personInfo(p)
                + " at " + p.getAddress());
    }

    private String personInfo(Person p) {
        return p.getGivenName() + " " + p.getSurname()
                + " age " + p.getAge();
    }
}