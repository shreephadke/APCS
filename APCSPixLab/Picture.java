import java.awt.*;
import java.awt.font.*;
import java.awt.geom.*;
import java.awt.image.BufferedImage;
import java.text.*;
import java.util.*;
import java.util.List; // resolves problem with java.awt.List and java.util.List


/**
 * A class that represents a picture. This class inherits from SimplePicture and
 * allows the student to add functionality to the Picture class.
 *
 * @author Shree Phadke
 * @version 4/10/19
 * @author Period: 3
 * @author Assignment: APCSPixLab - IntArrayWorker
 *
 * @author Sources: None
 * 
 * @author Barbara Ericson ericson@cc.gatech.edu
 */
public class Picture extends SimplePicture
{
    // /////////////////// constructors //////////////////////////////////

    /**
     * Constructor that takes no arguments
     */
    public Picture()
    {
        /*
         * not needed but use it to show students the implicit call to super()
         * child constructors always call a parent constructor
         */
        super();
    }


    /**
     * Constructor that takes a file name and creates the picture
     * 
     * @param fileName
     *            the name of the file to create the picture from
     */
    public Picture( String fileName )
    {
        // let the parent class handle this fileName
        super( fileName );
    }


    /**
     * Constructor that takes the width and height
     * 
     * @param height
     *            the height of the desired picture
     * @param width
     *            the width of the desired picture
     */
    public Picture( int height, int width )
    {
        // let the parent class handle this width and height
        super( width, height );
    }


    /**
     * Constructor that takes a picture and creates a copy of that picture
     * 
     * @param copyPicture
     *            the picture to copy
     */
    public Picture( Picture copyPicture )
    {
        // let the parent class do the copy
        super( copyPicture );
    }


    /**
     * Constructor that takes a buffered image
     * 
     * @param image
     *            the buffered image to use
     */
    public Picture( BufferedImage image )
    {
        super( image );
    }


    // //////////////////// methods ///////////////////////////////////////

    /**
     * Method to return a string with information about this picture.
     * 
     * @return a string with information about the picture such as fileName,
     *         height and width.
     */
    public String toString()
    {
        String output = "Picture, filename " + getFileName() + " height " + getHeight() + " width "
            + getWidth();
        return output;

    }


    /**
     * Method to set the blue to 0
     */
    public void zeroBlue()
    {
        Pixel[][] pixels = this.getPixels2D();
        for ( Pixel[] rowArray : pixels )
        {
            for ( Pixel pixelObj : rowArray )
            {
                pixelObj.setBlue( 0 );
            }
        }
    }


    /**
     * Method that keeps only the blue color - sets the red and green to zero
     */
    public void keepOnlyBlue()
    {
        Pixel[][] pixels = this.getPixels2D();
        for ( Pixel[] rowArray : pixels )
        {
            for ( Pixel pixelObj : rowArray )
            {
                pixelObj.setRed( 0 );
                pixelObj.setGreen( 0 );
            }
        }

    }


    /**
     * Method that keeps only the red color
     */
    public void keepOnlyRed()
    {
        Pixel[][] pixels = this.getPixels2D();
        for ( Pixel[] rowArray : pixels )
        {
            for ( Pixel pixelObj : rowArray )
            {
                pixelObj.setBlue( 0 );
                pixelObj.setGreen( 0 );
            }
        }

    }


    /**
     * Method that keeps only the green color
     */
    public void keepOnlyGreen()
    {
        Pixel[][] pixels = this.getPixels2D();
        for ( Pixel[] rowArray : pixels )
        {
            for ( Pixel pixelObj : rowArray )
            {
                pixelObj.setRed( 0 );
                pixelObj.setBlue( 0 );
            }
        }

    }


    /**
     * Method that negates the colors in the picture
     */
    public void negate()
    {
        Pixel[][] pixels = this.getPixels2D();
        for ( Pixel[] rowArray : pixels )
        {
            for ( Pixel pixelObj : rowArray )
            {
                pixelObj.setRed( 255 - pixelObj.getRed() );
                pixelObj.setBlue( 255 - pixelObj.getBlue() );
                pixelObj.setGreen( 255 - pixelObj.getGreen() );

            }
        }

    }


