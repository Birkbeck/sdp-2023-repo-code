package chain;

public class DivideNumbers implements Chain {

    private Chain nextInChain;

    @Override
    public void setNextChain(Chain nextInChain) {
        this.nextInChain = nextInChain;
    }

    @Override
    public void calculate(Numbers request) {

        if ("div".equals(request.getCalcWanted())) {
            System.out.print(request.getNumber1() + " / " + request.getNumber2() + " = "
                + (request.getNumber1() / request.getNumber2()));
        }
        else {
            System.out.print("Only works for add, sub, mult, and div");
        }
    }
}