import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;


/**
 * A class for calculating Statistics on a set of numbers.
 *
 * @author Shree Phadke
 * @version 10/26/18
 * @author Period: 3
 * 
 * @author Assignment: Lab Activity 16.1 - Statistics
 * 
 * @author Sources: None
 */
public class Statistics
{
    private final static int MAX_VALUE = 100;

    private int[] statsData = new int[1000];

    private int howMany;

    // private double sum = 0;


    /**
     * Constructs this object with an array of integers for use with statistical
     * calculation
     * 
     * @param fileName
     *            name of file containing numbers for statistical evaluation
     */
    public Statistics( String fileName )
    {
        howMany = 0;
        loadFile( fileName );
    }


    /**
     * Loads text file into array data. Values are stored from positions
     * 0..howMany-1. Returns the number of data values as howMany
     * 
     * @param fileName
     *            file or string containing numbers to read
     */
    public void loadFile( String fileName )
    {
        int index = 0;
        Scanner inFile;

        try
        {
            if ( new File( fileName ).isFile() )
            {
                inFile = new Scanner( new File( fileName ) );
            }
            else
            {
                inFile = new Scanner( fileName );
            }

            while ( inFile.hasNext() )
            {
                statsData[index] = inFile.nextInt();
                index++;
            }
        }
        catch ( IOException i )
        {
            System.out.println( "Error: " + i.getMessage() );
        }
        howMany = index;
    }


    /**
     * Returns average of values in vector data.
     * 
     * @return average of this objects data collection
     */
    public double average()
    {
        double average = 0;
        double sum = 0;
        for ( int i = 0; i < howMany; i++ )
        {
            sum += statsData[i];
        }

        average = sum / howMany;

        return average;
    }


    /**
     * Finds standard deviation of values in vector data.
     * 
     * @return the standard deviation of the vector data
     */
    public double stdDev()
    {
        double sum1 = 0;
        for ( int i = 0; i < howMany; i++ )
        {
            sum1 += Math.pow( statsData[i] - average(), 2 );
        }
        double x = Math.sqrt( sum1 / ( howMany - 1 ) );
        return x;

    }


    /**
     * finds the largest integer in the array scores. This array is sized from
     * 0..MAX_VALUE, with each element storing the quantity of each number from
     * 0..MAX_VALUE.
     * 
     * @param scores
     *            integer array sized at MAX_VALUE+1 with each element storing
     *            the quantity of each number from 0..MAX_VALUE
     */
    public int findLargest( int[] scores )
    {

        int max = scores[0];
        for ( int i = 1; i < scores.length; i++ )
        {
            if ( scores[i] > max )
            {
                max = scores[i];
            }
        }
        return max;
    }


    /**
     * The array data is analyzed and transferred into a smaller array array
     * (0..MAX_VALUE). For each occurrence of n in the array data, array[n] is
     * incremented +1. findLargest is then called to find the largest quantity
     * in the array array. The mode(s) is/are returned in an array.
     * 
     * 
     * @return array of mode(s)
     */
    public int[] findMode()
    {

        int[] array = new int[MAX_VALUE + 1];
        for ( int i = 0; i < howMany; i++ )
        {
            array[statsData[i]]++;
        }
        int m = findLargest( array );
        ArrayList<Integer> list = new ArrayList<Integer>();
        for ( int j = 0; j < array.length; j++ )
        {
            if ( array[j] == m )
            {
                list.add( j );
            }
        }
        int[] fin = new int[list.size()];
        for ( int k = 0; k < list.size(); k++ )
        {
            fin[k] = list.get( k );
        }
        return fin;
    }


    public static void main( String[] args )
    {
        Statistics fileStats = new Statistics( "numbers.txt" );

        System.out.printf( "The average = %6.2f", fileStats.average() );
        System.out.println();
        System.out.printf( "Standard deviation = %6.2f", fileStats.stdDev() );
        System.out.println();

        int[] mode = fileStats.findMode();
        System.out.print( "The mode is(are) --> " );
        for ( int m : mode )
        {
            System.out.print( m + "  " );
        }
    }
}
