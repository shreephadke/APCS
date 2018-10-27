/**
 * Simulates a six-sided die.
 *
 * @author TODO Shree Phadke
 * @version TODO 9/17/18
 * @author Period: TODO Period 3
 * @author Assignment: JMCh07_RollingDice
 *
 * @author Sources: None
 */
public class Die
{
    private int numDots;


    /**
     * Sets numDots to a random integer from 1 to 6
     */
    public void roll()
    {

        numDots = (int)( Math.random() * 6 ) + 1; // random number from 1 to 6
    }


    /**
     * Returns the value of the most recent roll.
     * 
     * @return numDots
     */
    public int getNumDots()
    {
        return numDots;
    }
}
