import java.awt.geom.*;
import gpdraw.*;
import java.util.ArrayList; // for ArrayList


/**
 * This program draws and calculates the perimeter and area for several shapes.
 *
 * @author Shree Phadke
 * @version 10/31/18
 *
 * @author Period - 3
 * @author Assignment - None
 * 
 * @author Sources - None
 */
public class IrregularPolygon
{
    private DrawingTool pen; // = new DrawingTool( new SketchPad( 300, 300, 0 )
                             // );

    private ArrayList<Point2D.Double> myPolygon;


    // constructors

    /**
     * initializes arrayList
     */
    public IrregularPolygon()
    {
        myPolygon = new ArrayList<Point2D.Double>();

    }


    // public methods

    /**
     * 
     * TODO adds the points to ArrayList
     * 
     * @param aPoint
     *            point added
     */
    public void add( Point2D.Double aPoint )
    {

        myPolygon.add( aPoint );

    }


    /**
     * 
     * TODO calculates the perimeter of shape
     * 
     * @return perimeter of shape
     */
    public double perimeter()
    {

        double p = 0.0;
        
        if ( myPolygon.size() == 0 )
        {
            return 0;
        }

        for ( int i = 0; i < myPolygon.size() - 1; i++ )
        {
            p += myPolygon.get( i + 1 ).distance( myPolygon.get( i ) );
        }

        p += myPolygon.get( myPolygon.size() - 1 ).
                        distance( myPolygon.get( 0 ) );

        return p;

    }


    /**
     * 
     * TODO calculates area of shape
     * 
     * @return area of shape
     */
    public double area()
    {

        double x1 = 0.0;
        double x2 = 0.0;
        double y1 = 0.0;
        double y2 = 0.0;
        double prod = 0.0;
        
        
        for ( int i = 0; i < myPolygon.size() - 1; i++ )
        {
            x1 = ( myPolygon.get( i ).getX() );
            x2 = ( myPolygon.get( i + 1 ).getX() );

            y1 = ( myPolygon.get( i ).getY() );
            y2 = ( myPolygon.get( i + 1 ).getY() );

            prod += ( ( x1 * y2 ) - ( x2 * y1 ) );

            if ( i == ( myPolygon.size() - 2 ) )
            {
                x1 = ( myPolygon.get( 0 ).getX() );
                x2 = ( myPolygon.get( myPolygon.size() - 1 ).getX() );

                y1 = ( myPolygon.get( 0 ).getY() );
                y2 = ( myPolygon.get( myPolygon.size() - 1 ).getY() );
                prod += ( ( x2 * y1 ) - ( x1 * y2 ) );
            }
        }
        double area = prod / 2;
        return Math.abs( area );

    }


    /**
     * 
     * TODO draws the shape using the drawing tool
     */
    public void draw()
    {

        for ( int i = 0; i < myPolygon.size(); i++ )
        {
            Point2D point = myPolygon.get( i );

            if ( i == 0 )
            {
                pen.up();
                pen.move( point.getX(), point.getY() );
                pen.down();
            }
            pen.move( point.getX(), point.getY() );

            if ( i == myPolygon.size() - 1 )
            {
                pen.move( myPolygon.get( 0 ).getX(), 
                    myPolygon.get( 0 ).getY() );
            }
        }

    }
}