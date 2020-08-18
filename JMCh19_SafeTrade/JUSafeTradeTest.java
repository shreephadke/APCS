import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.regex.*;

import org.junit.*;

import static org.junit.Assert.*;
import junit.framework.JUnit4TestAdapter;


/**
 * SafeTrade tests: TradeOrder PriceComparator Trader Brokerage StockExchange
 * Stock
 *
 * @author Eric Chen, Bella Chen, Shree Phadke
 * @version 3/27/19
 * @author Assignment: JM Chapter 19 - SafeTrade
 * 
 * @author Sources: everyone
 *
 */

public class JUSafeTradeTest
{
    // --Test TradeOrder
    /**
     * TradeOrder tests: TradeOrderConstructor - constructs TradeOrder and then
     * compare toString TradeOrderGetTrader - compares value returned to
     * constructed value TradeOrderGetSymbol - compares value returned to
     * constructed value TradeOrderIsBuy - compares value returned to
     * constructed value TradeOrderIsSell - compares value returned to
     * constructed value TradeOrderIsMarket - compares value returned to
     * constructed value TradeOrderIsLimit - compares value returned to
     * constructed value TradeOrderGetShares - compares value returned to
     * constructed value TradeOrderGetPrice - compares value returned to
     * constructed value TradeOrderSubtractShares - subtracts known value &
     * compares result returned by getShares to expected value
     */
    private String symbol = "GGGL";

    private boolean buyOrder = true;

    private boolean marketOrder = true;

    private int numShares = 123;

    private int numToSubtract = 24;

    private double price = 123.45;


    @Test
    public void tradeOrderConstructor()
    {
        TradeOrder to = new TradeOrder( null, symbol, buyOrder, marketOrder, numShares, price );
        String toStr = to.toString();

        assertTrue( "<< Invalid TradeOrder Constructor >>",
            toStr.contains( "TradeOrder[Trader trader:null" )
                && toStr.contains( "java.lang.String symbol:" + symbol )
                && toStr.contains( "boolean buyOrder:" + buyOrder )
                && toStr.contains( "boolean marketOrder:" + marketOrder )
                && toStr.contains( "int numShares:" + numShares )
                && toStr.contains( "double price:" + price ) );
    }


    @Test
    public void TradeOrderToString()
    {
        TradeOrder to = new TradeOrder( null, symbol, buyOrder, marketOrder, numShares, price );
        assertNotNull( to.toString() );
    }


    @Test
    public void tradeOrderGetTrader()
    {
        TradeOrder to = new TradeOrder( null, symbol, buyOrder, marketOrder, numShares, price );
        assertNull( "<< TradeOrder: " + to.getTrader() + " should be null >>", to.getTrader() );
    }


    @Test
    public void tradeOrderGetSymbol()
    {
        TradeOrder to = new TradeOrder( null, symbol, buyOrder, marketOrder, numShares, price );
        assertEquals( "<< TradeOrder: " + to.getTrader() + " should be " + symbol + " >>",
            symbol,
            to.getSymbol() );
    }


    @Test
    public void tradeOrderIsBuy()
    {
        TradeOrder to = new TradeOrder( null, symbol, buyOrder, marketOrder, numShares, price );

        assertTrue( "<< TradeOrder: " + to.isBuy() + " should be " + buyOrder + " >>", to.isBuy() );
    }


    @Test
    public void tradeOrderIsSell()
    {
        TradeOrder to = new TradeOrder( null, symbol, buyOrder, marketOrder, numShares, price );
        assertFalse( "<< TradeOrder: " + to.isSell() + " should be " + !buyOrder + " >>",
            to.isSell() );
    }


    @Test
    public void tradeOrderIsMarket()
    {
        TradeOrder to = new TradeOrder( null, symbol, buyOrder, marketOrder, numShares, price );
        assertTrue( "<< TradeOrder: " + to.isMarket() + " should be " + marketOrder + " >>",
            to.isMarket() );
    }


