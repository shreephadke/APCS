import java.awt.*;
import javax.swing.*;


/**
 * TODO This class creates an illusion. TODO Its purpose is to display 
 * 7 columns and 8 rows (every 3 rows have different displacements) to create 
 * this illusion.
 * 
 * @author TODO Shree Phadke
 * @version TODO 9/24/18
 * 
 *          Period - 3 Assignment - A12.6 - ParallelLines
 * 
 *          Sources - TODO None
 */
public class ParallelLines extends JPanel
{
    int displace = 0;

    
    public void paintComponent( Graphics g )
    {
        super.paintComponent( g ); // Call JPanel's paintComponent method
                                   // to paint the background

        int width = getWidth();
        int height = getHeight();

        drawIllusion( g, width, height );
    }


    /**
     * TODO Prints out rows and columns with a displacement to make an illusion
     * 
     * @param g graphics
     * @param width is the width of the rect
     * @param height is the height of the rect
     * @param size of the window
     */
    public void drawIllusion( Graphics g, int width, int height )
    {
        width = 50;
        height = 50;

        for ( int row = 0; row < 8; row++ )
        {
            if ( row % 2 == 0 )
            {
                displace = row % 4 * 10; // if row is even, make displacement
                                         // oscillate from (0 to 20)
            }
            else
            {
                displace = 10; // every odd row's displacement is 10
            }
            for ( int col = 0; col < 2*7; col++ )
            {
                if ( col % 2 == 0 )
                {
                    g.setColor( Color.BLACK ); // if column is even, set pen
                                               // color to black
                }
                else
                {
                    g.setColor( Color.WHITE );// if column is odd, set pen color
                                              // to white
                }
                g.fillRect( col * height + displace, row * width, width, height );// color
                                                                                  // the
                                                                                  // squares
            }
            g.setColor( Color.BLACK );
            g.drawLine( 0, row * width - 1, 2*7 * width, row * width - 1 ); 
            g.drawLine( 0, 8 * width - 1, 2*7 * width, 8 * width - 1 );     // lines
                                                                           // after
                                                                           // first
                                                                           // row,
                                                                           // end
                                                                           // after
                                                                           // last
                                                                           // row
        }
        

    }


    public static void main( String[] args )
    {
        JFrame w = new JFrame( "ParallelLines" );
        w.setBounds( 100, 100, 640, 480 );
        w.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        ParallelLines panel = new ParallelLines();
        panel.setBackground( Color.WHITE );
        Container c = w.getContentPane();
        c.add( panel );
        w.setResizable( true );
        w.setVisible( true );
    }
}
