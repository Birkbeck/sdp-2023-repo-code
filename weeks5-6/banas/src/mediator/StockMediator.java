package mediator;

import java.util.ArrayList;
import java.util.List;

public class StockMediator implements Mediator {

    private final List<Colleague> colleagues;
    private final List<StockOffer> stockBuyOffers;
    private final List<StockOffer> stockSaleOffers;

    private int colleagueCodes;

    public StockMediator() {

        colleagues = new ArrayList<>();
        stockBuyOffers = new ArrayList<>();
        stockSaleOffers = new ArrayList<>();
    }

    @Override
    public void addColleague(Colleague newColleague) {
        colleagues.add(newColleague);
        colleagueCodes++;
        newColleague.setColleagueCode(colleagueCodes);
    }

    @Override
    public void saleOffer(String stock, int shares, int collCode) {

        boolean stockSold = false;

        for (StockOffer offer : stockBuyOffers) {

            if ((offer.getStockSymbol().equals(stock)) && (offer.getStockShares() == shares)) {
                System.out.println(shares + " shares of " + stock +
                    " sold to colleague code " + offer.getColleagueCode());
                stockBuyOffers.remove(offer);
                stockSold = true;
                break;
            }
        }

        if (!stockSold) {
            System.out.println(shares + " shares of " + stock +
                " added to inventory");

            StockOffer newOffering = new StockOffer(shares, stock, collCode);
            stockSaleOffers.add(newOffering);
        }
    }

    @Override
    public void buyOffer(String stock, int shares, int collCode) {

        boolean stockBought = false;

        for (StockOffer offer : stockSaleOffers) {
            if ((offer.getStockSymbol().equals(stock)) && (offer.getStockShares() == shares)) {
                System.out.println(shares + " shares of " + stock +
                    " bought by colleague code " + offer.getColleagueCode());

                stockSaleOffers.remove(offer);
                stockBought = true;
                break;
            }
        }

        if (!stockBought) {
            System.out.println(shares + " shares of " + stock +
                " added to inventory");
            StockOffer newOffering = new StockOffer(shares, stock, collCode);
            stockBuyOffers.add(newOffering);
        }
    }

    public void getstockOfferings() {

        System.out.println("\nStocks for Sale");
        for (StockOffer offer : stockSaleOffers) {
            System.out.println(offer.getStockShares() + " of " + offer.getStockSymbol());
        }

        System.out.println("\nStock Buy Offers");
        for (StockOffer offer : stockBuyOffers) {
            System.out.println(offer.getStockShares() + " of " + offer.getStockSymbol());
        }
    }
}