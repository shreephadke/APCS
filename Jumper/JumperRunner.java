import info.gridworld.actor.ActorWorld;
import info.gridworld.actor.Bug;
import info.gridworld.actor.Rock;
import info.gridworld.grid.Location;
import info.gridworld.actor.Flower;


/**
 * Tests out cases with various objects such as a bug, jumpers, flowers, and 
 * rocks.
 *
 * @author TODO Shree Phadke, Bella Chen
 * @version TODO 10/20/18
 * @author Period: 3
 * @author Assignment: GridWorld_Part3_Jumper
 *
 * @author Sources: None
 */
public class JumperRunner
{
    public static void main( String[] args )
    {
        ActorWorld world = new ActorWorld();
        Rock r1 = ( new Rock() );
        world.add( new Location( 3, 3 ), r1 );

        Rock r2 = ( new Rock() );
        world.add( new Location( 6, 3 ), r2 );
        
        Rock r3 = ( new Rock() );
        world.add( new Location( 0, 0 ), r3 );
        
        Rock r4 = ( new Rock() );
        world.add( new Location( 0, 1 ), r4 );

        Flower f1 = ( new Flower() );
        world.add( new Location( 1, 1 ), f1 );

        Flower f2 = ( new Flower() );
        world.add( new Location( 4, 4 ), f2 );
        
        Flower f3 = ( new Flower() );
        world.add( new Location( 8, 7 ), f3 );
        
        Flower f4 = ( new Flower() );
        world.add( new Location( 8, 8 ), f4 );

        Jumper j1 = ( new Jumper() );
        world.add( new Location( 2, 2 ), j1 );

        Jumper j2 = ( new Jumper() );
        world.add( new Location( 4, 2 ), j2 );
        
        Bug b1 = (new Bug());
        world.add( new Location( 0, 4 ), b1 );

        world.show();

    }
}