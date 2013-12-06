
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.Stack;

import javax.swing.JOptionPane;




public class SimpleDatabase implements ISimpleDatabase{
	private Node top;
	private Node tail;
	private Stack<SimpleDatabase> history;


	public SimpleDatabase() {
		top = tail = null;
		history = new Stack<SimpleDatabase>();
	}

	public void insertTop(Student student) {
		if (top == null)
			tail = top = new Node (student,top, tail);
		//		else if (top.getNext() == null)
		//			top = new Node(student,top,tail);
		else{
			top = new Node(student, top, null);
			top.getNext().setPrev(top);
		}


	}

	public void insert(Student student) {
		if (top == null)
			tail = top = new Node (student,top, tail);
		//		else if (top.getNext() == null)
		//			top = new Node(student,top,tail);
		else{
			tail = new Node(student, null, tail);
			tail.getPrev().setNext(tail);
		}


	}

	public boolean delete(String data) {


		//No list
		if (top == null)
			return false;

		//Deletes single item
		if (top == tail && top.getData().getGNumber().equals(data)){
			top = tail = null;
			return true;
		}

		//If top is the one to delete
		if (top.getData().getGNumber().equals(data)) {
			top = top.getNext();
			if (top != null)
				top.setPrev(null);	
			return true;
		}

		//If tail is the one to delete
		//		if (tail.getData().getGNumber().equals(data)) {
		//			tail = tail.getPrev();
		//			return true;
		//		}




		for (Node temp = top; temp != null; temp = temp.getNext()) 
			if (temp.getData().getGNumber().equals(data)) {

				// checks if student is in last node
				if (temp.getNext() == null) 
					temp.getPrev().setNext(null);

				// checks if student is in middle of nodes
				else {
					temp.getPrev().setNext(temp.getNext());
					temp.getNext().setPrev(temp.getPrev());
				}
				return true;
			}

		return false;
	}


	public String toString() {
		String str = "";
		for (Node temp = top; temp != null; temp = temp.getNext())
			str += temp.getData();

		return str;
	}

	public String display() {
		String str = "";

		for (Node temp = top; temp != null; temp = temp.getNext())
			str += temp.getData() + "\n";

		return str;
	}



	public Student find (String gNumber){


		for (Node temp = top; temp != null; temp = temp.getNext()) 

			//Does this need to be getNext?
			if (temp.getData().getGNumber().equals(gNumber)) 


				return temp.getData();

		return null;
	}



	public void reverseList() {
	
			Node temp = top;
			top = tail;
			tail = temp;

			Node p =top;
			while(p != null){
				temp = p.getNext();
				p.next = p.prev;
				p.prev = temp;
				p = p.next;
			}
		} 
	
	@Override
	public void removeDuplicates() {

		Node prev = top;
		Node curr = prev.getNext();


		while(curr != null){
			Node temp = top;
			while(temp != curr){
				if(temp.getData().getGNumber().equals(curr.getData().getGNumber()))
					delete(temp.getData().getGNumber());

				temp = temp.getNext();
			}


			if(curr == temp){
				prev = curr;
				curr = curr.getNext();
			}


		}
	}


	public int getCount(){
		Node temp = top;
		int count = 0;
		while(temp != null){
			count++;
			temp = temp.getNext();
		}
		return count;
	}



	public SimpleDatabase undo() {

		if(!history.isEmpty())
			return history.pop();
		return null;

	}


	public void saveForUndo(SimpleDatabase db){
		history.push(db);
	}



	public SimpleDatabase loadDB(String fileName) {
		SimpleDatabase db = new SimpleDatabase();
		try {
			Scanner scanner = new Scanner(new File(fileName));

			//First line in the text files is the number of sites
			int count = Integer.parseInt(scanner.nextLine().trim());

			//Reads the rest of the file
			for (int i = 0; i < count; i++) {
				String name = scanner.nextLine().trim();
				String gNum = scanner.nextLine().trim();
				double gpa = Double.parseDouble(scanner.nextLine().trim());
				Student s = new Student(name, gNum, gpa);
				db.insert(s);

			}
			scanner.close();
			return db;
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, "Invalid File");

		}

		return null;

	}

	@Override
	public boolean saveDB(String fileName) {
		if(fileName.equals(""))
			return false;
		try{
			PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(fileName)));
			out.println(getCount());
			for(Node temp = top; temp != null; temp = temp.getNext()){
				out.println(temp.getData().getName());
				out.println(temp.getData().getGNumber());
				out.println(temp.getData().getGpa());
			}
			out.close();
			return true;

		}catch(IOException e){
			return false;

		}
	}




}

