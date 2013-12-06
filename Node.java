

import java.io.Serializable;
/**********************************************************************
 * The following class instantiates a node that points to a previous 
 * node and a next one, making it a doubly linked list. It also has
 * basic getters and setters.
 * 
 * @author Louis Marzorati
 * @author Daniel Keltch 

 * @version 12/02/13
 **********************************************************************/
public class Node implements Serializable  {
	/**This represents a student**/
	public Student data;

	/**This represents the next node**/
	public Node next;

	/**This represents the previous node**/
	public Node prev;

	/**This represents the total number of nodes **/
	private int count;

	/******************************************************************
	 * This constructor instantiate the next, previous nodes and 
	 * the student data.
	 * @param data represents the student data
	 * @param next represents the next node
	 * @param prev represents the previous node
	 *****************************************************************/
	public Node (Student data, Node next, Node prev){
		super();
		this.data = data;
		this.next = next;
		this.prev = prev;
		count++;
	}
	
	/******************************************************************
	 * Method that calls Serializable constructor
	 *****************************************************************/
	public Node(){
		super();
	}

	/******************************************************************
	 * Method that returns a student
	 *****************************************************************/
	public Student getStudent() {
		return data;
	}

	/******************************************************************
	 * Method that returns student data
	 *****************************************************************/
	public Student getData() {
		return data;
	}

	/******************************************************************
	 * Method that sets a students data
	 *****************************************************************/
	public void setData(Student data) {
		this.data = data;
	}

	/******************************************************************
	 * Method that gets the next node
	 *****************************************************************/
	public Node getNext() {
		return next;
	}

	/******************************************************************
	 * Method that sets the next node
	 *****************************************************************/
	public void setNext(Node next) {
		this.next = next;
	}

	/******************************************************************
	 * Method that gets the previous node
	 *****************************************************************/
	public Node getPrev() {
		return prev;
	}

	/******************************************************************
	 * Method that sets the previous node
	 *****************************************************************/
	public void setPrev(Node prev) {
		this.prev = prev;
	}

	/******************************************************************
	 * Method that returns the number of sets
	 *****************************************************************/
	public int getCount(){
		return count;
	}

	/******************************************************************
	 * Method that sets the number of nodes
	 *****************************************************************/
	public void setCount(int count){
		this.count = count;
	}

}
