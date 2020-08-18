import java.lang.reflect.*;
import java.util.*;
/**
 * 
 *  represents a trader
 *  code for the trader class
 *
 *  @author  Eric Chen
 *  @version 3/22/2019
 *  @author  Period: 3
 *  @author  Assignment: JMCh19_SafeTrade
 *
 *  @author  Sources: Eric Chen
 */
public class Trader implements Comparable<Trader>
{
    private Brokerage brokerage;
    private String screenName, password;
    private TraderWindow myWindow;
    private Queue<String> mailbox;

    /**
     * constructor for trader
     * @param b the brokerage
     * @param name the name
     * @param pass the password
     */
    public Trader(Brokerage b, String name, String pass) {
        brokerage = b;
        screenName = name;
        password = pass;
        mailbox = new LinkedList<String>();
    }

    /**
     * returns the name
     * @return screenName the name
     */
    public String getName() {
        return screenName;
    }
    
    /**
     * returns the password
     * @return password the password
     */
    public String getPassword() {
        return password;
    }
    
    @Override
    /**
     * @param o the trader
     * return int the compare result
     */
    public int compareTo(Trader o) {
        return screenName.compareToIgnoreCase(o.getName());
    }
    
    /**
     * determines if trader equals or not
     * @param o the other trader
     * @return boolean equals
     */
    public boolean equals(Trader o) {
        try {
            return screenName.equalsIgnoreCase(o.getName());
        }
        catch (Exception e){
            throw new ClassCastException();
        }
    }
    
    /**
     * opens the window
     */
    public void openWindow() {
        myWindow = new TraderWindow(this);
        while (mailbox.size() > 0) {
            myWindow.showMessage(mailbox.remove());
        }
    }
    
    /**
     * has messages in the mailbox
     * @return boolean true or false
     */
    public boolean hasMessages() {
        return mailbox.size() > 0;
    }
    
    /**
     * TODO Write your method description here.
     * @param msg
     */
    public void receiveMessage(String msg) {
        mailbox.add(msg);
        if (myWindow != null) {
            while (mailbox.size() > 0) {
                myWindow.showMessage(mailbox.remove());
            }
        }
    }
    
    /**
     * gets the quote
     * @param symbol the symbol for quote
     */
    public void getQuote(String symbol) {
         brokerage.getQuote(symbol, this);
    }
    
    /**
     * places the order
     * @param order the order
     */
    public void placeOrder(TradeOrder order) {
        brokerage.placeOrder(order);
    }
    
    /**
     * quits and sets myWindow to null
     */
    public void quit() {
        brokerage.logout(this);
        myWindow = null;
    }
    
    //
    // The following are for test purposes only
    //
    /**
     * returns the mailbox
     * @return mailbox the mailbox
     */
    protected Queue<String> mailbox()
    {
        return mailbox;
    }
    
    /**
     * <p>
     * A generic toString implementation that uses reflection to print names and
     * values of all fields <em>declared in this class</em>. Note that
     * superclass fields are left out of this implementation.
     * </p>
     * 
     * @return a string representation of this Trader.
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
                if ( field.getType().getName().equals( "Brokerage" ) )
                    str += separator + field.getType().getName() + " "
                        + field.getName();
                else
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