    @Test
    public void tradeOrderIsLimit()
    {
        TradeOrder to = new TradeOrder( null, symbol, buyOrder, marketOrder, numShares, price );

        assertFalse( "<< TradeOrder: " + to.isLimit() + " should be " + !marketOrder + ">>",
            to.isLimit() );
    }


    @Test
    public void tradeOrderGetShares()
    {
        TradeOrder to = new TradeOrder( null, symbol, buyOrder, marketOrder, numShares, price );
        assertTrue( "<< TradeOrder: " + to.getShares() + " should be " + numShares + ">>",
            numShares == to.getShares() || ( numShares - numToSubtract ) == to.getShares() );
    }


    @Test
    public void tradeOrderGetPrice()
    {
        TradeOrder to = new TradeOrder( null, symbol, buyOrder, marketOrder, numShares, price );
        assertEquals( "<< TradeOrder: " + to.getPrice() + " should be " + price + ">>",
            price,
            to.getPrice(),
            0.0 );
    }


    @Test
    public void tradeOrderSubtractShares()
    {
        TradeOrder to = new TradeOrder( null, symbol, buyOrder, marketOrder, numShares, price );
        to.subtractShares( numToSubtract );
        assertEquals( "<< TradeOrder: subtractShares(" + numToSubtract + ") should be "
            + ( numShares - numToSubtract ) + ">>", numShares - numToSubtract, to.getShares() );
    }


    // --Test TraderWindow Stub
    @Test
    public void traderWindowConstructor()
    {
        TraderWindow tw = new TraderWindow( null );
        assertNotNull( tw );
    }


    @Test
    public void traderWindowShowMessage()
    {
        TraderWindow tw = new TraderWindow( null );
        assertNotNull( tw );
        tw.showMessage( null );
    }


    // --Test PriceComparator

    @Test
    public void priceComparatorConstructor()
    {
        PriceComparator pc = new PriceComparator();
        assertNotNull( pc );
    }


    @Test
    public void priceComparatorConstructorParam()
    {
        PriceComparator pc = new PriceComparator( true );
        assertNotNull( pc );
    }


    @Test
    public void priceComparatorCompare()
    {
        Trader t1 = new Trader( new Brokerage( new StockExchange() ), "", "" );
        // trader, symbol, buyOrder, marketOrder, numShares, price
        TradeOrder o1 = new TradeOrder( t1, "", false, true, 0, 0 );
        TradeOrder o2 = new TradeOrder( t1, "", false, false, 0, 0 );
        PriceComparator pc = new PriceComparator();

        assertEquals( pc.compare( o1, o2 ), -1 );
        assertEquals( pc.compare( o2, o1 ), 1 );

        o2 = new TradeOrder( t1, "", false, true, 0, 0 );
        assertEquals( pc.compare( o1, o2 ), 0 );

        o1 = new TradeOrder( t1, "", false, false, 0, 100 );
        o2 = new TradeOrder( t1, "", false, false, 0, 70 );
        assertEquals( pc.compare( o1, o2 ), 30 );
        assertEquals( pc.compare( o2, o1 ), 30 );
    }

    // --Test Trader

    private Trader t1 = new Trader( new Brokerage( new StockExchange() ), "name", "password" );

    private Brokerage b = new Brokerage( new StockExchange() );


    @Test
    public void traderConstructor()
    {
        assertNotNull( t1 );
    }


    @Test
    public void traderGetName()
    {
        assertEquals( t1.getName(), "name" );
    }


    @Test
    public void traderGetPassword()
    {
        assertEquals( t1.getPassword(), "password" );
    }


