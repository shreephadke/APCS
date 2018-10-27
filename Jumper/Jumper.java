import info.gridworld.actor.Bug;
import info.gridworld.grid.Grid;

import java.awt.Color;

import info.gridworld.actor.Actor;
import info.gridworld.grid.Location;


/**
 * A <code>Jumper</code> is an actor that will jump over Rocks and Flowers and
 * turn. A jumper can remove another jumper by jumping on them.
 * 
 * @author TODO Shree Phadke, Bella Chen
 * @version TODO 10/24/18
 * @author Period: 3
 * @author Assignment: GridWorld_Part3_Jumper
 * 
 * @author Sources: None
 */
public class Jumper extends Bug implements Edible
{

    // constructors

    /**
     * Creates the Jumper and sets its color to red.
     */
    public Jumper()
    {
        setColor( Color.RED );
    }


    /**
     * 
     * TODO Makes the Jumper jump over to the new position.
     */
    public void jump()
    {
        Location loc = getLocation();
        Location adj1 = loc.getAdjacentLocation( getDirection() );
        Location adj2 = adj1.getAdjacentLocation( getDirection() );

        if ( canMove() )
        {

            moveTo( adj2 );
        }

    }


    /**
     * jumps if the canMove method returns true, otherwise turns 45 degrees to
     * right
     */
    public void act()
    {
        if ( canMove() )
        {
            jump();
        }

        else
        {
            turn();
        }

    }

    // methods



    
   
    /**
     * if the jumper has an open space, this method will return true, else false
     * @return true or false - if the jumper can move to this space or not
     */
    public boolean canMove()
    {
        Grid<Actor> gr = getGrid();
        Location loc = getLocation();

        /**
         * gets direction of space 1 and 2 spaces away
         */
        Location adj1 = loc.getAdjacentLocation( getDirection() );
        Location adj2 = adj1.getAdjacentLocation( getDirection() );

        /**
         * if space two spaces away is occupied, return false
         */
        if ( !gr.isValid( adj2 ) )
        {
            return false;
        }
        else
        {
            Actor adjSpace = gr.get( adj2 ); // gets location of space two away

            /**
             * if thing in space two spaces away is edible or empty, return true
             */
            return ( adjSpace instanceof Edible ) || ( adjSpace == null );

        }
    }
}