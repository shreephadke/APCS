import info.gridworld.actor.Actor;
import info.gridworld.grid.Location;
import info.gridworld.grid.UnboundedGrid;
import info.gridworld.actor.ActorWorld;
import info.gridworld.actor.Rock;


/**
 * TODO Write a one-sentence summary of your class here. TODO Follow it with
 * additional details about its purpose, what abstraction it represents, and how
 * to use it.
 * 
 * @author TODO Your Name
 * @version TODO Date
 * 
 * @author Period - TODO Your Period
 * @author Assignment - GridWorld Part 2, Exercise 2 - SpiralBugRunner
 * 
 * @author Sources - TODO list collaborators
 */
public class SpiralBugRunner
{
    public static void main( String[] args )
    {
        UnboundedGrid grid = new UnboundedGrid<Actor>();
        ActorWorld world = new ActorWorld( grid );

        SpiralBug spug = new SpiralBug(4);
        world.add( new Location( 10, 10 ), spug );
        
        world.add( new SpiralBug( 16 ) );
        
        world.add( new SpiralBug( 40 ) );

        world.add( new Rock() );
        world.show();
    }
}