    @Test
    public void traderCompare()
    {
        StockExchange se = new StockExchange();
        Brokerage b = new Brokerage( se );
        se.listStock( "GGGL", "gooogly", 10 );

        Trader t1 = new Trader( b, "Colt", "password" );
        Trader t2 = new Trader( b, "Brock", "password" );
        Trader t3 = new Trader( b, "rico", "password" );
        assertTrue( "<< Trader: CompareTo should be negative, 0, positive >>",
            t1.compareTo( t3 ) < 0 && t1.compareTo( t1 ) == 0 && t1.compareTo( t2 ) > 0 );
    }


    @Test
    public void traderEquals()
    {
        Trader t2 = new Trader( b, "oame", "password" );
        assertEquals( t1.getName().equals( t2.getName() ), false );
        t2 = new Trader( b, "name", "password" );
        assertEquals( t1.getName().equals( t2.getName() ), true );
        try
        {
            t1.equals( b );
        }
        catch ( ClassCastException e )
        {

        }
    }


    @Test
    public void traderOpenWindow()
    {
        TraderWindow tw = new TraderWindow( t1 );
        assertNotNull( tw );
        t1.receiveMessage( "message" );
        assertFalse( t1.mailbox().size() == 0 );
    }


    @Test
    public void traderHasMessages()
    {
        assertTrue( t1.mailbox().isEmpty() );
    }


    @Test
    public void traderReceiveMessage()
    {
        String s1 = "one";
        t1.receiveMessage( s1 );
        assertTrue( t1.mailbox().peek().equals( s1 ) );
        t1.mailbox().remove().equals( s1 );
    }


    @Test
    public void traderGetQuote()
    {
        StockExchange se = new StockExchange();
        se.listStock( symbol, "gooogly", 10.00 );
        t1 = new Trader( new Brokerage( se ), "t1", "password" );
        t1.getQuote( symbol );
        assertTrue( "<< Invalid Trader getQuote >>", t1.hasMessages() );
        t1.openWindow();
        t1.getQuote( symbol );
        assertFalse( "<< Invalid Trader getQuote >>", t1.hasMessages() );
    }


    @Test
    public void traderPlaceOrder()
    {
        StockExchange se = new StockExchange();
        se.listStock( symbol, "goolge", 10.00 );
        t1 = new Trader( new Brokerage( se ), "t1", "password" );
        TradeOrder o1 = new TradeOrder( t1, symbol, true, false, 0, 0 );
        assertTrue( "<< mailbox isn't empty >>", t1.mailbox().isEmpty() );
        t1.placeOrder( o1 );
        assertTrue( "<< Invalid Trader placeOrder : should have messages >>", t1.hasMessages() );
        t1.openWindow();
        t1.placeOrder( o1 );
        assertFalse( "<< Invalid Trader placeOrder: should have no messages >>", t1.hasMessages() );
    }


    @Test
    public void traderQuit()
    {
        Brokerage b = new Brokerage( new StockExchange() );
        b.addUser( t1.getName(), t1.getPassword() );
        b.login( t1.getName(), t1.getPassword() );
        t1.quit();
        assertTrue( b.getLoggedTraders().size() == 0 );
    }


    // --Test Brokerage

    @Test
    public void brokerageConstructor()
    {
        StockExchange se = new StockExchange();
        se.listStock( "Nexus", "Nexus.com", 1000.0 );
        Brokerage b1 = new Brokerage( se );
        assertTrue( "error", b1.toString().contains( "Brokerage" ) );

    }


    @Test
    public void brokerageAddUser()
    {
        StockExchange se = new StockExchange();
        Brokerage b1 = new Brokerage( se );
        b1.addUser( "Nexus", "password" );
        assertTrue( "error", b1.getTraders().containsKey( "Nexus" ) );
    }


    @Test
    public void brokerageGetQuote()
    {
        StockExchange se = new StockExchange();
        se.listStock( "NXGS", "Nexus.com", 1000.0 );
        Brokerage b1 = new Brokerage( se );
        Trader t1 = new Trader( b1, "Nexus", "password" );
        b1.getQuote( symbol, t1 );
        assertTrue( "Error: should receive message.", t1.hasMessages() );
    }


