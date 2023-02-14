package chain;

public class AddNumbers implements Chain {

    private Chain nextInChain;

    // Defines the next Object to receive the
    // data if this one can't use it

    @Override
    public void setNextChain(Chain nextInChain) {
        this.nextInChain = nextInChain;
    }

    // Tries to calculate the data, or passes it
    // to the Object defined in method setNextChain()

    @Override
    public void calculate(Numbers request) {

        if ("add".equals(request.getCalcWanted())) {
            System.out.print(request.getNumber1() + " + " + request.getNumber2() + " = "
                + (request.getNumber1() + request.getNumber2()));
        }
        else {
            nextInChain.calculate(request);
        }
    }
}