    /**
     * Method that makes the picture all shades of gray
     */
    public void grayscale()
    {
        Pixel[][] pixels = this.getPixels2D();
        for ( Pixel[] rowArray : pixels )
        {
            for ( Pixel pixelObj : rowArray )
            {

                int gray = (int)( pixelObj.getRed() + pixelObj.getGreen() + pixelObj.getGreen() )
                    / 3;
                pixelObj.setRed( gray );
                pixelObj.setBlue( gray );
                pixelObj.setGreen( gray );

            }
        }

    }


    /**
     * Method to fix pictures taken underwater
     */
    public void fixUnderwater()
    {
        Pixel[][] pixels = this.getPixels2D();
        // The nested enhanced for loops commented out here are equivalent to
        // the traditional nested for loops from the teacher guide
        // for ( Pixel[] rowArray : pixels )
        // {
        // for ( Pixel pixel : rowArray )
        // {
        // pixel.setRed( pixel.getRed() * 3 );
        // }
        // }
        // Code from the teacher guide that is equivalent to the nested enhanced
        // for loops above
        Pixel pixel = null;
        for ( int row = 0; row < pixels.length; row++ )
        {
            for ( int col = 0; col < pixels[0].length; col++ )
            {
                pixel = pixels[row][col];
                pixel.setRed( pixel.getRed() * 3 );
            }
        }
    }


    /**
     * Method that mirrors the picture around a vertical mirror in the center of
     * the picture from left to right
     */
    public void mirrorVertical()
    {
        Pixel[][] pixels = this.getPixels2D();
        Pixel leftPixel = null;
        Pixel rightPixel = null;
        int width = pixels[0].length;
        for ( int row = 0; row < pixels.length; row++ )
        {
            for ( int col = 0; col < width / 2; col++ )
            {
                leftPixel = pixels[row][col];
                rightPixel = pixels[row][width - 1 - col];
                rightPixel.setColor( leftPixel.getColor() );
            }
        }
    }


    /**
     * Method that mirrors the picture around a vertical mirror in the center of
     * the picture from right to left
     */
    public void mirrorVerticalRightToLeft()
    {
        Pixel[][] pixels = this.getPixels2D();
        Pixel leftPixel = null;
        Pixel rightPixel = null;
        int width = pixels[0].length;
        for ( int row = 0; row < pixels.length; row++ )
        {
            for ( int col = 0; col < width / 2; col++ )
            {
                leftPixel = pixels[row][col];
                rightPixel = pixels[row][width - 1 - col];
                leftPixel.setColor( rightPixel.getColor() );
            }
        }

    }


    /**
     * Method that mirrors the picture around a horizontal mirror in the center
     * of the picture from top to bottom
     */
    public void mirrorHorizontal()
    {

        Pixel[][] pixels = this.getPixels2D();
        Pixel top = null;
        Pixel bottom = null;
        int width = pixels[0].length;
        int height = pixels.length;
        for ( int row = 0; row < height; row++ )
        {
            for ( int col = 0; col < width; col++ )
            {
                top = pixels[row][col];
                bottom = pixels[height - 1 - row][col];
                bottom.setColor( top.getColor() );
            }
        }

    }


    /**
     * Method that mirrors the picture around a horizontal mirror in the center
     * of the picture from bottom to top
     */
    public void mirrorHorizontalBotToTop()
    {
        Pixel[][] pixels = this.getPixels2D();
        Pixel top = null;
        Pixel bottom = null;
        int width = pixels[0].length;
        for ( int row = 0; row < pixels.length; row++ )
        {
            for ( int col = 0; col < width / 2; col++ )
            {
                top = pixels[row][col];
                bottom = pixels[row][width - 1 - col];
                top.setColor( bottom.getColor() );
            }
        }

    }


    /**
     * Mirror around a mirror positioned on the diagonal line from bottom left
     * to top right
     */
    public void mirrorDiagonal()
    {
        Pixel[][] pixels = this.getPixels2D();
        Pixel bLeft = null;
        Pixel tRight = null;
        int width = pixels[0].length;
        int height = pixels.length;
        int big = Math.max( height, width );
        for ( int row = 1; row < big; row++ )
        {
            for ( int col = 0; col < row; col++ )
            {
                tRight = pixels[row][col];
                bLeft = pixels[col][row];
                bLeft.setColor( tRight.getColor() );
            }
        }

    }


