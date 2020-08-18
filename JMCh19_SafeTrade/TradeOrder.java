import java.lang.reflect.*;

/**
 * Represents a buy or sell order for trading a given number of shares of a
 * specified stock.
 */
public class TradeOrder
{
    private Trader trader;
    private String symbol;
    private boolean buyOrder;
    private boolean marketOrder;
    private int numShares;
    private double price;

    // TODO complete class
    public TradeOrder(Trader trader, String symbol, 
        boolean buyOrder, boolean marketOrder, 
        int numShares, double price)
    {
        this.trader = trader;
        this.symbol = symbol;
        this.buyOrder = buyOrder;
        this.marketOrder = marketOrder;
        this.numShares = numShares;
        this.price = price;
    }

    public Trader getTrader()
    {
        return trader;
    }
    
    public String getSymbol()
    {
        return symbol;
    }
    
    public boolean isBuy()
    {
        return buyOrder == true;
    }
    
    public boolean isSell()
    {
        return buyOrder == false;
    }
    
    public boolean isMarket()
    {
        return marketOrder == true;
    }
    
    public boolean isLimit()
    {
        return marketOrder == false;
    }
    
    public int getShares()
    {
        return numShares;
    }
    
    public double getPrice()
    {
        return price;
    }
    
    public void subtractShares(int shares)
    {
        if (shares > numShares)
        {
            throw new IllegalArgumentException();
        }
        else
        {
            numShares = numShares - shares;
        }
    }
    //
    // The following are for test purposes only
    //
    /**
     * <p>
     * A generic toString implementation that uses reflection to print names and
     * values of all fields <em>declared in this class</em>. Note that
     * superclass fields are left out of this implementation.
     * </p>
     * 
     * @return a string representation of this TradeOrder.
     */
    public String toString()
    {
        String str = this.getClass().getName() + "[";
        String separator = "";

        Field[] fields = this.getClass().getDeclaredFields();

        for ( Field field : fields )
        {
            try
            {
                str += separator + field.getType().getName() + " "
                    + field.getName() + ":" + field.get( this );
            }
            catch ( IllegalAccessException ex )
            {
                System.out.println( ex );
            }

            separator = ", ";
        }

        return str + "]";
    }
}

