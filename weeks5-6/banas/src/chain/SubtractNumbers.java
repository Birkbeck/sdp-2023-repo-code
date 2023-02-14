package chain;

public class SubtractNumbers implements Chain {

    private Chain nextInChain;

    @Override
    public void setNextChain(Chain nextInChain) {
        this.nextInChain = nextInChain;
    }

    @Override
    public void calculate(Numbers request) {
        if ("sub".equals(request.getCalcWanted())) {
            System.out.print(request.getNumber1() + " - " + request.getNumber2() + " = " +
                (request.getNumber1() - request.getNumber2()));
        }
        else {
            nextInChain.calculate(request);
        }
    }
}