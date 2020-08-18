import java.util.Stack;

/**
 * 
 * TODO Emulates a browser with the back, forward, and home buttons. TODO The
 * program keeps track of the number of hyperlinks clicked, and accordingly
 * allows you to select the back and forward buttons.
 *
 * @author shrphadke
 * @version Jan 20, 2019
 * @author Period: 3
 * @author Assignment: JMCh21_3Browsing
 *
 * @author Sources: None
 */
public class BrowserModel
{
    private BrowserView view;

    private Stack<Integer> backStk;
    private Stack<Integer> forwardStk;

    private int topLine;


    // TODO complete constructor

    /**
     * This is the constructor for the BrowserModel class.
     * 
     * @param view
     *            viewer
     */
    public BrowserModel( BrowserView view )
    {
        Integer position = new Integer( topLine );

        this.view = view;
        this.view.update( position );
        backStk = new Stack<Integer>();
        forwardStk = new Stack<Integer>();

    }

    /**
     * 
     * TODO returns if the user can use the back button or not by checking if
     * the back stack is empty or not
     * 
     * @return x true or false
     */
    public boolean hasBack()
    {

        boolean x = true;

        if ( backStk.isEmpty() )
        {
            x = false;
        }

        return x;

    }

    /**
     * 
     * TODO When you press a link, it allows you to go back to your starting
     * point.
     */
    public void back()
    {

        forwardStk.push( topLine ); // adds to the forward stack allowing you
                                     // to go forward upon pressing the back key

        if ( hasBack() )
        {
            topLine = backStk.pop(); // removes one from the back stack (lowers
                                     // the num of times you can press back)
        }

        view.update( topLine );

    }


    /**
     * 
     * TODO returns if the user can use the forward button or not by checking if
     * the forward stack is empty or not
     * 
     * @return x true or false
     */
    public boolean hasForward()
    {
        boolean x = true;

        if ( forwardStk.isEmpty() )
        {
            x = false;
        }

        return x;
    }
    

    /**
     * 
     * TODO When you go back, it allows you to go back to the link you had
     * clicked on.
     */
    public void forward()
    {

        Integer position = new Integer( topLine );

        backStk.push( position ); // adds to the back stack allowing you
                                  // to go back upon pressing the forward key

        if ( hasForward() )
        {
            position = forwardStk.pop(); // removes one from the frwd stack
                                       // (lowers # of times you can press frwd)
        }

        view.update( position );
    }


    /**
     * 
     * TODO The neutral position when you cannot go back or forward.
     */
    public void home()
    {
        Integer position = new Integer( topLine );

        position = 0; // you cannot go back or forward when at 0

        while ( hasBack() )
        {
            backStk.pop(); // removes all back logs
        }

        while ( hasForward() )
        {
            forwardStk.pop(); // removes all forward logs
        }

        view.update( position );
    }


    /**
     * 
     * TODO when a hyperlink is clicked on, another page is added to the back
     * stack. So the more you click the hyperlinks, the more back pages you will
     * have.
     * 
     * @param n
     *            -th line
     */

    public void followLink( int n )
    {
        backStk.push( topLine );
        
        topLine = n;
        view.update( topLine );
    }


    // The following are for test purposes only
    
    /**
     * 
     * TODO returns the number of things in the back stack
     * @return back stack
     */
    public Stack<Integer> getBackStk()
    {
        return backStk;
    }


    /**
     * 
     * TODO returns the number of things in the forward stack
     * @return forward stack
     */
    public Stack<Integer> getForwardStk()
    {
        return forwardStk;
    }


    /**
     * 
     * TODO returns the topline of the stack
     * @return topLine of stack
     */
    public int getTopLine()
    {
        return topLine;
    }
}