    /**
     * Mirror just part of a picture of a temple
     */
    public void mirrorTemple()
    {
        int mirrorPoint = 276;
        Pixel leftPixel = null;
        Pixel rightPixel = null;
        int count = 0;
        Pixel[][] pixels = this.getPixels2D();

        // loop through the rows
        for ( int row = 27; row < 97; row++ )
        {
            // loop from 13 to just before the mirror point
            for ( int col = 13; col < mirrorPoint; col++ )
            {

                leftPixel = pixels[row][col];
                rightPixel = pixels[row][mirrorPoint - col + mirrorPoint];
                rightPixel.setColor( leftPixel.getColor() );
            }
        }
    }


    /** Mirror just part of a picture of a snowman */
    public void mirrorArms()
    {
        Pixel topPixel = null;
        Pixel botPixel = null;
        Pixel[][] pixels = this.getPixels2D();

        // loop through the rows
        for ( int row = 155; row < 191; row++ )
        {
            // loop through the columns
            for ( int col = 98; col < 169; col++ )
            {
                topPixel = pixels[row][col];
                botPixel = pixels[191 - row + 191][col];
                botPixel.setColor( topPixel.getColor() );
            }
        }

        // loop through the rows
        for ( int row = 155; row < 191; row++ )
        {
            // loop through the columns
            for ( int col = 238; col < 296; col++ )
            {
                topPixel = pixels[row][col];
                botPixel = pixels[191 - row + 191][col];
                botPixel.setColor( topPixel.getColor() );
            }
        }
    }


    /** Mirror just the gull */
    public void mirrorGull()
    {
        int mirrorPoint = 350;
        Pixel leftPixel = null;
        Pixel rightPixel = null;
        Pixel[][] pixels = this.getPixels2D();

        // loop through the rows
        for ( int row = 225; row < 332; row++ )
        {
            // loop from 13 to just before the mirror point
            for ( int col = 219; col < mirrorPoint; col++ )
            {
                leftPixel = pixels[row][col];
                rightPixel = pixels[row][mirrorPoint - col + mirrorPoint];
                rightPixel.setColor( leftPixel.getColor() );
            }
        }
    }


    /**
     * copy from the passed fromPic to the specified startRow and startCol in
     * the current picture
     * 
     * @param fromPic
     *            the picture to copy from
     * @param startRow
     *            the start row to copy to
     * @param startCol
     *            the start col to copy to
     */
    public void copy( Picture fromPic, int startRow, int startCol )
    {
        Pixel fromPixel = null;
        Pixel toPixel = null;
        Pixel[][] toPixels = this.getPixels2D();
        Pixel[][] fromPixels = fromPic.getPixels2D();
        for ( int fromRow = 0, toRow = startRow; fromRow < fromPixels.length
            && toRow < toPixels.length; fromRow++, toRow++ )
        {
            for ( int fromCol = 0, toCol = startCol; fromCol < fromPixels[0].length
                && toCol < toPixels[0].length; fromCol++, toCol++ )
            {
                fromPixel = fromPixels[fromRow][fromCol];
                toPixel = toPixels[toRow][toCol];
                toPixel.setColor( fromPixel.getColor() );
            }
        }
    }


    /**
     * Method to create a collage of several pictures
     */
    public void createCollage()
    {
        Picture flower1 = new Picture( "flower1.jpg" );
        Picture flower2 = new Picture( "flower2.jpg" );
        this.copy( flower1, 0, 0 );
        this.copy( flower2, 100, 0 );
        this.copy( flower1, 200, 0 );
        Picture flowerNoBlue = new Picture( flower2 );
        flowerNoBlue.zeroBlue();
        this.copy( flowerNoBlue, 300, 0 );
        this.copy( flower1, 400, 0 );
        this.copy( flower2, 500, 0 );
        this.mirrorVertical();
        this.write( "collage.jpg" );
    }


    /**
     * copy from the passed fromPic to the specified startRow and startCol in
     * the current picture
     * 
     * @param fromPic
     *            the picture to copy from
     * @param fromStartRow
     *            the row to start coping from in the from picture
     * @param fromStartCol
     *            the column to start copying from in the from picture
     * @param fromEndRow
     *            the row to stop before in the from picture
     * @param fromEndCol
     *            the column to stop before in the from picture
     * @param toStartRow
     *            the row to start copying to
     * @param toStartCol
     *            the column to start copying to
     */
    public void copy(
        Picture fromPic,
        int fromStartRow,
        int fromStartCol,
        int fromEndRow,
        int fromEndCol,
        int toStartRow,
        int toStartCol )
    {
        Pixel fromPixel = null;
        Pixel toPixel = null;
        Pixel[][] toPixels = this.getPixels2D();
        Pixel[][] fromPixels = fromPic.getPixels2D();
        for ( int fromRow = fromStartRow, toRow = toStartRow; fromRow <= fromEndRow
            && toRow < toPixels.length; fromRow++, toRow++ )
        {
            for ( int fromCol = fromStartCol, toCol = toStartCol; fromCol <= fromEndCol
                && toCol < toPixels[0].length; fromCol++, toCol++ )
            {
                fromPixel = fromPixels[fromRow][fromCol];
                toPixel = toPixels[toRow][toCol];
                toPixel.setColor( fromPixel.getColor() );
            }
        }
    }


