/**
 *  the pricecomparator class
 *  compares two tradeorders
 *
 *  @author  Eric Chen
 *  @version 3/22/2019
 *  @author  Period: 3
 *  @author  Assignment: JMCh19_SafeTrade
 *
 *  @author  Sources: Eric Chen
 */
public class PriceComparator implements java.util.Comparator<TradeOrder>
{

    private boolean ascending;
    
    /**
     * constructor for class
     */
    public PriceComparator() {
        ascending = true;
    }
    
    /**
     * constructor with parameter
     * @param asc ascending
     */
    public PriceComparator(boolean asc) {
        ascending = asc;
    }
    
    @Override
    /**
     * compares two tradeorders
     * @return int or difference in price
     */
    public int compare(TradeOrder o1, TradeOrder o2)
    {
        if (o1.isMarket() && o2.isLimit()) {
            return -1;
        }
        if (o1.isLimit() && o2.isMarket()) {
            return 1;
        }
        if (o1.isMarket() && o2.isMarket()) {
            return 0;
        }
        else {
            if (o1.getPrice() > o2.getPrice()) {
                return (int)(o1.getPrice() - o2.getPrice());
            }
            return (int)(o2.getPrice() - o1.getPrice());
        }
    }
}

