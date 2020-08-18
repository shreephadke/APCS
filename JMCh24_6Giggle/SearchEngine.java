import java.util.*;


/**
 * Creates a HashMap Search Engine that gets and returns URL and number of
 * "hits", and searches for lines in a file with specific words.
 * 
 * @author Shree Phadke
 * @version 2/15/19
 * 
 * @author Period - 3
 * @author Assignment - JM24.6 - Search Engine
 * 
 * @author Sources - None
 */
public class SearchEngine
{
    // Instance variable(s)

    private String myURL; // holds the name for the "url" (file name)

    private Map<String, List<String>> myIndex; // holds the word index


    // Constructor(s)
    /**
     * constructs the hash map and sets url to myURL
     * 
     * @param url
     *            of the site
     */
    public SearchEngine( String url )
    {
        myURL = url;
        myIndex = new HashMap( 20000 );
    }


    /**
     * 
     * TODO gets and returns the URL
     * 
     * @return myURL url
     */
    public String getURL()
    {
        return myURL;

    }


    /**
     * 
     * TODO splits the line into words and for each iteration of the word, adds
     * a line to hash map
     * 
     * @param line
     *            given
     */
    public void add( String line )
    {
        Set<String> list = parseWords( line ); // set of all words in "line"

        for ( String str : list )
        {
            LinkedList<String> list2 = new LinkedList<String>();

            if ( !myIndex.containsKey( str ) )
            {
                myIndex.put( str, list2 );
            }

            myIndex.get( str ).add( line );
        }
    }


    /**
     * 
     * TODO gets and return the list of lines
     * 
     * @param word
     *            searched for
     * @return list of lines
     */
    public List<String> getHits( String word )
    {
        return myIndex.get( word );

    }


    /**
     * 
     * TODO returns a set of all words in line that have been split up by a
     * certain sequence of characters
     * 
     * @param line
     *            given
     * @return set of all words in the line
     */
    private Set<String> parseWords( String line )
    {

        String[] split = line.split( "\\W+" );
        TreeSet<String> wordsInLine = new TreeSet<String>();

        for ( String str : split )
        {
            if ( str.length() > 0 )
            {
                str = str.toLowerCase();
                wordsInLine.add( str );
            }
        }

        return wordsInLine;

    }


    // *************************************************************
    // For test purposes only
    // not to be used in solution implementation

    /**
     * 
     * TODO gets and returns myIndex
     * 
     * @return myIndex hash maps
     */
    public Map<String, List<String>> getIndex()
    {
        return myIndex;
    }
}
