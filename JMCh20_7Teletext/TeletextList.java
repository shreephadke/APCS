
// Implements the list of messages for teletext

import java.awt.Graphics;

/**
 * 
 *  TODO Rotating list of headlines that allows you to add and delete headlines.
 *  TODO saves a reference to the node in the heading, you can add by typing, 
 *  and delete with "d"
 *
 *  @author  shrphadke
 *  @version Jan 10, 2019
 *  @author  Period: 3
 *  @author  Assignment: JMCh20_7Teletext
 *
 *  @author  Sources: None
 */
public class TeletextList
{
    private ListNode2<String> heading;
    private ListNode2<String> topNode;


    /**
     * Creates a circular list of headlines. First creates a circular list with
     * one node, "Today's headlines:". Saves a reference to that node in
     * heading. Adds a node holding an empty string before heading and another
     * node holding an empty string after heading. Appends all the strings from
     * headlines to the list, after the blank line that follows heading,
     * preserving their order. Sets topNode equal to heading.
     * 
     * @param headlines
     *            Strings to add to circular list
     */
    public TeletextList( String[] headlines )
    {
        heading = new ListNode2<String>( "Today's headlines:", null, null );
        int i = 0;
        ListNode2<String> bef = new ListNode2<String>( "", null, heading );
        ListNode2<String> aft = new ListNode2<String>( "", heading, null );

        heading.setPrevious( bef );
        heading.setNext( aft );

        while ( i < headlines.length )
        {
            aft = new ListNode2<String>( headlines[i], aft, null );
            aft.getPrevious().setNext( aft );
            i++;
        }

        aft.setNext( bef );
        bef.setPrevious( aft );

        topNode = heading;

    }


    /**
     * Inserts a node with msg into the headlines list after the blank /line
     * that follows heading.
     * 
     * @param msg
     *            String to add to headlines list
     */
    public void insert( String msg )
    {
        ListNode2<String> node = heading.getNext();
        ListNode2<String> blank = node.getNext();
        ListNode2<String> header = new ListNode2<String>( msg, node, blank );

        topNode = node;
        node.setNext( header );
        node = node.getNext().getNext();
        node.setPrevious( header );

    }


    /**
     * Deletes the node that follows topNode from the headlines list, unless
     * that node happens to be heading or the node before or after heading that
     * holds a blank line.
     */
    public void delete()
    {
        ListNode2<String> node = topNode.getNext();

        if ( node.equals( heading ) || node.equals( heading.getNext() )
            || node.equals( heading.getPrevious() ) )
        {
            return;
        }

        ListNode2<String> blank = node.getNext();
        topNode = heading.getNext().getNext();
        heading.getNext().setNext( blank );
        topNode.setPrevious( blank );

    }


    /**
     * Scrolls up the headlines list, advancing topNode to the next node.
     */

    public void scrollUp()
    {
        this.topNode = topNode.getNext();

    }


    /*
     * Adds a new node with msg to the headlines list before a given node.
     * Returns a referenece to the added node.
     */
    /**
     * 
     * TODO Adds a new node with msg to the headlines list before a given node.
     * Returns a referenece to the added node.
     * @param node string node
     * @param msg message
     * @return ListNode2
     */
    private ListNode2<String> addBefore( ListNode2<String> node, String msg )
    {
        ListNode2<String> newNode = new ListNode2<String>( msg, 
                        node.getPrevious(), node );

        node.getPrevious().setNext( newNode );
        node.setPrevious( newNode );
        return newNode;
    }


    /**
     * 
     * TODO Adds a new node with msg to the headlines list after a given node.
     * Returns a referenece to the added node.
     * @param node string node
     * @param msg message
     * @return ListNode2
     */
    private ListNode2<String> addAfter( ListNode2<String> node, String msg )
    {
        return addBefore( node.getNext(), msg );

    }



    
    /**
     * 
     * TODO Removes a given node from the list.
     * @param node string node
     */
    private void remove( ListNode2<String> node )
    {
        while ( heading != ( node ) )
        {
            heading = heading.getNext();
        }

        ListNode2<String> blank = heading.getNext().getNext();
        heading.getPrevious().setNext( blank );
        blank.setPrevious( heading.getPrevious() );

    }

    
    /**
     * 
     * TODO Draws nLines headlines in g, starting with topNode at x, y and
     * incrementing y by lineHeight after each headline.
     * @param g graphics
     * @param x value
     * @param y value
     * @param lineHeight height of character
     * @param nLines number of lines
     */
    public void draw( Graphics g, int x, int y, int lineHeight, int nLines )
    {
        ListNode2<String> node = topNode;
        for ( int k = 1; k <= nLines; k++ )
        {
            g.drawString( node.getValue(), x, y );
            y += lineHeight;
            node = node.getNext();
        }
    }


    /**
     * Returns a string representation of this TeletextList.
     * 
     * @return a string representation of this TeletextList.
     */
    public String toString()
    {
        String str = getClass().getName() + "[";
        String separator = "";

        for ( ListNode2<String> node = heading; node.getNext() 
                        != heading; node = node.getNext() )
        {
            str += ( separator + node.getValue() );
            separator = ", ";
        }

        return str + "]";
    }
}