    /**
     * Method to show large changes in color
     * 
     * @param edgeDist
     *            the distance for finding edges
     */
    public void edgeDetection( int edgeDist )
    {
        Pixel leftPixel = null;
        Pixel rightPixel = null;
        Pixel[][] pixels = this.getPixels2D();
        Color rightColor = null;
        for ( int row = 0; row < pixels.length; row++ )
        {
            for ( int col = 0; col < pixels[0].length - 1; col++ )
            {
                leftPixel = pixels[row][col];
                rightPixel = pixels[row][col + 1];
                rightColor = rightPixel.getColor();
                if ( leftPixel.colorDistance( rightColor ) > edgeDist )
                {
                    leftPixel.setColor( Color.BLACK );
                }
                else
                {
                    leftPixel.setColor( Color.WHITE );
                }
            }
        }
    }


    /**
     * Method to show large changes in color
     * 
     * @param edgeDist
     *            the distance for finding edges
     */
    public void edgeDetection2( int edgeDist )
    {
        Picture copy = new Picture( this );
        Pixel leftPixel = null;
        Pixel rightPixel = null;
        Pixel[][] pixels = this.getPixels2D();
        Pixel[][] arr = copy.getPixels2D();
        Color rightColor = null;
        Color bottomColor = null;
        Pixel top = null;
        Pixel bottom = null;

        // Compares the color at the current pixel with the pixel in the
        // next column to the right. If the colors differ by more than
        // some specified amount, this indicates that an edge has been
        // detected and the current pixel color is set to black.
        // Otherwise, the current pixel is not part of an edge and its
        // color is set to white.
        for ( int row = 0; row < pixels.length; row++ )
        {
            for ( int col = 0; col < pixels[0].length - 1; col++ )
            {
                leftPixel = pixels[row][col];
                rightPixel = pixels[row][col + 1];
                rightColor = rightPixel.getColor();
                if ( leftPixel.colorDistance( rightColor ) > edgeDist )
                {
                    leftPixel.setColor( Color.BLACK );
                }
                else
                {
                    leftPixel.setColor( Color.WHITE );
                }
            }
        }

        // Compares the current pixel with the one below and sets the
        // current pixel color to black as well when the color distance
        // is greater than the specified edge distance.

        int height = arr.length;
        int width = arr[0].length;
        for ( int row2 = 0; row2 < height - 1; row2++ )
        {
            for ( int col2 = 0; col2 < width; col2++ )
            {
                top = arr[row2][col2];
                bottom = arr[row2 + 1][col2];
                bottomColor = bottom.getColor();
                if ( top.colorDistance( bottomColor ) > edgeDist )
                {
                    pixels[row2][col2].setColor( Color.BLACK );
                }
            }
        }

    }


    /**
     * Method to replace the blue background with the pixels in the newBack
     * picture
     * 
     * @param newBack
     *            the picture to copy from
     */
    public void chromakey( Picture newBack )
    {
        Pixel fromPixel = null;
        Pixel toPixel = null;
        Pixel[][] toPixels = this.getPixels2D();
        Pixel[][] fromPixels = newBack.getPixels2D();
        for ( int row = 0; row < this.getHeight(); row++ )
        {
            for ( int col = 0; col < this.getWidth(); col++ )
            {
                toPixel = toPixels[row][col];
                if ( toPixel.getBlue() > toPixel.getRed() )
                {
                    fromPixel = fromPixels[row][col];
                    toPixel.setColor( fromPixel.getColor() );
                }
            }
        }
    }


