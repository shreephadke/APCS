import java.util.ArrayList;


/**
 * 
 * TODO Makes IndexEntry of each word TODO gets and returns the words, and adds
 * the numbers to the IndexEntry
 *
 * @author Shree Phadke
 * @version Nov 9, 2018
 * @author Period: 3
 * @author Assignment: JMCh12_9IndexMaker
 *
 * @author Sources: None
 */
public class IndexEntry
{
    private String word;

    private ArrayList<Integer> numsList;


    // Constructs an IndexEntry for a given word
    // (converted to upper case); sets numsList
    // to an empty ArrayList.

    /**
     * 
     * @param word
     *            being added
     */
    public IndexEntry( String word )
    {
        this.word = word.toUpperCase();
        numsList = new ArrayList<Integer>();
    }


    // Returns the word of this IndexEntry object.

    /**
     * 
     * TODO gets and returns word
     * 
     * @return this.word word
     */
    public String getWord()
    {
        return this.word;
    }


    // If num is not already in the list, adds num
    // at the end of this IndexEntry's list
    // of numbers.

    /**
     * 
     * TODO if list does not contain int, add integer to indexEntry
     * 
     * @param num
     *            index of word appended
     */
    public void add( int num )
    {
        Integer integer = new Integer( num );

        if ( !numsList.contains( integer ) )
        {
            numsList.add( integer );
        }
    }


    // Converts this IndexEntry into a string in the
    // following format: the word followed by a space, followed by
    // numbers separated by a comma and a space.

    /**
     * formats the output for .txt file
     * 
     * @return str string
     */
    public String toString()
    {
        String str = word;

        for ( Integer i : numsList )
        {
            str += ( " " + i + "," );
        }
        str = str.substring( 0, str.length() - 1 );

        return str;
    }
}