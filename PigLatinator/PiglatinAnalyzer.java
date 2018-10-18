import java.util.Scanner;


/**
 * TODO Coverts english phrase/text to pig latin format leaving punc. untouched
 * 
 * @author Shree Phadke
 * @version 10/15/18
 * 
 * @author Period 3
 * @author Assignment - PigLatinator
 * 
 * @author Sources - None
 */
public class PiglatinAnalyzer
{
    private String text;

    private int start;

    private int end;


    // Constructor: saves the text string
    public PiglatinAnalyzer( String text )
    {
        this.text = text;

    }


    /**
     * Converts a string to it piglatin form according to the following rules:
     * a. If there are no vowels in englishWord, then pigLatinWord is just
     * englishWord + "ay". (There are ten vowels: 'a', 'e', 'i', 'o', and 'u',
     * and their uppercase counterparts.) b. Else, if englishWord begins with a
     * vowel, then pigLatinWord is just englishWord + "yay". c. Otherwise (if
     * englishWord has a vowel in it and yet doesn't start with a vowel), then
     * pigLatinWord is end + start + "ay", where end and start are defined as
     * follows: 1. Let start be all of englishWord up to (but not including) its
     * first vowel. 2. Let end be all of englishWord from its first vowel on. 3.
     * But, if englishWord is capitalized, then capitalize end and
     * "uncapitalize" start.
     *
     * @return piglatin version of text as a String
     */
    public String phraseToPigLatin()
    {
        String phraseToTranslate = text;
        String translation = "";


        int i = 0;
        while ( i < phraseToTranslate.length() )
        {

            if ( Character.isLetter( phraseToTranslate.charAt( i ) ) )
            {
                translation += wordToPigLatin( extractWord( i ) ) + "";
                i = end;
            }

            else
            {
                translation += phraseToTranslate.charAt( i );
                i++;
            }

        }

        /*
         * String[] split = transfer.split( " " ); for ( i = 0; i <
         * split.length; i++ ) { System.out.println( split[i] ); translation +=
         * wordToPigLatin( split[i] ) + " "; }
         */

        return translation;
    }


    /**
     * Converts an "english" word to its piglatin form
     *
     * @param englishWord
     *            a string representing an english word
     * @return piglatin form of the english word
     */
    public String wordToPigLatin( String englishWord )
    {
        String pigLatinWord = "";

        int a = englishWord.indexOf( 'a' );
        int e = englishWord.indexOf( 'e' );
        int i = englishWord.indexOf( 'i' );
        int o = englishWord.indexOf( 'o' );
        int u = englishWord.indexOf( 'u' );
        int a1 = englishWord.indexOf( 'A' );
        int e1 = englishWord.indexOf( 'E' );
        int i1 = englishWord.indexOf( 'I' );
        int o1 = englishWord.indexOf( 'O' );
        int u1 = englishWord.indexOf( 'U' );

        String start = "";
        String end = "";

        /*
         * No vowels
         */
        if ( a == -1 && e == -1 && i == -1 && o == -1 && u == -1 && a1 == -1 && 
                        e1 == -1 && i1 == -1
                            && o1 == -1 && u1 == -1 )

        {

            pigLatinWord = englishWord + "ay";

        }

        /*
         * begins with a vowel
         */
        else if ( a == 0 || e == 0 || i == 0 || o == 0 || u == 0 || a1 == 0 
                        || e1 == 0 || i1 == 0
                            || o1 == 0 || u1 == 0 )

        {

            pigLatinWord = englishWord + "yay";

        }

        /*
         * has a vowel but doesn't start with it
         */
        else
        {
            start = englishWord.substring( 0, firstVowel( englishWord ) );
            end = englishWord.substring( firstVowel( englishWord ), 
                englishWord.length() );
            pigLatinWord = end + "" + start + "ay";
            pigLatinWord = pigLatinWord.toLowerCase();

            if ( Character.isUpperCase( englishWord.charAt( 0 ) ) )
            {
                pigLatinWord = pigLatinWord.substring( 0, 1 ).toUpperCase()
                    + pigLatinWord.substring( 1 );

            }
        }

        return pigLatinWord;
    }

    // additional helper methods


    /**
     * 
     * TODO finds index of first vowel
     * 
     * @param englishWord
     * @return index of first vowel in word
     */
    public static int firstVowel( String englishWord )
    {
        char[] vowel = { 'a', 'e', 'i', 'o', 'u' };
        String lcword = englishWord.toLowerCase();
        for ( int i = 0; i < lcword.length(); i++ )
        {
            for ( int j = 0; j < vowel.length; j++ )
            {
                if ( lcword.charAt( i ) == vowel[j] )
                {
                    return i;
                }
            }
        }
        return -1;
    }


    /**
     * 
     * TODO Returns the word the given index is apart of
     * 
     * @param pos
     *            of the char in the worf
     * @return output word
     */
    public String extractWord( int pos )
    {
        start = pos; // start index for substring,initially given input
                     // index
        end = pos; // end index for substring, initially given input index
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
