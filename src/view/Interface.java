package view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import controller.Controller;

import model.Course;
import model.HasStudied;
import model.Student;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextArea;
import javax.swing.JLabel;

public class Interface {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;
	private DefaultTableModel dataModelCourse;
	private DefaultTableModel dataModelInfo;
	private DefaultTableModel dataModelGrade;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Interface window = new Interface();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Interface() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("JALD");
		frame.setBounds(100, 100, 1118, 735);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 1096, 679);
		frame.getContentPane().add(tabbedPane);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Uppgift 1", null, panel, null);
		panel.setLayout(null);
		
		textField = new JTextField();
		panel.add(textField);
		textField.setColumns(10);
		textField.setBounds(15, 52, 146, 26);
		
		JLabel lblPersonnumer = new JLabel("Ssn");
		lblPersonnumer.setBounds(15, 16, 79, 20);
		panel.add(lblPersonnumer);
		
		textField_1 = new JTextField();
		textField_1.setBounds(15, 130, 146, 26);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(15, 94, 69, 20);
		panel.add(lblName);
		
		textField_2 = new JTextField();
		textField_2.setBounds(15, 214, 146, 26);
		panel.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(15, 178, 69, 20);
		panel.add(lblEmail);
		
		JLabel lblCourseId = new JLabel("Course ID");
		lblCourseId.setBounds(329, 16, 103, 20);
		panel.add(lblCourseId);
		
		textField_3 = new JTextField();
		textField_3.setBounds(329, 52, 146, 26);
		panel.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblCourseName = new JLabel("Course Name");
		lblCourseName.setBounds(329, 94, 103, 20);
		panel.add(lblCourseName);
		
		textField_4 = new JTextField();
		textField_4.setBounds(329, 130, 146, 26);
		panel.add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblCredits = new JLabel("Credits");
		lblCredits.setBounds(326, 178, 69, 20);
		panel.add(lblCredits);
		
		textField_5 = new JTextField();
		textField_5.setBounds(329, 214, 146, 26);
		panel.add(textField_5);
		textField_5.setColumns(10);
		
		JTextArea messageBoard = new JTextArea();
		messageBoard.setBounds(15, 546, 788, 83);
		panel.add(messageBoard);
		
		JButton btnAddStudent = new JButton("Add Student");
		btnAddStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
			
			String ssn = textField.getText();
			String name = textField_1.getText();
			String email = textField_2.getText();
			
			if (ssn.isEmpty() || name.isEmpty() || email.isEmpty()) {
				messageBoard.setText("Please type in all fields");
			}else {
				try {
					Controller.addStudent(ssn, name, email);
					messageBoard.setText("Student added!");
				}catch (SQLException sql) {
					messageBoard.setText("Error");
				}
			 }
			textField.setText(" ");
			textField_1.setText(" ");
			textField_2.setText(" ");
		  }		
		});
		panel.add(btnAddStudent);
		btnAddStudent.setBounds(15, 274, 146, 29);
		
		JButton btnAddCourse = new JButton("Add Course");
		btnAddCourse.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				String courseID = textField_3.getText();
				String courseName = textField_4.getText();
				String credits = textField_5.getText();
				
				
				if(courseID.isEmpty() || courseName.isEmpty() || textField_5.getText().isEmpty()) {
					messageBoard.setText("Please type in all fields");
				}else {
					
					try {
						try {
							
							Integer cred = Integer.parseInt(credits);
							Controller.addCourse(courseID, courseName, cred);
							messageBoard.setText("Course added");
							
							
						}catch (SQLException sql){
							messageBoard.setText("ErrorMessage");
						}	
						
						
						
					}catch (NumberFormatException ne) {
						messageBoard.setText("Only numbers is allowed");
					}
					
				}
				textField_3.setText(" ");
				textField_4.setText(" ");
				textField_5.setText(" ");
						
			}
		});
		btnAddCourse.setBounds(329, 274, 146, 29);
		panel.add(btnAddCourse);
		
		textField_6 = new JTextField();
		textField_6.setBounds(15, 375, 146, 26);
		panel.add(textField_6);
		textField_6.setColumns(10);
		
		JLabel lblTypeInSsn = new JLabel("Type in ssn");
		lblTypeInSsn.setBounds(15, 343, 146, 20);
		panel.add(lblTypeInSsn);
		
		JButton btnFindStudent = new JButton("Find Student");
		btnFindStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String ssn = textField_6.getText();
				if (!ssn.isEmpty()) {
					try {
						Student st = Controller.findStudent(ssn);
						
						if (st == null) {
							String notFound = Controller.studentNotFound(ssn);
							messageBoard.setText(notFound);
						}else {
							messageBoard.setText("Student with name: " + st.getName() + " " + "found");
						}
							
					}catch (SQLException sq) {
							messageBoard.setText("Error");
							
					}
				
			}else {
				messageBoard.setText("Please type in all fields");
			}
		
				
			textField_6.setText(null);
		
			}
			
		});
		btnFindStudent.setBounds(15, 417, 146, 29);
		panel.add(btnFindStudent);
		
		JLabel lblTypeInCourse = new JLabel("Type in Course ID");
		lblTypeInCourse.setBounds(329, 331, 146, 20);
		panel.add(lblTypeInCourse);
		
		textField_7 = new JTextField();
		textField_7.setBounds(329, 375, 146, 26);
		panel.add(textField_7);
		textField_7.setColumns(10);
		
		JButton btnFindCourse = new JButton("Find Course");
		btnFindCourse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String courseID = textField_7.getText();
				
				if (courseID.isEmpty()) {
					messageBoard.setText("Please type in all fields");
				}else {
					try {
						
						Course c = Controller.findCourse(courseID);
						if(c != null) {
							messageBoard.setText("Course with ID: " + " " + c.getCourseID() + " and Name: " + c.getCourseName() + " " + "found");
						}else {
							String notFound = Controller.cNotFound(courseID);
							messageBoard.setText(notFound);
						}
						
					}catch (SQLException sql) {
						messageBoard.setText("ErrorMessage");
					}
					
				}
				textField_7.setText(" ");
			}
		});
		btnFindCourse.setBounds(329, 426, 146, 29);
		panel.add(btnFindCourse);
		
		
		
		JLabel lblSsn = new JLabel("Ssn");
		lblSsn.setBounds(617, 16, 69, 20);
		panel.add(lblSsn);
		
		textField_8 = new JTextField();
		textField_8.setBounds(617, 52, 146, 26);
		panel.add(textField_8);
		textField_8.setColumns(10);
		
		JLabel lblCourseId_1 = new JLabel("Course ID");
		lblCourseId_1.setBounds(617, 94, 116, 20);
		panel.add(lblCourseId_1);
		
		textField_9 = new JTextField();
		textField_9.setBounds(617, 130, 146, 26);
		panel.add(textField_9);
		textField_9.setColumns(10);
		
		JButton btnAddStudentToCourse = new JButton("Add Student To Course");
		btnAddStudentToCourse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String ssn = textField_8.getText();
				String courseID = textField_9.getText();
				//borde inte credits finnas med i studies också??
				
				if(ssn.isEmpty() || courseID.isEmpty()) {
					messageBoard.setText("Please type in all fields");
				}else {
					try {
						Student st = Controller.findStudent(ssn);
						Course c = Controller.findCourse(courseID);
						
						if(c == null) {
							String notFound = Controller.cNotFound(courseID);
							messageBoard.setText(notFound);
							
						}else if (st == null){
							String notFound = Controller.studentNotFound(ssn);
							messageBoard.setText(notFound);
						}else {
							
							//Controller.addStudentToCourse(ssn, courseID);
							messageBoard.setText("Student with ssn: " + st.getSsn() + " " + "has been added to course: " + c.getCourseID());
						}
					}catch (SQLException sql) {
						messageBoard.setText("ErrorMessage");
					}
				}
				textField_8.setText(" ");
				textField_9.setText(" ");
				
			}
		});
		btnAddStudentToCourse.setBounds(617, 174, 234, 29);
		panel.add(btnAddStudentToCourse);
		
		JButton btnShowResult = new JButton("Show Result");
		btnShowResult.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				
				String courseID = textField_7.getText();
				
				if(courseID.isEmpty()) {
					messageBoard.setText("Please type in all fields");
				}else {
					try {
						Course c = Controller.findCourse(courseID);
						
						if (c == null) {
							String notFound = Controller.cNotFound(courseID);
							messageBoard.setText(notFound);
							 
						}else {
							ArrayList<HasStudied> studentResults = Controller.showAllStudentResult(courseID);
							if(studentResults.isEmpty()) {
								messageBoard.setText("No student has read the course");
								
									
							}else {
								
								
								
								//messageBoard.setText(studentResults.toString());
								
							}
						}

					}catch (SQLException sql) {
						messageBoard.setText("ErrorMessage");
					}
					
					
				}
			textField_7.setText(" ");
			}
		});
		btnShowResult.setBounds(329, 471, 146, 29);
		panel.add(btnShowResult);
		
		
		 
		
		
		JButton btnShowResultForStudent = new JButton("Show Result On Course");
		btnShowResultForStudent.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				String ssn = textField_8.getText();
				String courseID = textField_9.getText();
				
				
				if(ssn.isEmpty() || courseID.isEmpty()) {
					messageBoard.setText("Please type in all fields");
				}else {
					try {
						Student st = Controller.findStudent(ssn);
						Course c = Controller.findCourse(courseID);
						
						
						if(st == null || c == null) {
							messageBoard.setText("The student does not exist");
						}else {
							ArrayList<HasStudied> hs = Controller.showResult(ssn, courseID);
							if (hs.isEmpty()) {
								messageBoard.setText("The student with ssn: " + st.getSsn() + "has not examined from the course");
							}else {
								String str = "";
								for (HasStudied x : hs) {
									str = str + x.toString() + "\n";
									
								}
								messageBoard.setText(str);
								//messageBoard.setText(hs.toString());
							}
						}
					}catch (SQLException sql) {
						messageBoard.setText("ErrorMessage");
					}
				}
				textField_8.setText(" ");
				textField_9.setText(" ");
			}
		});
		btnShowResultForStudent.setBounds(617, 219, 234, 29);
		panel.add(btnShowResultForStudent);
		
		JButton btnFindIncompleteStudents = new JButton("Find Incomplete Students");
		btnFindIncompleteStudents.setBounds(15, 471, 226, 29);
		panel.add(btnFindIncompleteStudents);
		
		JButton btnShowAgradeStudents = new JButton("Show A-Grade Students");
		btnShowAgradeStudents.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				//String ssn = textField_8.getText();
				String courseID = textField_9.getText();
				
				if(courseID.isEmpty()) {
					messageBoard.setText("Please type in all fields");
				}else {
					try {
						//Student st = Controller.findStudent(ssn);
						Course c = Controller.findCourse(courseID);
						
						if(c == null) {
							messageBoard.setText("Either the student or the course does not exist");
						}else {
							HashMap<String, String> a_list = Controller.getGradePercentage(courseID);
							if(a_list.isEmpty()) {
								messageBoard.setText("No one has examined from the course");
							}else {
								for(Map.Entry<String, String> entry : a_list.entrySet()) {
									String grade = entry.getKey();
									String percent = entry.getValue() + "%";
									messageBoard.setText(grade + percent);
								}
								
							}
						}
					}catch (SQLException sql) {
						messageBoard.setText("ErrorMessage");
					}
				}
				textField_8.setText("");
				textField_9.setText("");
			}
		});
		btnShowAgradeStudents.setBounds(617, 274, 233, 29);
		panel.add(btnShowAgradeStudents);
		
		textField_10 = new JTextField();
		textField_10.setBounds(617, 367, 146, 26);
		panel.add(textField_10);
		textField_10.setColumns(10);
		
		JLabel lblSsn_1 = new JLabel("Ssn");
		lblSsn_1.setBounds(617, 331, 69, 20);
		panel.add(lblSsn_1);
		
		textField_11 = new JTextField();
		textField_11.setBounds(617, 427, 146, 26);
		panel.add(textField_11);
		textField_11.setColumns(10);
		
		JLabel lblCourseId_2 = new JLabel("Course ID");
		lblCourseId_2.setBounds(617, 402, 92, 20);
		panel.add(lblCourseId_2);
		
		JButton btnRemoveStudent = new JButton("Remove Student");
		btnRemoveStudent.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				String ssn = textField_10.getText();
				
				if(ssn.isEmpty()) {
					messageBoard.setText("Please type in all fields");
				}else {
					
					try {
						Student st = Controller.findStudent(ssn);
						if (st == null) {
							String notFound = Controller.studentNotFound(ssn);
							
							messageBoard.setText(notFound);
						}else {
							Controller.removeStudent(ssn);
							messageBoard.setText("Student with ssn: " + st.getSsn() + "is removed");
						}
					} catch (SQLException sql) {
						messageBoard.setText("ErrorMessage");
					}
					
					
				}
			
				textField_10.setText(" ");
				
			}
		});
		btnRemoveStudent.setBounds(819, 366, 184, 29);
		panel.add(btnRemoveStudent);
		
		JButton btnRemoveCourse = new JButton("Remove Course");
		btnRemoveCourse.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				String courseID = textField_11.getText();
				
				if(courseID.isEmpty()) {
					messageBoard.setText("Please type in all fields");
				}else {
					try {
						Course c = Controller.findCourse(courseID);
						
						if(c == null) {
							String notFound = Controller.cNotFound(courseID);
							messageBoard.setText(notFound);
							
						}else {
							Controller.removeCourse(courseID);
							messageBoard.setText("Course with courseID: " + c.getCourseID() + " is deleted");
						}
					}catch (SQLException sql){
						messageBoard.setText("ErrorMessage");
					}
				}
				textField_11.setText(" ");
			}
		});
		btnRemoveCourse.setBounds(819, 426, 184, 29);
		panel.add(btnRemoveCourse);
		
		JButton btnRemoveStudentFromCourse = new JButton("Remove Student From Course");
		btnRemoveStudentFromCourse.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				String ssn = textField_10.getText();
				String courseID = textField_11.getText();
				//String[] grade = {"A", "B", "C", "D", "E", "U"};
				String grade = "C";
				
				if(ssn.isEmpty() || courseID.isEmpty()) {
					messageBoard.setText("Please type in all fields");
				}else {
					try {
						Student st = Controller.findStudent(ssn);
						Course c = Controller.findCourse(courseID);
						
						if(st == null || c == null) {
							messageBoard.setText("Either the student or the course does not exist");
						}else {
							Controller.removeStudentFromCourse(ssn, courseID);
							messageBoard.setText("Student with ssn: " + st.getSsn() + " " + "has been removed from course: " + c.getCourseID());
							
							//String grade = Controller.generateGrade(ssn, courseID);
							
							Controller.addStudentToHasStudied(ssn, courseID, grade);
						}
					}catch (SQLException sql){
						messageBoard.setText("ErrorMessage");
					}
				}
				textField_10.setText(" ");
				textField_11.setText(" ");
				
			}
		});
		btnRemoveStudentFromCourse.setBounds(562, 471, 256, 29);
		panel.add(btnRemoveStudentFromCourse);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Uppgift 2", null, panel_1, null);
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("Uppgift 3", null, panel_2, null);
		
		
		
		
	}
}