    /**
     * Hide a black and white message in the current picture by changing the red
     * to even and then setting it to odd if the message pixel is black
     * 
     * @param messagePict
     *            the picture with a message
     */
    public void encode( Picture messagePict )
    {

        Pixel[][] messagePixels = messagePict.getPixels2D();
        Pixel[][] currPixels = this.getPixels2D();
        Pixel currPixel = null;
        Pixel messagePixel = null;
        int count = 0;
        for ( int row = 0; row < this.getHeight(); row++ )
        {
            for ( int col = 0; col < this.getWidth(); col++ )
            {
                // if the current pixel red is odd make it even
                currPixel = currPixels[row][col];
                if ( currPixel.getRed() % 2 == 1 )
                    currPixel.setRed( currPixel.getRed() - 1 );
                messagePixel = messagePixels[row][col];
                if ( messagePixel.colorDistance( Color.BLACK ) < 50 )
                {
                    currPixel.setRed( currPixel.getRed() + 1 );
                    count++;
                }
            }
        }
        System.out.println( count );
    }


    /**
     * Method to decode a message hidden in the red value of the current picture
     * 
     * @return the picture with the hidden message
     */
    public Picture decode()
    {
        Pixel[][] pixels = this.getPixels2D();
        int height = this.getHeight();
        int width = this.getWidth();
        Pixel currPixel = null;
        Pixel messagePixel = null;
        Picture messagePicture = new Picture( height, width );
        Pixel[][] messagePixels = messagePicture.getPixels2D();
        int count = 0;
        for ( int row = 0; row < this.getHeight(); row++ )
        {
            for ( int col = 0; col < this.getWidth(); col++ )
            {
                currPixel = pixels[row][col];
                messagePixel = messagePixels[row][col];
                if ( currPixel.getRed() % 2 == 1 )
                {
                    messagePixel.setColor( Color.BLACK );
                    count++;
                }
            }
        }
        System.out.println( count );
        return messagePicture;
    }


    /**
     * Method to return the count of the number of pixels with a red value
     * greater than the passed value
     * 
     * @param value
     *            the value to compare to
     * @return the count
     */
    public int getCountRedOverValue( int value )
    {
        int count = 0;
        Pixel[][] pixels = this.getPixels2D();
        Pixel currPixel = null;
        for ( int row = 0; row < pixels.length; row++ )
        {
            for ( int col = 0; col < pixels[0].length; col++ )
            {
                currPixel = pixels[row][col];
                if ( currPixel.getRed() > value )
                {
                    count++;
                }
            }
        }
        return count;
    }


    /**
     * Method to set the red in the top half of the picture to half the original
     * value
     */
    public void setRedToHalfValueInTopHalf()
    {
        Pixel[][] pixels = this.getPixels2D();
        Pixel currPixel = null;
        for ( int row = 0; row < pixels.length / 2; row++ )
        {
            for ( int col = 0; col < pixels[0].length; col++ )
            {
                currPixel = pixels[row][col];
                currPixel.setRed( currPixel.getRed() / 2 );
            }
        }
    }


    /**
     * Method to clear the blue (set to 0) if it is over the passed value
     * 
     * @param value
     *            the value to compare to
     */
    public void clearBlueOverValue( int value )
    {
        Pixel[][] pixels = this.getPixels2D();
        Pixel currPixel = null;
        for ( int row = 0; row < pixels.length; row++ )
        {
            for ( int col = 0; col < pixels[0].length; col++ )
            {
                currPixel = pixels[row][col];
                if ( currPixel.getBlue() > value )
                {
                    currPixel.setBlue( 0 );
                }
            }
        }
    }


    /**
     * Method to return the average value for the specified column
     * 
     * @param col
     *            the column index to get the average from
     * @return the average of the values in that column
     */
    public int[] getAverageForColumn( int col )
    {
        Pixel[][] pixels = this.getPixels2D();
        Pixel currPixel = null;
        int[] averageArray = new int[pixels[col].length];
        int total = 0;

        for ( int row = 0; row < pixels.length; row++ )
        {
            currPixel = pixels[row][col];
            total = currPixel.getRed() + currPixel.getGreen() + currPixel.getBlue();
            averageArray[row] = total / 3;
        }
        return averageArray;
    }


    /*
     * Main method for testing - each class in Java can have a main method
     */
    public static void main( String[] args )
    {
        Picture beach = new Picture( "beach.jpg" );
        beach.explore();
        beach.zeroBlue();
        beach.explore();
    }

} // this } is the end of class Picture, put all new methods before this
