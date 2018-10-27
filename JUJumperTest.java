import info.gridworld.actor.*;
import info.gridworld.grid.*;

import org.junit.*;
import static org.junit.Assert.*;


/**
 * Jumper tests:. test01 - jumper next to edge of grid - should turn test02 -
 * jumper 2 from edge of grid - should turn test03 - if jumper 1 is turning and
 * jumper 2 is 2 spaces below jumper 1 - jumper 2 should remove jumper 1 test04
 * - jump 2 steps to where there is a blank space/edible object test05 - if it
 * eats the edible object test06 - does jumper avoid inedible objects like
 * rocks/flowers test07 - if the jumper is stuck in a position where it cannot
 * go anywhere - should keep on turning
 *
 * @author Bella Chen, Shree Phadke
 * @version TODO 10/26/18
 *
 * @author Period: 3
 * @author Assignment - GridWorld Part 3 Jumper
 *
 * @author Sources: None
 */
public class JUJumperTest
{
    /*
     * Variables used by the test methods.
     */
    private Grid<Actor> grid;

    private ActorWorld world;

    private Jumper jumper1;

    private Jumper jumper2;

    private Flower flower;

    private Flower flower2;

    private Flower flower3;

    private Rock rock;

    private Rock rock2;

    private Rock rock3;

    private Rock rock4;

    private Rock rock5;


    /**
     * Invoked before each test to instantiate the objects used for every test.
     */
    @Before
    public void initialize()
    {
        grid = new BoundedGrid<Actor>( 8, 8 );
        world = new ActorWorld( grid );
        jumper1 = new Jumper();
        jumper2 = new Jumper();
        flower = new Flower();
        flower2 = new Flower();
        flower3 = new Flower();
        rock = new Rock();
        rock2 = new Rock();
        rock3 = new Rock();
        rock4 = new Rock();
        rock5 = new Rock();
    }


    /**
     * test01 - jumper next to edge of grid - should turn
     */
    @Test
    public void jumperNextToEdgeOfGridShouldTurn()
    {
        Location loc = new Location( 0, 3 );
        world.add( loc, jumper1 );
        jumper1.act();

        assertTrue( testOccupied( loc, jumper1, Location.NORTHEAST ) );
    }


    /**
     * test02 - jumper 2 from edge of grid - should turn.
     */
    @Test
    public void jumper2FromEdgeOfGridShouldTurn()
    {
        Location loc = new Location( 1, 3 );
        world.add( loc, jumper1 );
        jumper1.act();

        assertTrue( testOccupied( loc, jumper1, Location.NORTHEAST ) );
    }


    /**
     * test03 - if jumper 1 is turning and jumper 2 is 2 spaces below jumper 1 -
     * jumper 2 should remove jumper 1
     */
    @Test
    public void removeOtherJumper()
    {
        Location loc = new Location( 2, 2 );
        Location loc2 = new Location( 4, 2 );
        world.add( loc, jumper1 );
        world.add( loc2, jumper2 );
        //takes 2 "acts" to remove jumper1 and one more for it to
        //jump further and face north
        jumper1.act();
        jumper2.act();
        jumper2.act();
        Location loc3 = new Location( 0, 2 );
        assertTrue( testOccupied( loc3, jumper2, Location.NORTH ) );

    }


    /**
     * test04 - jump 2 steps to where there is a blank space/edible object
     */
    @Test
    public void jump2Steps()
    {
        Location loc = new Location( 0, 0 );
        Location loc2 = new Location( 0, 2 );
        Location loc3 = new Location( 2, 2 );
        world.add( loc, jumper1 );
        world.add( loc2, flower );
        world.add( loc3, flower2 );
        //takes 4 acts for the jumper to turn and jump 2 spaces
        jumper1.act();
        jumper1.act();
        jumper1.act();
        jumper1.act();
        assertTrue( testOccupied( loc, jumper1, Location.SOUTH ) );

    }


    /**
     * test05 - if it eats the edible object
     */
    @Test
    public void eatsEdible()
    {
        Location loc = new Location( 0, 7 );
        Location loc2 = new Location( 0, 5 );
        world.add( loc, jumper1 );
        world.add( loc2, jumper2 );
        //jumper2 gets eaten and doesn't act anymore after 2
        //jumper1 keeps going
        jumper1.act();
        jumper2.act();
        jumper1.act();
        jumper2.act();
        jumper1.act();
        jumper1.act();

        Location loc3 = new Location( 0, 9 );
        assertTrue( testOccupied( loc2, jumper2, Location.EAST ) 
            && grid.isValid( loc ) );
    }


    /**
     * test06 - does jumper avoid inedible objects like rocks/flowers
     */
    @Test
    public void turnFromNotEdible()
    {
        Location loc = new Location( 0, 5 );
        Location loc2 = new Location( 0, 7 );
        world.add( loc, jumper1 );
        world.add( loc2, rock );
        //takes 4 acts for jumper1 to turn and move to avoid object
        jumper1.act();
        jumper1.act();
        jumper1.act();
        jumper1.act();
        Location loc3 = new Location( 2, 7 );
        assertTrue( testOccupied( loc3, jumper1, Location.SOUTHEAST ) );

    }


    /**
     * test07 - if the jumper is stuck in a position where it cannot go anywhere
     * - should keep on turning
     */
    @Test
    public void keepTurning()
    {
        //create objects that surround the jumper so it has nowhere to go
        Location loc = new Location( 2, 5 );
        world.add( loc, jumper1 );
        loc = new Location( 0, 7 );
        world.add( loc, rock );
        loc = new Location( 2, 7 );
        world.add( loc, rock2 );
        loc = new Location( 4, 7 );
        world.add( loc, flower );
        loc = new Location( 4, 5 );
        world.add( loc, flower2 );
        loc = new Location( 4, 3 );
        world.add( loc, flower3 );
        loc = new Location( 2, 3 );
        world.add( loc, rock3 );
        loc = new Location( 0, 3 );
        world.add( loc, rock4 );
        loc = new Location( 0, 5 );
        world.add( loc, rock5 );
        //acts 8 times to check for every object surrounding it
        for ( int i = 1; i <= 8; i++ )
        {
            jumper1.act();
        }
        Location loc2 = new Location( 2, 5 );
        assertTrue( testOccupied( loc2, jumper1, Location.NORTH ) );
    }


    /**
     * Test helper method to test for empty location.
     *
     * @param loc
     *            null location if empty
     * @return true if all assertions pass
     */
    private boolean testEmpty( Location loc )
    {
        Actor empty = grid.get( loc );
        assertNull( "<<<<< " + loc + " should be empty. >>>>>", empty );

        return true;
    }


    /**
     * Test helper method to test that object is in a location, and has a
     * consistent loc, and direction dir.
     *
     * @param loc
     *            location that should be occupied
     * @param a
     *            actor that should be in location loc
     * @param dir
     *            direction this actor should be facing
     * @return true if all assertions pass
     */
    private boolean testOccupied( Location loc, Actor a, int dir )
    {
        Actor found = grid.get( loc );
        assertSame( "<<<<< " + loc + " should contain the actor. >>>>>", 
            a, found );
        assertEquals( "<<<<< Loc should be " + loc + " >>>>>", loc, 
            found.getLocation() );
        assertEquals( "<<<<< Dir should be " + dir + " >>>>>", dir, 
            found.getDirection() );

        return true;
    }
}