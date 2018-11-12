import java.util.ArrayList;


/**
 * 
 * TODO Outputs the index at which each word is at TODO Using the methods from
 * IndexEntry, inherited through extend, this class appends words to the output
 * list, as well as their respective indexes.
 *
 * @author Shree Phadke
 * @version Nov 9, 2018
 * @author Period: 3
 * @author Assignment: JMCh12_9IndexMaker
 *
 * @author Sources: None
 */
public class DocumentIndex extends ArrayList<IndexEntry>
{

    // Creates an empty DocumentIndex with the default
    // initial capacity.

    /**
     * calls default no args constructor
     */
    public DocumentIndex()
    {
        super();
    }


    // Creates an empty DocumentIndex with a given
    // initial capacity.

    /**
     * makes an empty doc with a set length (capacity)
     * 
     * @param initialCapacity
     *            of the empty document
     */
    public DocumentIndex( int initialCapacity )
    {
        super( initialCapacity );
    }


    // If word is not yet in this DocumentIndex,
    // creates a new IndexEntry for word, and inserts
    // it into this list in alphabetical order;
    // adds num to this word's IndexEntry by calling
    // its add(num) method.

    /**
     * 
     * TODO If word not apparent, it is appended to the list
     * 
     * @param word
     *            to add
     * @param num
     *            added to indexEntry
     */
    public void addWord( String word, int num )
    {
        int i = this.foundOrInserted( word );
        this.get( i ).add( num );
    }


    // For each word in str, calls addWord(word, num).

    /**
     * 
     * TODO makes a string of all the words and their respective indexes
     * 
     * @param str
     *            string of words
     * @param num
     *            index of words
     */
    public void addAllWords( String str, int num )
    {
        String[] s1 = str.split( "" );
        String output = "";
        String punc = "!@#$%^&*();:,.?";

        for ( int i = 0; i < str.length(); i++ )
        {
            if ( !punc.contains( s1[i] ) )
            {
                // System.out.println( output );
                output += s1[i];
            }
        }

        String[] spaces = output.split( " " );

        for ( String word : spaces )
        {
            if ( ( word.length() != 0 ) )
            {
                addWord( word.toUpperCase(), num );
            }
        }

    }


    // Tries to find an IndexEntry with a given word in this
    // DocumentIndex. If not found, inserts a new IndexEntry for
    // word at the appropriate place (in lexicographical order).
    // Returns the index of the found or inserted IndexEntry

    /**
     * 
     * TODO if word is in the list, find its index(es), else add the word and
     * repeat
     * 
     * @param word
     *            to find index of
     * @return index of word
     */
    private int foundOrInserted( String word )
    {

        boolean x = false;

        if ( this.size() >= 0 )
        {
            for ( IndexEntry indexEntry : this )
            {
                if ( indexEntry.getWord().equals( word ) )
                {
                    return this.indexOf( indexEntry );
                }

                else if ( indexEntry.getWord().compareTo( word ) > 0 )
                {
                    this.add( this.indexOf( indexEntry ),
                        new IndexEntry( word ) );
                    return this.indexOf( indexEntry ) - 1;
                }
            }

            this.add( size(), new IndexEntry( word ) );

            x = true;

        }
        else
        {
            this.add( 0, new IndexEntry( word ) );
        }

        if ( x )
        {
            return size() - 1;
        }
        else
        {
            return 0;
        }
    }
}
