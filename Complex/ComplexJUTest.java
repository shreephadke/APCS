import org.junit.*;

import static org.junit.Assert.*;
import junit.framework.JUnit4TestAdapter;


/**
 * Test for the complex number class.
 * 
 * testConstructor1Param - test the 1 parameter constructor
 * testConstructor2Param - test the 2 parameter constructor
 * testAddRealAndComplexNum - addition of a complex number with a real number
 * testAdd2ComplexNums - addition of two complex numbers
 * testMultiply2ComplexNums - multiplication of two complex numbers
 * testMultiplyRealAndComplexNum - multiplication of a complex number with a
 * real number testAbsoluteValue - absolute value of a complex number
 *
 * @author TODO Shree Phadke
 * @version TODO 10/5/18
 * @author Period: TODO Period 3
 * @author Assignment: JMCh09Ex17_Complex
 *
 * @author Sources: TODO None
 */
public class ComplexJUTest extends junit.framework.TestCase
{

    Complex c1 = new Complex( 1, 2 );

    Complex c2 = new Complex( 3, 4 );

    Complex c3 = new Complex( 4 );


    @Test
    public void testConstructor1Param()
    {
        assertEquals( "4.0 + 0.0i", c3.toString() ); // n.0 + 0.0i ---> Complex
                                                     // (n)

    }


    @Test
    public void testConstructor2Param()
    {

        assertEquals( "1.0 + 2.0i", c1.toString() );
        assertEquals( "3.0 + 4.0i", c2.toString() );

    }


    @Test
    public void testAddRealAndComplexNum()
    {

        assertEquals( "11.0 + 2.0i", c1.add( 10 ).toString() );

    }


    @Test
    public void testAdd2ComplexNums()
    {

        assertEquals( "4.0 + 6.0i", c1.add( c2 ).toString() );

    }


    @Test
    public void testMultiply2ComplexNums()
    {
        assertEquals( "-5.0 + 10.0i", c1.multiply( c2 ).toString() );
    }


    @Test
    public void testMultiplyRealAndComplexNum()
    {
        assertEquals( "10.0 + 20.0i", c1.multiply( 10 ).toString() );
    }


    @Test
    public void testAbsoluteValue()
    {
        assertEquals( 5.0, c2.abs() );
    }


    public static junit.framework.Test suite()
    {
        return new JUnit4TestAdapter( ComplexJUTest.class );
    }


    public static void main( String args[] )
    {
        org.junit.runner.JUnitCore.main( "ComplexJUTest" );
    }
}
