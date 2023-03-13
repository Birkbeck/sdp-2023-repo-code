package immutable;

import java.util.Date;


class MutableIDCard {

    private String name;
    private Date dateOfBirth;

    public MutableIDCard(String name, Date dateOfBirth) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
    }

    //  setter - USED BY OFFICERS
    public void set(String name, Date dateOfBirth) {
        check(name, dateOfBirth);
        synchronized (this) {
            this.name = name;
            this.dateOfBirth = dateOfBirth;
        }
    }

    //============================
    // getters  - USED BY CITIZENS
    public synchronized String getName() {
        return name;
    }

    public synchronized Date getDateOfBirth() {
        return dateOfBirth;
    }

    //============================

    // check everything valid
    public void check(String name, Date dateOfBirth) {
        if (name == null || name.equals("")) {
            throw new IllegalArgumentException();
        }
        if (dateOfBirth == null) {
            throw new IllegalArgumentException();
        }
        long now = new Date().getTime();
        long age = now - dateOfBirth.getTime();
        if (age <= 0) {
            throw new IllegalArgumentException();
        }
    }

    // make age
}


