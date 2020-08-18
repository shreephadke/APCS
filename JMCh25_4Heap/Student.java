/**
 * Student.java
 * 
 * Stores the following information about students grade name (first and last)
 * Lynbrook id
 * 
 */

/**
 * 
 * @author shrphadke
 * @version Mar 8, 2019
 * @author Period: 3
 * @author Assignment: JMCh25_4Heap
 *
 * @author Sources: None
 */
public class Student implements Comparable
{
    private String lynbrookId;

    private String firstName;

    private String lastName;

    private int grade;


    public Student( String id, String fName, String lName, int g )
    {
        lynbrookId = id;
        firstName = fName;
        lastName = lName;
        grade = g;
    }


    public Student()
    {
        this( "", "", "", 0 );
    }


    /**
     * compares the grade of each student, and if the grades are equal then
     * compares Lynbrook IDs and sorts the students in increasing order by their
     * Lynbrook ID
     * 
     * @param obj
     * @return diff between grades of two people
     */
    public int compareTo( Object obj )
    {
        Student stud = (Student)obj;

        if ( ( grade - stud.grade ) == 0 )
        {
            return lynbrookId.compareTo( stud.lynbrookId );
        }
        return grade - stud.grade;
    }


    public Object clone()
    {
        return new Student( lynbrookId, firstName, lastName, grade );
    }


    public String toString()
    {
        return lynbrookId + " " + firstName + " " + lastName + " " + grade;
    }
}
