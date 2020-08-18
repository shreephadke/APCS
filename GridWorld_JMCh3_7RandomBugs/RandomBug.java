import info.gridworld.actor.Bug;
import java.awt.Color;


/**
 * A subclass of Bug that adds the turnAround method and redefines Bug's act
 * method so that this bug makes a U-turn when it can't move
 * 
 * @author TODO Your Name
 * @version TODO Date
 *
 * @author Period - TODO Your Period
 * @author Assignment - Random Bugs - UTurnBug
 *
 * @author Sources - TODO list collaborators
 */
public class RandomBug extends Bug
{
    public RandomBug()
    {
        setColor( Color.YELLOW );
    }


    public RandomBug( Color bugColor )
    {
        setColor( bugColor );
    }


    public void turn( int angle )
    {
        turn();
        turn();
        turn();
        turn(); // Or: setDirection(getDirection() + 180);
    }


    // Overrides Bug's act method
    public void act()
    {
        int angle = 45 * (int)( Math.random() * 8 );

        if ( canMove() )
        {
            move();
        }
        else
        {
            turn( angle );
        }
    }
}
