import java.util.Arrays;
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

    private double sum = 0;

    private double average = 0;


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
            sum = ( statsData[i] - average ) * ( statsData[i] - average );
            sum1 += sum;
        }

        double x = Math.sqrt( ( sum1 / ( statsData.length - 1 ) ) );

        return x; // TODO Fix this
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

        int max = statsData[0];
        for ( int i = 1; i < statsData.length; i++ )
        {
            if ( statsData[i] > max )
            {
                max = statsData[i];
            }
        }
        return max;
    }


    /**
     * The array data is analyzed and transferred into a smaller array smallList
     * (0..MAX_VALUE). For each occurrence of n in the array data, smallList[n]
     * is incremented +1. findLargest is then called to find the largest
     * quantity in the array smallList. The mode(s) is/are returned in an array.
     * 
     * @return array of mode(s)
     */
    public int[] findMode()
    {
        statsData = sort();
        int count = 0;
        int temp = 1;

        int mode = 0;

        // finds the mode by comparing two integers one at a time in sorted
        // array
        for ( int i = 1; i < statsData.length; i++ )
            for ( int j = 0; j < statsData.length - 1; j++ )
            {
                if ( statsData[j] != statsData[j + 1] )
                {
                    count = 0;
                }
                if ( statsData[j] == statsData[j + 1] )
                {
                    count++;
                }

                if ( count > temp )
                {
                    temp = count;

                    mode = statsData[j];
                }
            }

        // creates a new array with length of the temporary count variable
        int[] modear = new int[temp + 1];

        // fills the entire list of length temp with the mode
        Arrays.fill( modear, mode );

        return modear;

    }


    // helper method
    /**
     * 
     * TODO Sorts the array in increasing order.
     * 
     * @return sorted array
     */
    public int[] sort()
    {

        for ( int i = 0; i < statsData.length; i++ )
        {
            for ( int j = 0; j < statsData.length; j++ )
            {
                if ( statsData[i] < statsData[j] )
                {
                    int temp = statsData[i];
                    statsData[i] = statsData[j];
                    statsData[j] = temp;
                }
            }
        }

        return statsData;
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
