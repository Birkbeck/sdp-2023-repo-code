public class UnitUpgrader {
    public void upgrade(PenthouseSuite penthouseSuite) {
        upgradeSquareFootage(penthouseSuite);
        penthouseSuite.numberOfBedrooms += 1;
    }

    public void upgrade(Studio studio) {
        upgradeSquareFootage(studio);
    }

    private void upgradeSquareFootage(Apartment apartment) {
        apartment.squareFootage += 40;
    }
}
