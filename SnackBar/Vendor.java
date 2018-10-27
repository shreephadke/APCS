import java.lang.reflect.*;


/**
 * This class implements a vendor that sells one kind of item. A vendor carries
 * out sales transactions.
 *
 * @author Shree Phadke
 * @author Period - 3
 * @author Assignment - Java Methods Ch09 - SnackBar
 * @author Sources - None
 * @version 10/1/18
 */
public class Vendor
{
    /**
     * The price that this item is selling for
     */
    private int price = 0;

    /**
     * The total number of items vendor can sell
     */
    private int stock = 0;

    /**
     * The total value deposited
     */
    private int deposit = 0;

    /**
     * The amount of money that should be returned to the user
     */
    private int change = 0;

    private static double totalSales = 0;


    /**
     * Create a new Vendor instance selling {stock} items at {price}
     *
     * @param price
     *            The price of the item in cents
     * @param stock
     *            The number of items the vendor starts with
     */
    public Vendor( int price, int stock )
    {
        this.price = price;
        this.stock = stock;
        totalSales = 0;
    }


    /**
     * Update the number of items this vendor can sell
     *
     * @param stock
     *            The number of items this vendor can sell
     */
    public void setStock( int stock )
    {
        this.stock = stock;
    }


    /**
     * @return The number of items currently in stock
     */
    public int getStock()
    {
        return this.stock;
    }


    // Adds a specified amount (in cents) to the deposited amount.
    // Parameters:
    // int number of cents to add to the deposit
    // Return:
    // None

    /**
     * 
     * TODO Adds deposit to the old deposit
     * 
     * @param d
     *            into machine
     */

    public void addMoney( int d )
    {
        if ( stock > 0 )
        {
            this.deposit += d;

        }
    }


    // Returns the currently deposited amount (in cents).
    // Parameters:
    // None
    // Return:
    // int number of cents in the current deposit

    /**
     * 
     * TODO Finds the total deposit
     * 
     * @return this.deposit the deposit
     */
    public int getDeposit()
    {
        return this.deposit;
    }


    // Implements a sale. If there are items in stock and
    // the deposited amount is greater than or equal to
    // the single item price, then adjusts the stock
    // and calculates and sets change and returns true;
    // otherwise refunds the whole deposit (moves it into change)
    // and returns false.
    // Parameters:
    // None
    // Return:
    // boolean successful sale (true) or failure (false)

    /**
     * 
     * TODO Checks if a sale has been made
     * 
     * @return true or false
     */
    public boolean makeSale()
    {
        if ( stock > 0 && deposit >= price )
        {
            stock--;
            change = deposit - price;
            deposit = 0;
            totalSales += price / 100.0;
            return true;
        }
        change += deposit;
        deposit = 0;
        return false;
    }


    // Returns and zeroes out the amount of change (from the last
    // sale or refund).
    // Parameters:
    // None
    // Return:
    // int number of cents in the current change

    /**
     * 
     * TODO Finds your change
     * 
     * @return change
     */
    public int getChange()
    {
        return change;
    }


    /**
     * 
     * TODO How many sales have been made in total
     * 
     * @return totalSales
     */
    public static double getTotalSales()
    {
        return totalSales;
    }


    /**
     * Intended only for debugging.
     *
     * <p>
     * A generic toString implementation that uses reflection to print names and
     * values of all fields <em>declared in this class</em>. Note that
     * superclass fields are left out of this implementation.
     * </p>
     *
     * @return a string representation of this Vendor.
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
                str += separator + field.getName() + ":" + field.get( this );
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