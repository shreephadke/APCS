
/**
 * 
 * TODO gets the name of the cow TODO constructors inherit from Cow class
 *
 * @author Shree Phadke
 * @version Oct 26, 2018
 * @author Period: 3
 * @author Assignment: A29_1OldMacDonald
 *
 * @author Sources: None
 */
public class NamedCow extends Cow
{
    private String myName;


    /**
     * @param name
     *            of animal
     * @param myName
     *            of animal
     * @param sound
     *            animal makes
     *            
     */
    public NamedCow( String name, String myName, String sound)
    {
        super( name, sound );
        this.myName = myName;

    }


    /**
     * @param type
     *            of animal
     * @param sound
     *            animal makes
     */
    public NamedCow( String type, String sound )
    {
        super( type, sound );
    }


    /**
     * returns name of animal
     * 
     * @return myName of the animal
     */
    public String getName()
    {
        return myName;
    }
    

}