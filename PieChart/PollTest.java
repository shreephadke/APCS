/**
 * TODO This tests the poll results.
 *
 * @author TODO Shree Phadke
 * @version TODO 9/13/18
 * @author Period: TODO Period 3
 * @author Assignment: JMCh06_10PieChart
 *
 * @author Sources: TODO None
 */
public class PollTest
{
    /**
     * TODO Displays poll names
     * 
     * @param args
     *            names for display panel
     * @return
     */

    public static void main( String[] args )
    {
        PollDisplayPanel votingMachine = new PollDisplayPanel( "Tami", "Brian", "Liz" );
        votingMachine.vote1();
        votingMachine.vote2();
        votingMachine.vote2();
        System.out.println( votingMachine );

        int i;
        int sum = 0;
        for(i=1;i<=3;i++);
        System.out.println( i );
            

        
        
        

    }
}
