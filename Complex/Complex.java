/**
 * Represents a complex number of the form a + bi. Provides methods for adding,
 * multiplying and calculating the absolute value.
 *
 * @author Shree Phadke
 * @version 10/3/18
 * @author Period: 3
 * @author Assignment: JMCh09Ex17_Complex
 *
 * @author Sources: None
 */

public class Complex
{

    private double a;

    private double b;

    // other.a + other.b
    // a + b

    // TODO Constructors


    /**
     * 
     * @param a
     *            real number
     */
    public Complex( double a )
    {
        this.a = a;
        b = 0;
    }


    /**
     * 
     * @param a
     *            real number
     * @param b
     *            imaginary number
     */
    public Complex( double a, double b )
    {

        this.a = a;
        this.b = b;

    }


    // TODO Methods

    /**
     * 
     * TODO Adds real with a real, complex with a complex (uses Complex object)
     * 
     * @param other
     *            expression to add with
     * @return new Complex object
     */
    public Complex add( Complex other )
    {
        double sumReal = a + other.a;
        double sumIma = b + other.b;
        Complex sum = new Complex( sumReal, sumIma );
        return sum;
    }


    /**
     * 
     * TODO Finds magnitude of a and b
     * 
     * @return returns magnitude
     */
    public double abs()
    {

        return Math.sqrt( ( a * a + b * b ) );
    }


    /**
     * 
     * TODO Multiplies real with real, complex with complex
     * 
     * @param other
     *            expression
     * @return prod the product
     */
    public Complex multiply( Complex other )
    {
        double prodA = ( a * other.a ) + ( ( b * other.b ) * -1 );
        double prodB = ( a * other.b ) + ( b * other.a );
        Complex prod = new Complex( prodA, prodB );
        return prod;

    }


    /**
     * 
     * TODO Adds real with a real, complex with a complex (uses Complex object)
     * 
     * @param x
     *            other real number
     * @return a sum
     */
    public Complex add( double x )
    {

        a += x;
        Complex sum = new Complex( a, b );
        return sum;

    }


    /**
     * 
     * TODO Multiplies real with real
     * 
     * @param x
     *            other real
     * @return new Complex object
     */
    public Complex multiply( double x )
    {

        a *= x;
        b *= x;

        Complex prod = new Complex( a, b );
        return prod;

    }


    /**
     * 
     * @return String format, returns -1 on an error
     * 
     */
    public String toString()
    {
        return a + " + " + b + "i";

    }
}
