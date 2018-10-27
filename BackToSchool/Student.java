/**
 * 
 *  TODO Student Object with id Number and GPA
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

public class Student extends Person //inherits Person class methods
{
    private String myIdNum; // Student Id Number

    private double myGPA; // grade point average


    /**
     * 
     * @param name
     * @param age
     * @param gender
     * @param idNum
     * @param gpa
     */
    public Student( String name, int age, String gender, 
        String idNum, double gpa )
    {
        // use the super class' constructor
        super( name, age, gender );

        // initialize what's new to Student
        myIdNum = idNum;
        myGPA = gpa;
    }


    //getter and setter methods for ID Number and GPA
    public String getIdNum()
    {
        return myIdNum;
    }


    public double getGPA()
    {
        return myGPA;
    }


    public void setIdNum( String idNum )
    {
        myIdNum = idNum;
    }


    public void setGPA( double gpa )
    {
        myGPA = gpa;
    }


    /**
     * toString Method
     * Returns a String representation of this class.
     * 
     * @return private instance data as a String
     */
    public String toString()
    {
        return super.toString() + ", student id: " + myIdNum 
                        + ", gpa: " + myGPA;
    }
}
