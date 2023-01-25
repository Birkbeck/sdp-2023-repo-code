import java.util.List;

public class RoboContactMethods {

    public void callDrivers(List<Person> pl) {
        for (Person p : pl) {
            if (p.getAge() >= 16) {
                roboCall(p);
            }
        }
    }

    public void emailDraftees(List<Person> pl) {
        for (Person p : pl) {
            if (p.getAge() >= 18 && p.getAge() <= 25
                    && p.getGender() == Gender.MALE) {
                roboEmail(p);
            }
        }
    }

    public void mailPilots(List<Person> pl) {
        for (Person p : pl) {
            if (p.getAge() >= 23 && p.getAge() <= 65) {
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