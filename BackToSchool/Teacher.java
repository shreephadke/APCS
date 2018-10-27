/**
 * 
 *  TODO Creates Teacher with Subject and Annual Salary
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
public class Teacher extends Person //inherits person class methods
{
    // instance variables

    private String mySubject;

    private double mySalary;


    // constructor

    /**
     * 
     * @param name of teacher
     * @param age of teacher
     * @param gender of teacher
     * @param sub of teacher 
     * @param salary of teacher
     */
    public Teacher( String name, int age, String gender, 
        String sub, double salary )
    {
        //super class' constructor
        super( name, age, gender );

        mySubject = sub;
        mySalary = salary;
    }

    // getter and setter methods for Subject and Salary
    
    /**
     * 
     * TODO gets the subject
     * @return subject teacher teaches
     */
    public String getSubject()
    {
        return mySubject;
    }


    /**
     * 
     * TODO gets the salary 
     * @return annual salary of the teacher
     */
    public double getSalary()
    {

        return mySalary;
    }


    /**
     * 
     * TODO sets the subject
     * @param sub subject
     */
    public void setSubject( String sub )
    {
        mySubject = sub;
    }


    /**
     * 
     * TODO sets salary
     * @param salary 
     */
    public void setSalary( double salary )
    {
        mySalary = salary;
    }



    // toString method
    
    /**
     * Returns a String representation of this class.
     * 
     * @return private instance data as a String
     */
    public String toString()
    {
        return super.toString() + ", subject: " + mySubject 
                        + ", salary: " + mySalary;
    }
}
