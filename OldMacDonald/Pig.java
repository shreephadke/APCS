
/**
 * 
 * TODO Finds and returns pig's characteristics. TODO Returns the type and sound
 * of the pig.
 *
 * @author Shree Phadke
 * @version Oct 26, 2018
 * @author Period: 3
 * @author Assignment: A29_1OldMacDonald
 *
 * @author Sources: None
 */
public class Pig implements Animal
{

    private String myType;

    private String mySound;


    /**
     * Initializes a newly created Cow object so that it represents an Animal of
     * the specified type that makes the specified sound.
     * 
     * @param type
     *            the type of Pig
     * @param sound
     *            the sound the Pig makes
     */
    public Pig( String type, String sound )
    {
        myType = type;
        mySound = sound;
    }


    @Override
    /**
     * @return mySound of animal
     */
    public String getSound()
    {

        return mySound;

    }


    @Override
    /**
     * @return myType of animal
     */
    public String getType()
    {

        return myType;

    }

}