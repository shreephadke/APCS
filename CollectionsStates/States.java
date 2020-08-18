import java.util.*;


/**
 * Represents various States and their respective cities.
 *
 * @author Shree Phadke
 * @version April 8, 2019
 * @author Period - 3
 *
 * @author Assignment - TestSem2CollectionsStates
 *
 * @author Sources - None
 */
public class States
{
    private Map<String, Set<String>> theMap;


    public States()
    {
        theMap = new TreeMap<String, Set<String>>();
    }


    // postcondition: Information from theCity
    // has been added to theMap
    public void addCityToMap( CityInfo theCity )
    {
        if ( theMap.containsKey( theCity.state() ) )
        {
            theMap.get( theCity.state() ).add( theCity.city() );

        }
        else
        {
            Set<String> tset = new TreeSet<String>();
            tset.add( theCity.city() );
            theMap.put( theCity.state(), tset );

        }

    }


    public void printOneState( String theState )
    {
        // not allowed since output is specified without the "[...]"
        // System.out.println(theState + " " + theMap.get(theState));

        System.out.print( theState );
        String SPACE = " ";

        for ( String str : theMap.get( theState ) )
        {
            System.out.print( SPACE + str );
        }

    }


    public void printAllStates()
    {
        String SPACE = " ";

        for ( String str : theMap.keySet() )
        {
            for ( String theState : theMap.get( str ) )
            {
                System.out.println( str + SPACE + theState );
            }
        }
    }


    // *************************************************************
    // For test purposes only
    // not to be used in solution implementation
    public Map<String, Set<String>> getTheMap()
    {
        return theMap;
    }
}
