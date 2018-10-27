/**
 * 
 *  TODO Outputs and tests the objects created in other classes
 *  TODO using the main method you can call this and get your details with 
 *       given params.
 *
 *  @author  shrphadke
 *  @version Oct 19, 2018
 *  @author  Period: 3
 *  @author  Assignment: A11_1BackToSchool
 *
 *  @author  Sources: None
 */
public class BackToSchool
{
    /**
     * 
     * TODO main method to test other objects
     * @param args
     */
    public static void main( String args[] )
    {
        //creates Person object with given parameters
        Person bob = new Person( "Coach Bob", 27, "M" );
        System.out.println( bob );

        //creates Student object with given parameters
        Student lynne = new Student( "Lynne Brooke", 16, "F",
            "HS95129", 3.5 );
        System.out.println( lynne );

        //creates Teacher object with given parameters
        Teacher mrJava = new Teacher( "Duke Java", 34, "M",
            "Computer Science", 50000 );
        System.out.println( mrJava );

        //creates CollegeStudent object with given parameters
        CollegeStudent ima = new CollegeStudent( "Ima Frosh", 18, "F",
            "UCB123", 4.0, 1, "English" );
        System.out.println( ima );
    }
}
