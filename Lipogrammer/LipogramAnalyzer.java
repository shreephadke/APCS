/**
 * 
 * @author Shree Phadke
 * @version 10/10/18
 * 
 * @author Period 3
 * @author Assignment - JMCh10 Lipogrammer
 * 
 * @author Sources - None
 */
public class LipogramAnalyzer
{
    private String text;


    /**
     * Constructor: Saves the text string
     * 
     * @param text
     *            String to analyze
     */
    public LipogramAnalyzer( String text )
    {

        this.text = text;

    }


    /**
     * Returns the text string with all characters equal to letter replaced with
     * '#'.
     * 
     * @param letter
     *            character to replace
     * @return text string with all characters equal to letter replaced with '#'
     */
    public String mark( char letter )
    {
        String string = "";
        int b = 0;
        while ( b < text.length() )
        {
            if ( text.charAt( b ) == letter )
            /**
             * iterates and checks if each character in text string has the
             * special letter, if so, it replaces that character with '#'.
             */

            {

                string += '#';


            }
            else
            {
                /**
                 * otherwise, it is ignored
                 *
                 */
                string += text.charAt( b ) + "";
            }

            b++;

        }
        return string;

    }


    /**
     * Returns b String that concatenates all "offending" words from text that
     * contain letter; the words are separated by '\n' characters; the returned
     * string does not contain duplicate words: each word occurs only once;
     * there are no punctuation or whitespace characters in the returned string.
     * 
     * @param letter
     *            character to find in text
     * @return String containing all words with letter
     */
    public String allWordsWith( char letter )
    {
        String result = "";
        result += "\n";
        for ( int i = 0; i < text.length(); i++ )
        {

            /*
             * if the character at index i is the special letter, and if the
             * letter is contained in the respective word from extract, result
             * will add the word to its reserve, so at the end it will return
             * the entire String with the words that have the letter
             */
            if ( text.charAt( i ) == letter )
            {
                String wordWithLetter = this.extractWord( i ) + "";
                if ( !result.contains( "\n" + wordWithLetter + "\n" ) )
                {
                    result += wordWithLetter + "\n";
                }
            }
        }
        result = result.substring( 1 ); // does not include return
        return result;
    }
    
    



    // made public for test purposes

    /**
     * 
     * TODO given the pos of the character in the string, this returns the word
     * that character is apart of
     * 
     * @param pos
     *            index of a certain character in the String
     * @return output the word that the character at pos is apart of
     */
    public String extractWord( int pos )
    {
        int start = pos; // start index for substring,initially given input
                         // index
        int end = pos; // end index for substring, initially given input index
        String output = "";

        /**
         * if the start index is not out of bounds and if the character is not
         * punctuation or a space, then keep decreasing the start index by 1
         * every iteration
         */
        while ( start >= 0 && Character.isLetter( text.charAt( start ) ) )
        {

            start--;

        }

        /*
         * if the end index is not out of bounds and if the character is not
         * punctuation or a space, then keep increasing the end index by 1 every
         * iteration
         */
        while ( end < text.length() 
                        && Character.isLetter( text.charAt( end ) ) )
        {
            end++;
        }
        start++;

        output = text.substring( start, end );
        return output;

    }
}
