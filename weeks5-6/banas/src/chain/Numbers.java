package chain;

// This object will contain 2 numbers and a
// calculation to perform in the form of a String

public class Numbers {

    private final int number1;
    private final int number2;

    private final String calculationWanted;

    public Numbers(int number1, int number2, String calculationWanted) {
        this.number1 = number1;
        this.number2 = number2;
        this.calculationWanted = calculationWanted;
    }

    public int getNumber1() {
        return number1;
    }

    public int getNumber2() {
        return number2;
    }

    public String getCalcWanted() {
        return calculationWanted;
    }
}