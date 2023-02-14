package visitor;

class Tobacco implements Visitable {

    private final double price;

    Tobacco(double price) {
        this.price = price;
    }

    @Override
    public double accept(Visitor visitor) {
        return visitor.visit(this);
    }

    public double getPrice() {
        return price;
    }

}