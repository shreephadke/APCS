
/**
 * 
 * TODO Returns the Chick's features. TODO Uses the Animal Interface.
 *
 * @author Shree Phadke
 * @version Oct 26, 2018
 * @author Period: 3
 * @author Assignment: A29_1OldMacDonald
 *
 * @author Sources: None
 */
public class Chick implements Animal
{

    private String mySound;

    private String myOtherSound;

    private String myType;


    /**
     * 
     * @param type
     *            type of animal
     * @param sound
     *            sound it makes
     */
    public Chick( String type, String sound )
    {
        myType = type;
        mySound = sound;

    }


    /**
     * @param type
     *            type of animal
     * @param sound
     *            sound it makes
     * @param otherSound
     *            other sound it makes
     */
    public Chick( String type, String sound, String otherSound )
    {
        myType = type;
        mySound = sound;
        myOtherSound = otherSound;

    }


    /**
     * @return String of sound depending on how the chick feels
     */
    public String getSound()
    {
        if ( Math.random() >= 0.5 )
        {
            return mySound;
        }
        else
        {
            return myOtherSound;
        }
    }


    /**
     * @return myType of animal
     */
    public String getType()
    {
        return myType;
    }
}