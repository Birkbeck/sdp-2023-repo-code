abstract sealed class Apartment  permits PenthouseSuite, Studio {
    int squareFootage;

    public void setSquareFootage(int sqft) {
        this.squareFootage = sqft;
    }
}
