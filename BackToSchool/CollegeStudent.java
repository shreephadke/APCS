
/**
 * 
 *  TODO finds College Student's name, age, gender, id num, gpa, year, major 
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
public class CollegeStudent extends Student //inherits student class methods
{
    // instance variables
    private String myMajor; //major
    private int myYear; //year of schooling (1 - Freshman, 2 - Sophomore, ...)


    // constructor
    /**
     * 
     * @param name of student
     * @param age of student
     * @param gender of student
     * @param idNum of student
     * @param gpa of student
     * @param year of student
     * @param major of student
     */
    public CollegeStudent( String name, int age, String gender, String idNum, 
        double gpa, int year, String major )
    {
        //super class' constructor
        
        super( name, age, gender, idNum, gpa );

        myMajor = major;
        myYear = year;
    }
    

    // getter and setter methods for Year and Major
    
    /**
     * 
     * TODO gets the Year of schooling
     * @return myYear year
     */
    public int getYear()
    {
        return myYear;
    }


    /**
     * 
     * TODO gets major of student
     * @return myMajor major of student
     */
    public String getMajor()
    {

        return myMajor;
    }


    /**
     * 
     * TODO Sets year of student
     * @param year of schooling of student
     */
    public void setYear( int year )
    {
        myYear = year;
    }


    /**
     * 
     * TODO Sets major of student
     * @param major of student
     */
    public void setMajor( String major )
    {
        myMajor = major;
    }

    /**
     * toString Method
     * Returns a String representation of this class.
     * @return private instance data as a String
     */
    public String toString()
    {
        return super.toString() + ", year: " + myYear +
            ", major: " + myMajor;
    }
}
