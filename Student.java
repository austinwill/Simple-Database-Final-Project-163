
import java.io.Serializable;

/**********************************************************************
 * The following class instantiates a student and the data that 
 * makes up a student
 * 
 * @author Louis Marzorati
 * @author Daniel Kelch

 * @version 12/02/13
 **********************************************************************/

public class Student implements Comparable<Student>, Serializable  {
	
	/**This represents the name of the student**/
	private String name;
	
	/**This represents the G number of student**/
	private String gNumber;
	
	/**This represents the GPA of student**/
	private double gpa;

	/******************************************************************
	 * This is the student constructor, and checks for valid input for
	 * the different parameters.
	 *  
	 * @param name the name of the student
	 * @param gNumber the Gnumber of the student
	 * @param gpa the GPA of a student
	 *****************************************************************/
	public Student(String name, String gNumber, double gpa) {
		super();
		
		if(gpa<=0 || gpa>4){	
			throw new IllegalArgumentException();
		}
		
		if(name.isEmpty()){
			throw new IllegalArgumentException();
		}
		
		if(name.matches("\\d+")){
			throw new IllegalArgumentException();
		}
		
		if(gNumber.isEmpty()){
			throw new IllegalArgumentException();
		}
		
		if(gNumber.matches("[a-zA-Z]+")){
			throw new IllegalArgumentException();
		}
		
		this.name = name;
		this.gNumber = gNumber;
		this.gpa = gpa;
	}


	/******************************************************************
	 * Method that returns the student name
	 *****************************************************************/
	public String getName() {
		return name;
	}
	
	/******************************************************************
	 * Method that sets the student name
	 *****************************************************************/
	public void setName(String name) {
		this.name = name;
	}
	
	/******************************************************************
	 * Method that returns the student gNumber
	 *****************************************************************/
	public String getGNumber() {
		return gNumber;
	}

	/******************************************************************
	 * Method that sets the student G number
	 *****************************************************************/
	public void setgNumber(String gNumber) {
		this.gNumber = gNumber;
	}

	/******************************************************************
	 * Method that returns the students gpa
	 *****************************************************************/
	public double getGpa() {
		return gpa;
	}

	/******************************************************************
	 * Method that sets the students gpa
	 *****************************************************************/
	public void setGpa(double gpa) {
		this.gpa = gpa;
	}

	/******************************************************************
	 * Method that returns a string of all the data for a student
	 *****************************************************************/
	public String toString(){
		return name + " " + gNumber + " " + gpa + " ";
	}
	/******************************************************************
	 *  Method that returns 1 if its the same student, 0 if not
	 *****************************************************************/
	public int compareTo(Student data) {
		if(gpa == data.gpa && gNumber == data.gNumber && name == data.name)
			return 1;
		else
			return 0;
	}

}

