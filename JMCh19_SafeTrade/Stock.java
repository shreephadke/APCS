import java.util.*;
import java.lang.reflect.*;
import java.text.DecimalFormat;


/**
 * Represents a stock in the SafeTrade project
 * 
 * @author Shree Phadke, Bella Chen
 * @version 3/26/19
 * @author Period: 3
 * @author Assignment: JMCh19_SafeTrade
 *
 * @author Sources: None
 */
public class Stock
{
    /**
     * a static decimalformat
     */
    private static DecimalFormat money = new DecimalFormat( "0.00" );

    private String stockSymbol;

    private String companyName;

    private double loPrice;

    private double hiPrice;

    private double lastPrice;

    private int volume;

    // private String quote;

    private PriorityQueue<TradeOrder> buyOrders;

    private PriorityQueue<TradeOrder> sellOrders;


    /**
     * constructor for stock class
     * 
     * @param symbol
     *            the string
     * @param name
     *            the name
     * @param price
     *            the price
     */
    public Stock( String symbol, String name, double price )
    {
        sellOrders = new PriorityQueue<TradeOrder>( 10, new PriceComparator( true ) );
        buyOrders = new PriorityQueue<TradeOrder>( 10, new PriceComparator( false ) );
        stockSymbol = symbol;
        companyName = name;
        loPrice = price;
        hiPrice = price;
        lastPrice = price;
        volume = 0;

    }


    /**
     * executes orders
     */
    protected void executeOrders()
    {
        if ( sellOrders.isEmpty() && buyOrders.isEmpty() )
        {
            return;
        }
        while ( !sellOrders.isEmpty() && !buyOrders.isEmpty() )
        {
            TradeOrder topBuy = buyOrders.peek();
            TradeOrder topSell = sellOrders.peek();
            double askPrice = topSell.getPrice();
            double sellPrice = topBuy.getPrice();
            double finPrice = 0;
            int buyShares = topBuy.getShares();
            int sellShares = topSell.getShares();

            if ( ( topBuy.isLimit() && topSell.isLimit() ) && askPrice <= sellPrice )
            {
                finPrice = sellPrice;

            }
            else if ( topBuy.isMarket() && topSell.isLimit() )
            {
                finPrice = askPrice;

            }
            else if ( topBuy.isLimit() && topSell.isMarket() )
            {
                finPrice = sellPrice;
            }
            else if ( topBuy.isMarket() && topSell.isMarket() )
            {
                finPrice = lastPrice;
            }
            int shares;

            if ( buyShares < sellShares )
            {
                shares = buyShares;
            }
            else
            {
                shares = sellShares;
            }

            topBuy.subtractShares( shares );
            topSell.subtractShares( shares );

            if ( buyShares == 0 )
            {
                buyOrders.remove( topBuy );
            }
            else if ( sellShares == 0 )
            {
                sellOrders.remove( topSell );
            }

            if ( loPrice > finPrice )
            {
                loPrice = finPrice; // updates loPrice
            }
            if ( hiPrice < finPrice )
            {
                hiPrice = finPrice; // updates hiPrice
            }

            
            volume = (int)( volume + shares ); // updates volume
            double amt = shares * finPrice;

            topBuy.getTrader()
                .receiveMessage( "You bought: " + shares + " " + stockSymbol + " at "
                    + money.format( finPrice ) + " amt " + money.format( amt ) );
            topSell.getTrader()
                .receiveMessage( "You sold: " + shares + " " + stockSymbol + " at "
                    + money.format( finPrice ) + " amt " + money.format( amt ) );

        }

    }


    /**
     * gets a quote
     * 
     * @return String a quote
     */
    protected String getQuote()
    {
        String quote = "";
        String askStr = "";
        String bidStr = "";
        String symbolStr = companyName + "  (" + stockSymbol + ")";
        String priceStr = "Price: " + lastPrice + " " + "hi: " + hiPrice + " " + "lo: " + loPrice
            + " " + "vol: " + volume;

        if ( buyOrders.isEmpty() )
        {
            bidStr = "Bid: none";
        }
        else if ( !buyOrders.isEmpty() )
        {
            bidStr = "Bid: " + buyOrders.peek().getPrice() + " " + "size: "
                + buyOrders.peek().getShares();
        }
        if ( sellOrders.isEmpty() )
        {
            askStr = "Ask: none";
        }
        else if ( !sellOrders.isEmpty() )
        {
            askStr = "Ask: " + sellOrders.peek().getPrice() + " " + "size: "
                + sellOrders.peek().getShares();
        }

        quote = symbolStr + "\n" + priceStr + "\n" + bidStr + " " + askStr;

        return quote;
    }


    /**
     * places an order
     * 
     * @param order
     *            the tradeorder
     */
    public void placeOrder( TradeOrder order )
    {
        if ( order == null )
        {
            return;
        }
        if ( order.isBuy() )
        {
            String msg = "";
            buyOrders.add( order );
            if ( order.isLimit() )
            {
                msg = "New order: Buy " + order.getSymbol() + " (" + companyName + ")" + "\n"
                    + order.getShares() + " shares at " + money.format( order.getPrice() );
            }
            else
            {
                msg = "New order: Buy " + order.getSymbol() + " (" + companyName + ")" + "\n"
                    + order.getShares() + " shares at market";
            }
            order.getTrader().receiveMessage( msg );
        }
        else
        {
            String msg = "";
            sellOrders.add( order );
            if ( order.isLimit() )
            {
                msg = "New order: Sell " + order.getSymbol() + " (" + companyName + ")" + "\n"
                    + order.getShares() + " shares at " + money.format( order.getPrice() );
            }
            else
            {
                msg = "New order: Sell " + order.getSymbol() + " (" + companyName + ")" + "\n"
                    + order.getShares() + " shares at market";
            }
            order.getTrader().receiveMessage( msg );
        }
        executeOrders();
    }


    //
    // The following are for test purposes only
    //

    /**
     * returns the stocksymbol
     * 
     * @return string the symbol
     */
    protected String getStockSymbol()
    {
        return stockSymbol;
    }


    /**
     * gets the company name
     * 
     * @return the company name
     */
    protected String getCompanyName()
    {
        return companyName;
    }


    /**
     * returns the price
     * 
     * @return double the loprice
     */
    protected double getLoPrice()
    {
        return loPrice;
    }


    /**
     * returns the hiprice
     * 
     * @return hiPrice the hiPrice
     */
    protected double getHiPrice()
    {
        return hiPrice;
    }


    /**
     * return the lastprice
     * 
     * @return double lastprice
     */
    protected double getLastPrice()
    {
        return lastPrice;
    }


    /**
     * gets the volume
     * 
     * @return the volume
     */
    protected int getVolume()
    {
        return volume;
    }


    /**
     * gets the buy orders
     * 
     * @return priorityqueue the orders
     */
    protected PriorityQueue<TradeOrder> getBuyOrders()
    {
        return buyOrders;
    }


    /**
     * returns selled orders
     * 
     * @return the orders
     */
    protected PriorityQueue<TradeOrder> getSellOrders()
    {
        return sellOrders;
    }


    /**
     * <p>
     * A generic toString implementation that uses reflection to print names and
     * values of all fields <em>declared in this class</em>. Note that
     * superclass fields are left out of this implementation.
     * </p>
     * 
     * @return a string representation of this Stock.
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
                str += separator + field.getType().getName() + " " + field.getName() + ":"
                    + field.get( this );
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