    @Test
    public void brokerageLogin()
    {
        StockExchange se = new StockExchange();
        se.listStock( "NXGS", "Nexus.com", 1000.0 );
        Brokerage b1 = new Brokerage( se );
        Brokerage b2 = new Brokerage( se );
        Trader t1 = new Trader( b1, "nexus", "password" );
        b1.addUser( "nexus", "password" );

        assertTrue( "error", b1.login( "no", "password" ) == -1 );

        assertTrue( "error", b1.login( "nexus", "p" ) == -2 );

        b2.addUser( "nexus", "password" );
        assertTrue( "error",
            b1.login( "nexus", "password" ) == 0
                && b1.getLoggedTraders().contains( b1.getTraders().get( "nexus" ) )
                && !b1.getTraders().get( "nexus" ).hasMessages() );

    }


    @Test
    public void brokerageLogout()
    {
        StockExchange se = new StockExchange();
        se.listStock( "NXGS", "NexusGraphics.io", 1000.0 );
        Brokerage b1 = new Brokerage( se );
        Trader t1 = new Trader( b1, "nexus", "password" );
        b1.addUser( "nexus", "password" );
        b1.login( "nexus", "password" );
        b1.logout( t1 );
        assertTrue( "error", !b1.getLoggedTraders().contains( t1 ) );

    }


    @Test
    public void brokeragePlaceOrder()
    {
        StockExchange se = new StockExchange();
        se.listStock( "NXGS", "Nexus.com", 1000.00 );
        Brokerage b1 = new Brokerage( se );
        Trader t1 = new Trader( b1, "nexus", "password" );
        TradeOrder to1 = new TradeOrder( t1, symbol, true, false, 50, 1000.0 );
        b1.placeOrder( to1 );
        t1.openWindow();
        b1.placeOrder( to1 );
        assertFalse( "error", t1.hasMessages() );
    }


    @Test
    public void brokeragetoString()
    {
        StockExchange se = new StockExchange();
        Brokerage b1 = new Brokerage( se );
        assertNotNull( "error", b1.toString() );
    }


    // --Test StockExchange
    @Test
    public void stockExchangeConstructor()
    {
        StockExchange stocke = new StockExchange();
        assertTrue( stocke != null && stocke.toString() != null );
    }


    @Test
    public void stockExchangeListStock()
    {
        StockExchange se = new StockExchange();
        se.listStock( symbol, "Giggle", 10.0 );
        Map<String, Stock> listedStocks = se.getListedStocks();
        assertTrue( listedStocks.containsKey( symbol ) );
    }


    @Test
    public void stockExchangeGetQuote()
    {
        StockExchange se = new StockExchange();
        se.listStock( symbol, "Giggle", 10.0 );
        String quote = se.getQuote( symbol );
        assertTrue( quote != null );
    }


    @Test
    public void stockExchangePlaceOrder()
    {
        StockExchange se = new StockExchange();
        Brokerage b = new Brokerage( se );
        b.addUser( "name", "password" );
        Trader t = new Trader( b, "name", "password" );

        TradeOrder to = new TradeOrder( t, symbol, buyOrder, marketOrder, numShares, 10.0 );
        se.listStock( symbol, "Giggle", 10.0 );
        se.placeOrder( to );
        assertTrue( t.hasMessages() );

    }


    // --Test Stock

    @Test
    public void stockConstructor()
    {

    }


    @Test
    public void stockGetQuote()
    {

    }


    @Test
    public void stockPlaceOrder()
    {

    }


    @Test
    public void stockExecuteOrders()
    {

    }


    @Test
    public void stockToString()
    {

    }
    // Remove block comment below to run JUnit test in console
    /*
     * public static junit.framework.Test suite() { return new
     * JUnit4TestAdapter( JUSafeTradeTest.class ); }
     * 
     * public static void main( String args[] ) {
     * org.junit.runner.JUnitCore.main( "JUSafeTradeTest" ); }
     */
}
