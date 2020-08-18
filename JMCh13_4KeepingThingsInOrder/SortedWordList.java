/**
 * Implements a sorted list of words
 * 
 * @author Shree Phadke
 * @version 11/24/18
 * 
 * @author Period - 3
 * @author Assignment - Java Methods 13.4 Lab: Keeping Things in Order
 * 
 * @author Sources - None
 */
public class SortedWordList extends java.util.ArrayList<String>
{
    /**
     * constructor
     */
    public SortedWordList()
    {
        super();
    }


    /**
     * constructor 2
     * 
     * @param n
     *            from parent class
     */
    public SortedWordList( int n )
    {
        super( n );
    }


    /**
     * 
     * TODO If the string is in the ArrayList, return true, else false
     * 
     * @param s
     *            string to be checked
     * @return true or false
     */
    public boolean contains( String s )
    {
        return indexOf( s ) != -1; // returns true if String is within ArrayList
    }


    /**
     * 
     * TODO checks and returns the index of a certain string in ArrayList
     * 
     * @param str
     *            string to be checked
     * @return index of string in ArrayList
     */
    public int indexOf( String str )
    {
        int left = 0;
        int right = this.size() - 1;

        // binary search algorithm
        while ( left <= right )
        {
            int middle = ( left + right ) / 2;

            int val = str.compareToIgnoreCase( this.get( middle ) );

            if ( val > 0 ) // less than
            {
                left = middle + 1;
            }

            else if ( val < 0 ) // greater than
            {
                right = middle - 1;
            }

            else // equal to
            {
                return middle;
            }
        }
        return -1;
    }


    /**
     * replaces the word at index i with the new String
     * 
     * @param i
     *            index
     * @param word
     *            that will replace String at index i
     * @return resulted string
     */
    public String set( int i, String word )
    {
        String newStr;
        if ( i == 0 && word.compareTo( this.get( i + 1 ) ) < 0 )
        {
            newStr = super.set( i, word );
            // System.out.println( newStr );

        }

        else if ( word.compareTo( this.get( i - 1 ) ) > 0
            && word.compareTo( this.get( i + 1 ) ) < 0 )
        {
            newStr = super.set( i, word );
            // System.out.println( newStr );

        }
        else
        {
            throw new IllegalArgumentException( "word =" + word + " i =" + i );
        }
        return newStr;
    }


    /**
     * interposes the a new word in place of given index and shifts everything
     * that was originally at that index and to the right of it one space right
     * 
     * @param i
     *            index
     * @param word
     *            String to be placed at index i
     */
    public void add( int i, String word )
    {

        if ( i == 0 && word.compareTo( this.get( i + 1 ) ) < 0
            || ( this.size() == i && word.compareTo( this.get( i - 1 ) ) > 0 )
            || ( this.size() > 0 && word.compareTo( this.get( i - 1 ) ) > 0
                && word.compareTo( this.get( i + 1 ) ) < 0 ) )
        {
            super.add( i, word );
        }

        else
        {
            throw new IllegalArgumentException( "word =" + word + " i =" + i );
        }

    }


    /**
     * checks if word can be added
     * 
     * @param word
     *            to be added
     * @return true or false
     */
    public boolean add( String word )
    {

        if ( this.contains( word ) )
        {
            return false;

        }

        int left = 0;
        int right = this.size() - 1;

        while ( left <= right )
        {

            int middle = ( left + right ) / 2;

            int val = word.compareTo( this.get( middle ) );
            if ( val > 0 )
            {
                left = middle + 1;

            }
            else if ( val < 0 )
            {
                right = middle - 1;

            }
        }

        super.add( right + 1, word );
        return true;

    }


    /**
     * 
     * TODO merges the array - for each string element in the array, call add to
     * the array
     * 
     * @param array
     *            that the strings are added to
     */
    public void merge( SortedWordList array )
    {
        for ( String str : array )
        {
            add( str );
        }
    }

}
