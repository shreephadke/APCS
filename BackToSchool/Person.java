/**
 * 
 *  TODO Person object class with name, age, and gender
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
public class Person
{
    private String myName;   // name of the person
    private int myAge;       // person's age
    private String myGender; // 'M' for male, 'F' for female

    /**
     * 
     * @param name
     * @param age
     * @param gender
     */
     public Person( String name, int age, String gender )
    {
        myName = name;
        myAge = age;
        myGender = gender;
    }

     // getter and setter methods for Name, Age, and Gender
    
     /**
      * 
      * TODO gets the name
      * @return name of the person
      */
     public String getName()
    {
        return myName;
    }


     /**
      * 
      * TODO gets the age
      * @return age of person
      */
    public int getAge()
    {
        return myAge;
    }

    
    /**
     * 
     * TODO gets the gender 
     * @return gender of person
     */
    public String getGender()
    {
        return myGender;
    }

    /**
     * 
     * TODO sets the name
     * @param name of person
     */
    public void setName( String name )
    {
        myName = name;
    }

    /**
     * 
     * TODO sets the age
     * @param age of person
     */
    public void setAge( int age )
    {
        myAge = age;
    }

    /**
     * 
     * TODO sets the gender
     * @param gender of person
     */
    public void setGender( String gender )
    {
        myGender = gender;
    }

    /**
     * toString Method
     * Returns a String representation of this class.
     * @return private instance data as a String
     */
    public String toString()
    {
        return myName + ", age: " + myAge + ", gender: " + myGender;
    }
}