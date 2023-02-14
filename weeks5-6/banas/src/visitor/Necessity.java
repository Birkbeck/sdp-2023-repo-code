package visitor;

class Necessity implements Visitable {

    private final double price;

    Necessity(double price) {
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