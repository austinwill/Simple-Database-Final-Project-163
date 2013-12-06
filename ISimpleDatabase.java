/**********************************************************************
 * The following is an interface that just contains all the methods
 * for Simple Database
 * 
 * @author Louis Marzorati
 * @author Daniel Keltch 

 * @version 12/02/13 
 **********************************************************************/
interface ISimpleDatabase {

	/* used to insert a student into the DB */
	void insert(Student student);

	/* used to delete a student from the DB, use the gNumber to find the student*/
	boolean delete(String gNumber);

	/* returns a string of the entire DB */
	String toString();

	/* finds a Student, otherwise returns null */
	Student find(String gNumber);

	/* reverses the database (see notes below) */
	void reverseList();

	/* removes duplicates from the database) */
	void removeDuplicates();

	/* Loads using files */
	SimpleDatabase loadDB(String fileName);
	
	/* Saves using files */
	boolean saveDB(String fileName);


} 
