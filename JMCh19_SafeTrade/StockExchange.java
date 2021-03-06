//StockExchange
import java.lang.reflect.*;
import java.util.*;

/**
 * 
 *  Represents a stock exchange. A <code>StockExchange</code> keeps a
 *  <code>HashMap</code> of stocks, keyed by a stock symbol. It has methods to
 *  list a new stock, request a quote for a given stock symbol, and to place a
 *  specified trade order.
 *
 *  @author  Bella Chen
 *  @version Mar 21, 2019
 *  @author  Period: 3
 *  @author  Assignment: JMCh19_SafeTrade
 *
 *  @author  Sources: TODO
 */
public class StockExchange
{
    private Map<String, Stock> listedStocks;
    
    // TODO complete class
    public StockExchange()
    {
        listedStocks = new HashMap<String, Stock>();
    }

    public void listStock(String symbol, String name, double price)
    {
        Stock s = new Stock(symbol, name, price);
        listedStocks.put( symbol, s );
    }
    
    public String getQuote(String symbol)
    {
        Stock s = listedStocks.get( symbol );
        return s.getQuote();
    }
    
    public void placeOrder(TradeOrder order)
    {
        String s = order.getSymbol();
        if (s != null) {
            if (!listedStocks.containsKey(s)) {
                order.getTrader().receiveMessage(s + " error");
                return;
            }
            Stock temp = listedStocks.get(s);
            temp.placeOrder(order);
        }
    }
    //
    // The following are for test purposes only
    //
    protected Map<String, Stock> getListedStocks()
    {
        return listedStocks;
    }
    
    /**
     * <p>
     * A generic toString implementation that uses reflection to print names and
     * values of all fields <em>declared in this class</em>. Note that
     * superclass fields are left out of this implementation.
     * </p>
     * 
     * @return a string representation of this StockExchange.
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

