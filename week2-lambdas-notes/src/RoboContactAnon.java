import java.util.List;

public class RoboContactAnon {

    public void phoneContacts(List<Person> pl, MyTest<Person> aTest) {
        for (Person p : pl) {
            if (aTest.test(p)) {
                roboCall(p);
            }
        }
    }

    public void emailContacts(List<Person> pl, MyTest<Person> aTest) {
        for (Person p : pl) {
            if (aTest.test(p)) {
                roboEmail(p);
            }
        }
    }

    public void mailContacts(List<Person> pl, MyTest<Person> aTest) {
        for (Person p : pl) {
            if (aTest.test(p)) {
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