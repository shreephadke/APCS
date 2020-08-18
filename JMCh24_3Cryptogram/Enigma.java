
/**
 * Encrypts and decrypts sentences. It is able to give hints in order
 * to decode as well.
 * 
 * @author Shree Phadke
 * @version 2/8/19
 * 
 * @author Period - 3
 * @author Assignment - JM 24.3 Lab: Cryptogram Solver
 * 
 * @author Sources - None
 */
public class Enigma
{
    private char[] lookupTable;


    /**
     * constructor
     * 
     * @param numLetters
     *            number of letters
     */
    public Enigma( int numLetters )
    {
        lookupTable = new char[numLetters];
    }


    /**
     * 
     * TODO sets capital letters at a certain index in an array
     * 
     * @param index of an array
     * @param ch letter to insert
     */
    public void setSubstitution( int index, char ch )
    {

        lookupTable[index] = Character.toUpperCase( ch );
    }


    /**
     * 
     * TODO decodes the encoded string of words/letters
     * @param text to be encoded
     * @return decoded text
     */
    public String decode( String text )
    {
        StringBuffer buffer = new StringBuffer( text.length() );

        int x = 0;
        char ch;
        String blank = "";

        for ( int i = 0; i < text.length(); i++ )
        {
            ch = text.charAt( i );

            if ( Character.isLowerCase( ch ) )
            {
                x = Character.getNumericValue( ch ) 
                                - Character.getNumericValue( 'a' );
                buffer.append( ( blank + lookupTable[x] ).toLowerCase() );
            }
            else if ( Character.isUpperCase( ch ) )
            {
                x = Character.getNumericValue( ch ) 
                                - Character.getNumericValue( 'A' );
                buffer.append( ( blank + lookupTable[x] ).toUpperCase() );
            }
            else
            {
                buffer.append( ch );
            }
        }
        return buffer.toString();
    }


    /**
     * 
     * TODO gets and give hints about the decoding
     * @param text to be decoded
     * @param lettersByFrequency frequency of letters
     * @return string with all combined frequent chars
     */
    public String getHints( String text, String lettersByFrequency )
    {
        int[] arr = countLetters( text );
        int total = 0;
        String str = "";

        for ( int i = 0; i < arr.length; i++ )
        {
            total = 0;

            for ( int j = 0; j < arr.length; j++ )
            {
                if ( arr[j] < arr[i] || arr[j] == arr[i] && j < i )
                {
                    total++;
                }
            }
            str += lettersByFrequency.charAt( total );
        }

        return str;

    }


    /**
     * 
     * TODO Counts the number of letters in the string
     * 
     * @param text
     *            given
     * @return lookup table
     */
    private int[] countLetters( String text )
    {
        int[] counts = new int[lookupTable.length];
        char ch;

        for ( int i = 0; i < text.length(); i++ )
        {
            ch = text.charAt( i );

            if ( Character.isLetter( ch ) )
            {
                counts[Character.toUpperCase( ch ) - 'A']++;
            }
        }

        return counts;
    }


    // *************************************************************
    // For test purposes only
    // not to be used in solution implementation

    /**
     * 
     * TODO constructor of lookup table
     * @return lookup table
     */
    public char[] getLookupTable()
    {
        return lookupTable;
    }


    /**
     * 
     * TODO retrieves the number of letters in the form of a lookup table.
     * @param text given 
     * @return output from countLetters method 
     */
    public int[] getCountLetters( String text )
    {
        return countLetters( text );
    }

}