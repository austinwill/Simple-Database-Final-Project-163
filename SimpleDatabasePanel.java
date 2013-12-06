
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.text.ParseException;
import javax.swing.*;

/**********************************************************************
 * The following class creates all the functionality of the GUI for the 
 * SimpleDatabase including all the buttons, text fields, and action 
 * listeners.
 * 
 * @author Louis Marzorati
 * @author Daniel Kelch

 * @version 12/02/13
 **********************************************************************/

public class SimpleDatabasePanel extends JFrame implements ActionListener {

	/** This represents the text field for name**/
	private JTextField textFieldName;

	/** This represents the field for G Number**/
	private JTextField textFieldGNum;

	/** This represents the text field for GPA**/
	private JTextField textFieldGPA;

	/** This represents the button for find**/
	private JButton btnFind;

	/** This represents the button for duplicate**/
	private JButton btnDuplicate;

	/** This represents the for load**/
	private JButton btnLoad;

	/** This represents the delete**/
	private JButton btnDelete;

	/** This represents the reverse**/
	private JButton btnReverse;

	/** This represents the display**/
	private JButton btnDisplay;

	/** This represents the button for save**/
	private JButton btnSave;

	/** This represents the button for undo**/
	private	JButton btnUndo;

	/** This represents the button for insert**/
	private JButton btnInsert;

	/** This represents the scroll pane**/
	private JScrollPane scrollPane;

	/** This represents the text area**/
	private JTextArea textArea;

	/** This represents the Simple Database**/
	private SimpleDatabase database;

	/** This represents the menu bar**/
	private JMenuBar menuBar;

	/** This represents the file menu**/
	private JMenu mnFile;

	/** This represents the file menu item for clear**/
	private JMenuItem mntmClear;

	/** This represents the file menu item for exit**/
	private JMenuItem mntmExit;

	/** This represents the menu item for delete**/
	private JMenuItem mntmDelete;


	public SimpleDatabasePanel() {

		//sets tbe title
		setTitle("Student Database");
		setSize(400,400);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

		database = new SimpleDatabase();

		// creating the panel
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());

		//Labels and Text Fields
		JPanel westPanel = new JPanel();
		westPanel.setLayout(new GridLayout(3,2));

		//Buttons
		JPanel eastPanel = new JPanel();
		eastPanel.setLayout(new GridLayout(3,3));

		//Creates Menu and menu items
		menuBar = new JMenuBar();
		mnFile = new JMenu("File");
		mntmClear = new JMenuItem("Clear");
		mntmDelete = new JMenuItem("Clear/Delete");
		mntmExit = new JMenuItem("Exit");

		//Adds menu and menu items
		setJMenuBar(menuBar);
		menuBar.add(mnFile);
		mnFile.add(mntmClear);
		mnFile.add(mntmDelete);
		mnFile.add(mntmExit);

		//actionlisteners for menu items
		mntmClear.addActionListener(this);
		mntmDelete.addActionListener(this);
		mntmExit.addActionListener(this);

		//creates labels
		JLabel lblName = new JLabel("Name");
		JLabel lblGNum = new JLabel("G Number");
		JLabel lblGPA = new JLabel("GPA");

		//creates text fields with default values 
		textFieldName = new JTextField("Randy Mandy");
		textFieldName.setColumns(10);
		textFieldGNum = new JTextField("1234");
		textFieldGNum.setColumns(10);
		textFieldGPA = new JTextField("4.0");
		textFieldGPA.setColumns(10);

		//Creates all the buttons
		btnFind = new JButton("Find");
		btnDuplicate = new JButton("Duplicate");
		btnLoad = new JButton("Load");
		btnDelete = new JButton("Delete");
		btnReverse = new JButton("Reverse");
		btnDisplay = new JButton("Display");
		btnSave = new JButton("Save");
		btnUndo = new JButton("Undo");
		btnInsert = new JButton("Insert");

		//adds all the action linsterers 
		btnFind.addActionListener(this);
		btnDuplicate.addActionListener(this);
		btnLoad.addActionListener(this);
		btnDelete.addActionListener(this);
		btnReverse.addActionListener(this);
		btnDisplay.addActionListener(this);
		btnSave.addActionListener(this);
		btnUndo.addActionListener(this);
		btnInsert.addActionListener(this);

		//adds everything to the west panel
		westPanel.add(lblName);
		westPanel.add(textFieldName);
		westPanel.add(lblGNum);
		westPanel.add(textFieldGNum);
		westPanel.add(lblGPA);
		westPanel.add(textFieldGPA);

		//adds everything to the east panel
		eastPanel.add(btnInsert);
		eastPanel.add(btnDelete);
		eastPanel.add(btnFind);
		eastPanel.add(btnDuplicate);
		eastPanel.add(btnReverse);
		eastPanel.add(btnDisplay);
		eastPanel.add(btnUndo);
		eastPanel.add(btnSave);
		eastPanel.add(btnLoad);

		//creates and sets the text area and scroll pane
		textArea = new JTextArea(database.display());
		scrollPane = new JScrollPane(textArea, ScrollPaneConstants.
				VERTICAL_SCROLLBAR_ALWAYS, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setPreferredSize(new Dimension(400, 200));
		panel.add(eastPanel, BorderLayout.EAST);
		panel.add(westPanel, BorderLayout.WEST);
		panel.add(scrollPane, BorderLayout.SOUTH);
		add(panel);
	}

	/******************************************************************
	 * Represents a listener for the buttons that get pressed
	 *****************************************************************/
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == btnFind) {
			database.find(textFieldGNum.getText());
		}

		if (e.getSource() == btnDuplicate) {
			database.saveForUndo(database);
			database.removeDuplicates();
		}

		if (e.getSource() == btnLoad) {
			JFileChooser chooser = new JFileChooser();
			chooser.setCurrentDirectory(new File("/Users/danielkelch/"+
					"Documents/workspace/project4/"));
			int b = chooser.showOpenDialog(null);

			if (b == JFileChooser.APPROVE_OPTION) 
				database = database.loadDB(chooser
						.getSelectedFile().getName());
		}

		if (e.getSource() == btnSave) {
			JFileChooser chooser = new JFileChooser();
			chooser.setCurrentDirectory(new File("/Users" +
					"/danielkelch/Documents/workspace/project4/"));
			int b = chooser.showSaveDialog(null);

			if (b == JFileChooser.APPROVE_OPTION) 
				database.saveDB(chooser.getSelectedFile().getName());
		}

		if (e.getSource() == btnDelete) {
			database.saveForUndo(database);
			database.delete(textFieldGNum.getText());
		}

		if (e.getSource() == btnReverse) {
			database.saveForUndo(database);
			database.reverseList();	
		}

		if (e.getSource() == btnDisplay) {
			if(database.getCount() > 0)
				textArea.append("\nAll Students:\n" +database.display()
						+ "\n");
		}
		
		if (e.getSource() == btnInsert){
			try{
				double gpa =Double.parseDouble(textFieldGPA.getText());
				Student s = new Student(textFieldName.getText()
						, textFieldGNum.getText(), gpa);
				database.insert(s);
				textArea.append(s.toString() + "\n");
			}catch(Exception p){
			JOptionPane.showMessageDialog(null, "Invalid GPA entry");
			}
		}
		
		if (e.getSource() == btnUndo) {
			database = database.undo();
		}
		
		if (mntmExit == e.getSource()) {
			System.exit(0);
		}

		if (mntmClear == e.getSource()) {
			textArea.setText(null);
		}
		
		if (mntmDelete == e.getSource()) {
			textArea.setText(null);		
			database = new SimpleDatabase();
		}
	}
}

