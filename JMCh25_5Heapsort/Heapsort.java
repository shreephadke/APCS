/**
 * TODO Sorts the array in ascending order using MergeSort algorithm, and uses
 * the reheapdown method by which the new root value keeps swapping places with
 * its smaller child until it falls into place.
 * 
 * @author Shree Phadke
 * @version 3/11/19
 * 
 * @author Period - 3
 * @author Assignment - Heapsort
 * 
 * @author Sources - None
 */
public class Heapsort
{
    // Sorts a[0], ..., a[size-1] in ascending order
    // using the Mergesort algorithm
    public static void sort( double[] a )
    {
        int n = a.length;
        for ( int i = n / 2; i >= 1; i-- )
            reheapDown( a, i, n );

        while ( n > 1 )
        {
            double temp = a[0];
            a[0] = a[n - 1];
            a[n - 1] = temp;
            n--;
            reheapDown( a, 1, n );
        }

    }


    // Should be private - made public for testing
    public static void reheapDown( double[] a, int i, int n )
    {
        int index = i - 1;
        while ( 2 * index + 1 < n )
        {
            if ( 2 * index + 2 == n )
            {
                if ( a[index] > a[2 * index + 1] )
                {
                    return;
                }
                
                else
                {
                    double temp = a[index];
                    a[index] = a[2 * index + 1];
                    a[2 * index + 1] = temp;
                    return;
                }
            }
            
            if ( a[index] >= a[2 * index + 1] && a[index] >= a[2 * index + 2] )
            {
                return;
            }
            
            if ( a[2 * index + 2] > a[2 * index + 1] )
            {
                double temp = a[index];
                a[index] = a[2 * index + 2];
                a[2 * index + 2] = temp;
                index = 2 * ( index + 2 );
            }
            
            else
            {
                double temp = a[index];
                a[index] = a[2 * index + 1];
                a[2 * index + 1] = temp;
                index = 2 * index + 1;
            }
        }

    }
}
