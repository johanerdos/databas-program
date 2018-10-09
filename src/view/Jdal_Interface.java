package view;

import java.awt.BorderLayout;
import java.awt.Choice;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import controller.Controller;
import controller.Controller_2;
import controller.Controller_3;
import errorCode.ErrorHandling;
import model.Course;
import model.HasStudied;
import model.Student;

import java.awt.Color;
import javax.swing.JTabbedPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JScrollBar;
import javax.swing.JList;
import javax.swing.JTree;
import javax.swing.JComboBox;

public class Jdal_Interface extends JFrame {

	private JPanel contentPane;
	private JTextField ssnTextField;
	private JTextField nameTextField;
	private JTextField addressTextField;
	private JTable table;
	private JTextField textFieldCourseID;
	private JTextField textFieldCourseName;
	private JTextField textFieldCredits;
	private JTable table_1;
	private JTextField textFieldAdminCourseID;
	private JTextField textFieldAdminSSN;
	private JTable table_2;
	private JTextField textFieldAdminCID;
	private DefaultTableModel dataModelStudent;
	private DefaultTableModel dataModelCourse;
	private JScrollPane scrollPane;
	private DefaultTableModel dataModelAdmin;
	private DefaultTableModel dataModelTask2;
	private JTable table_3;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Jdal_Interface frame = new Jdal_Interface();
					frame.setTitle("JDAL");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Jdal_Interface() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 700);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0)));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(27, 11, 600, 600);
		contentPane.add(tabbedPane);
		
		JTabbedPane tabbedPane_1 = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.addTab("Uppgift 1", null, tabbedPane_1, null);
		
		JPanel panel = new JPanel();
		tabbedPane_1.addTab("Student", null, panel, null);
		panel.setLayout(null);
		
		
		
		ssnTextField = new JTextField();
		ssnTextField.setBounds(114, 280, 180, 25);
		panel.add(ssnTextField);
		ssnTextField.setColumns(10);
		
		nameTextField = new JTextField();
		nameTextField.setBounds(114, 328, 180, 25);
		panel.add(nameTextField);
		nameTextField.setColumns(10);
		
		addressTextField = new JTextField();
		addressTextField.setBounds(114, 386, 180, 25);
		panel.add(addressTextField);
		addressTextField.setColumns(10);
		
		JLabel lblCourseId = new JLabel("SSN:");
		lblCourseId.setBounds(20, 285, 70, 14);
		panel.add(lblCourseId);
		
		JTable table = new JTable(new DefaultTableModel(new Object[][] {},new String[] {"Column_1", "Column_2", "Column_3"}));
		table.setRowSelectionAllowed(false);
		table.setToolTipText("");
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setBounds(317, 31, 225, 299);
		panel.add(table);
		
		DefaultTableModel dataModelStudent = (DefaultTableModel) table.getModel();
		String[] studentHeader = {"SSN", "Name", "Address"};
		dataModelStudent.setColumnIdentifiers(studentHeader);
		
		
		JLabel lblCourseName = new JLabel("Name:");
		lblCourseName.setBounds(20, 333, 70, 15);
		panel.add(lblCourseName);
		
		JLabel lblCredits = new JLabel("Address:");
		lblCredits.setBounds(20, 391, 60, 14);
		panel.add(lblCredits);
		

		JPanel panel_1 = new JPanel();
		tabbedPane_1.addTab("Course", null, panel_1, null);
		panel_1.setLayout(null);
		
		JTable table_1 = new JTable(new DefaultTableModel(new Object[][] {},new String[] {"Column_1", "Column_2", "Column_3"}));
		table_1.setCellSelectionEnabled(true);
		table_1.setColumnSelectionAllowed(true);
		table_1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table_1.setBounds(317, 31, 225, 255);
		panel_1.add(table_1);
		
		DefaultTableModel dataModelCourse = (DefaultTableModel) table_1.getModel();
		
		
	
		JTextArea messageBoard = new JTextArea();
		messageBoard.setBounds(20, 461, 522, 59);
		panel.add(messageBoard);
		
		JLabel lblMessageBoard = new JLabel("Message Board");
		lblMessageBoard.setBounds(20, 436, 100, 14);
		panel.add(lblMessageBoard);
		
		JLabel lblResults_2 = new JLabel("Results");
		lblResults_2.setBounds(316, 10, 46, 14);
		panel.add(lblResults_2);
		
		JPanel panel_2 = new JPanel();
		tabbedPane_1.addTab("Admin", null, panel_2, null);
		panel_2.setLayout(null);
		
		JTable table_2 = new JTable(new DefaultTableModel(new Object[][] {}, new String[] {"Column_1", "Column_2", "Column_3"}));
		table_2.setCellSelectionEnabled(true);
		table_2.setColumnSelectionAllowed(true);
		table_2.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table_2.setBounds(350, 250, 220, 167);
		panel_2.add(table_2);
		
		JTextArea messageBoardCourse = new JTextArea();
		messageBoardCourse.setBounds(10, 314, 532, 85);
		panel_1.add(messageBoardCourse);
		String[] header = {"SSN", "Name", "Address"};
		dataModelStudent.setColumnIdentifiers(header);
		
		DefaultTableModel dataModelAdmin = (DefaultTableModel) table_2.getModel();
		
		
		
		JTextArea messageBoardAdmin = new JTextArea();
		messageBoardAdmin.setBounds(10, 251, 239, 160);
		panel_2.add(messageBoardAdmin);
		
		JButton btnAddStudent = new JButton("Add Student");
		btnAddStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					
					String ssn = ssnTextField.getText();
					String name = nameTextField.getText();
					String email = addressTextField.getText();
					
					try {
						Student st = Controller.findStudent(ssn);
						
						if (ssn.isEmpty() || name.isEmpty() || email.isEmpty()) {
							messageBoard.setText("Please type in all fields");
						}else if (st != null) {
							messageBoard.setText("Student already exists");
						}else {
							
							
							
							messageBoard.setText("Student added!");
							
						 }
						
					}catch (SQLException sql) {
						messageBoard.setText(ErrorHandling.getMessageForErrorCode(sql.getErrorCode(), ""));
					}
					
					ssnTextField.setText(null);
					nameTextField.setText(null);
					addressTextField.setText(null);
				  }		
		});
		btnAddStudent.setBounds(20, 102, 274, 25);
		panel.add(btnAddStudent);
		
		JButton btnRemoveStudent = new JButton("Remove Student");
		btnRemoveStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String ssn = ssnTextField.getText();
				
				if(ssn.isEmpty()) {
					messageBoard.setText("Please type in all fields");
				}else {
					
					try {
						Student st = Controller.findStudent(ssn);
						if (st == null) {
							String notFound = Controller.studentNotFound(ssn);
							
							messageBoard.setText(notFound);
						}else {
							
							
							messageBoard.setText("Student with ssn: " + st.getSsn() + "is removed");
						}
					} catch (SQLException sql) {
						messageBoard.setText(ErrorHandling.getMessageForErrorCode(sql.getErrorCode(), ""));
					}
					
					
				}
			
				ssnTextField.setText(null);
				
			}
		});
		btnRemoveStudent.setBounds(20, 154, 274, 25);
		panel.add(btnRemoveStudent);
		
		JButton btnFindStudent = new JButton("Find Student");
		btnFindStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dataModelStudent.setRowCount(0);
				String ssn = ssnTextField.getText();
				
				if (!ssn.isEmpty()) {
					try {
						Student st = Controller.findStudent(ssn);
						
						if (st == null) {
							String notFound = Controller.studentNotFound(ssn);
							messageBoard.setText(notFound);
						}else {
							
							dataModelStudent.addRow(new Object[] { st.getSsn(), st.getName(), st.getEmail() });
							
							
						}
							
					}catch (SQLException sql) {
						messageBoard.setText(ErrorHandling.getMessageForErrorCode(sql.getErrorCode(), ""));
							
					}
				
			}else {
				messageBoard.setText("Please type in all fields");
			}
		
				
			ssnTextField.setText(null);
			
			}
		});
		btnFindStudent.setBounds(20, 221, 274, 25);
		panel.add(btnFindStudent);
		
		
		
		
		
		JButton btnAddCourse = new JButton("Add Course");
		btnAddCourse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
			String courseID = textFieldCourseID.getText();
			String courseName = textFieldCourseName.getText();
			String credits = textFieldCredits.getText();
			
			
			if(courseID.isEmpty() || courseName.isEmpty() || credits.isEmpty()) {
				messageBoardCourse.setText("Please type in all fields");
			}else {
				
				try {
					try {
						
						Integer cred = Integer.parseInt(credits);
						
						
						Controller.addCourse(courseID, courseName, cred);
						messageBoardCourse.setText("Course added!");
						
						
					}catch (SQLException sql){
						messageBoardCourse.setText(ErrorHandling.getMessageForErrorCode(sql.getErrorCode(), ""));
					}	
					
					
					
				}catch (NumberFormatException ne) {
					messageBoardCourse.setText("Only numbers is allowed in the credit field");
				}
				
			}
			textFieldCourseID.setText(null);
			textFieldCourseName.setText(null);
			textFieldCredits.setText(null);
			
			
			}
		});
		btnAddCourse.setBounds(80, 27, 200, 23);
		panel_1.add(btnAddCourse);
		
		JButton btnRemoveCourse = new JButton("Remove Course");
		btnRemoveCourse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String courseID = textFieldCourseID.getText();
				
				if(courseID.isEmpty()) {
					messageBoardCourse.setText("Please type in all fields");
				}else {
					try {
						Course c = Controller.findCourse(courseID);
						
						if(c == null) {
							String notFound = Controller.cNotFound(courseID);
							messageBoardCourse.setText(notFound);
							
						}else {
							
							
							Controller.removeCourse(courseID);
							messageBoardCourse.setText("Course with courseID: " + c.getCourseID() + " is deleted");
						}
					}catch (SQLException sql){
						messageBoardCourse.setText(ErrorHandling.getMessageForErrorCode(sql.getErrorCode(), ""));
					}
				}
				
				textFieldCourseID.setText(null);
			}
		});
		btnRemoveCourse.setBounds(80, 61, 200, 23);
		panel_1.add(btnRemoveCourse);
		
		JButton btnFindCourse = new JButton("Find Course");
		btnFindCourse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			dataModelCourse.setRowCount(0);
			String courseID = textFieldCourseID.getText();
			
			if (courseID.isEmpty()) {
				messageBoardCourse.setText("Please type in all fields");
			}else {
				try {
					
					Course c = Controller.findCourse(courseID);
					if(c != null) {
						dataModelCourse.addRow(new Object[] { c.getCourseID(), c.getCourseName(), c.getCredits() });
						
					}else {
						String notFound = Controller.cNotFound(courseID);
						messageBoardCourse.setText(notFound);
					}
					
				}catch (SQLException sql) {
					messageBoardCourse.setText(ErrorHandling.getMessageForErrorCode(sql.getErrorCode(), ""));
				}
				
			}
			textFieldCourseID.setText(null);
			
			
			}
		});
		btnFindCourse.setBounds(80, 95, 200, 23);
		panel_1.add(btnFindCourse);
		
		textFieldCourseID = new JTextField();
		textFieldCourseID.setBounds(80, 146, 122, 23);
		panel_1.add(textFieldCourseID);
		textFieldCourseID.setColumns(10);
		
		textFieldCourseName = new JTextField();
		textFieldCourseName.setBounds(80, 181, 123, 23);
		panel_1.add(textFieldCourseName);
		textFieldCourseName.setColumns(10);
		
		textFieldCredits = new JTextField();
		textFieldCredits.setBounds(80, 216, 122, 20);
		panel_1.add(textFieldCredits);
		textFieldCredits.setColumns(10);
		
		JLabel lblCourseId_1 = new JLabel("Course ID:");
		lblCourseId_1.setBounds(10, 150, 60, 15);
		panel_1.add(lblCourseId_1);
		
		JLabel lblCourseName_1 = new JLabel("Course Name:");
		lblCourseName_1.setBounds(10, 183, 80, 19);
		panel_1.add(lblCourseName_1);
		
		JLabel lblCredits_1 = new JLabel("Credits:");
		lblCredits_1.setBounds(10, 218, 60, 17);
		panel_1.add(lblCredits_1);
		
		
		
		JLabel lblMessageBoard_1 = new JLabel("Message Board");
		lblMessageBoard_1.setBounds(10, 272, 100, 14);
		panel_1.add(lblMessageBoard_1);
		
		JLabel lblResults_1 = new JLabel("Results");
		lblResults_1.setBounds(317, 11, 46, 14);
		panel_1.add(lblResults_1);
		
		
		
		JButton btnAddStudentTo = new JButton("Add Student To Course");
		btnAddStudentTo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					String ssn = textFieldAdminSSN.getText();
					String courseID = textFieldAdminCourseID.getText();
					
		
					if(ssn.isEmpty() || courseID.isEmpty()) {
						messageBoard.setText("Please type in all fields");
					}else {
						try {
							
							Student st = Controller.findStudent(ssn);
							Course c = Controller.findCourse(courseID);
				
							if(c == null) {
								String notFound = Controller.cNotFound(courseID);
								messageBoardAdmin.setText(notFound);
					
							}else if (st == null){
								String notFound = Controller.studentNotFound(ssn);
								messageBoardAdmin.setText(notFound);
							}else {
					
								Controller.addStudentToCourse(ssn, courseID);
								messageBoardAdmin.setText("Student with ssn: " + st.getSsn() + "\n" + "has been added to course: " + c.getCourseID());
							}
						}catch (SQLException sql) {
							messageBoardAdmin.setText(ErrorHandling.getMessageForErrorCode(sql.getErrorCode(), ""));
						}
					}
					textFieldAdminSSN.setText(null);
					textFieldAdminCourseID.setText(null);
					
		
			}
		});
		
		btnAddStudentTo.setBounds(40, 20, 180, 23);
		panel_2.add(btnAddStudentTo);
		
		JButton btnRemoveStudentFrom = new JButton("Examine Student");
		btnRemoveStudentFrom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String ssn = textFieldAdminSSN.getText();
				String courseID = textFieldAdminCourseID.getText();
				String grade = JOptionPane.showInputDialog("Which grade? You must select between A, B, C, D, E, or U");
				
				if (grade != null) {
					if (grade.equals("A") || grade.equals("B") || grade.equals("C") || grade.equals("D") || grade.equals("E") || grade.equals("U")) {
						if(ssn.isEmpty() || courseID.isEmpty()) {
							messageBoardAdmin.setText("Please type in all fields");
						}else {
							try {
								Student st = Controller.findStudent(ssn);
								Course c = Controller.findCourse(courseID);
								Student s = Controller.findStudentStudying(ssn);
								
								if(st == null || c == null) {
									messageBoardAdmin.setText("Either the student or the course" + "\n" + "does not exist");
								}
								else if (s == null){
									messageBoardAdmin.setText("The student does not study the course");
								}else {
									Controller.removeStudentFromCourse(ssn, courseID);
									messageBoardAdmin.setText("Student with ssn: " + st.getSsn() + "\n" + "has been removed from course: " + c.getCourseID());
									
									
									Controller.addStudentToHasStudied(ssn, courseID, grade);
								}
							}catch (SQLException sql){
								messageBoardAdmin.setText(ErrorHandling.getMessageForErrorCode(sql.getErrorCode(), ""));
							}
						}
					}else {
						messageBoardAdmin.setText("You choose an invalid grade");
					}
				
				}else {
					messageBoardAdmin.setText("");
				}
				
				textFieldAdminSSN.setText(null);
				textFieldAdminCourseID.setText(null);
				
			}
		});
		btnRemoveStudentFrom.setBounds(40, 50, 180, 23);
		panel_2.add(btnRemoveStudentFrom);
		
		textFieldAdminCourseID = new JTextField();
		textFieldAdminCourseID.setBounds(90, 183, 130, 23);
		panel_2.add(textFieldAdminCourseID);
		textFieldAdminCourseID.setColumns(10);
		
		textFieldAdminSSN = new JTextField();
		textFieldAdminSSN.setBounds(90, 152, 130, 20);
		panel_2.add(textFieldAdminSSN);
		textFieldAdminSSN.setColumns(10);
		
		JLabel lblSsn = new JLabel("SSN:");
		lblSsn.setBounds(40, 155, 50, 14);
		panel_2.add(lblSsn);
		
		JLabel lblCourseId_2 = new JLabel("Course ID:");
		lblCourseId_2.setBounds(10, 187, 60, 14);
		panel_2.add(lblCourseId_2);
		
		JButton btnShowResultForCourse = new JButton("Show Result For Course");
		btnShowResultForCourse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dataModelAdmin.setRowCount(0);
				String courseID = textFieldAdminCID.getText();
				
				if(courseID.isEmpty()) {
					messageBoardAdmin.setText("Please type in all fields");
				}else {
					try {
						Course c = Controller.findCourse(courseID);
						
						if (c == null) {
							String notFound = Controller.cNotFound(courseID);
							messageBoardAdmin.setText(notFound);
							 
						}else {
							ArrayList<HasStudied> studentResults = Controller.showAllStudentResult(courseID);
							if(studentResults.isEmpty()) {
								messageBoardAdmin.setText("No student has read the course");
								
									
							}else {
								for (HasStudied x : studentResults) {
									dataModelAdmin.addRow(new Object[] { x.getCourseID(), x.getGrade()});
								}
							}
								
								
							
						}

					}catch (SQLException sql) {
						messageBoardAdmin.setText(ErrorHandling.getMessageForErrorCode(sql.getErrorCode(), ""));
					}
					
					
				}
			textFieldAdminCID.setText(null);
			
			}
		});
		btnShowResultForCourse.setBounds(354, 20, 200, 23);
		panel_2.add(btnShowResultForCourse);
		
		JButton btnShowResultForStudent = new JButton("Show Result For Student");
		btnShowResultForStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dataModelAdmin.setRowCount(0);
				String ssn = textFieldAdminSSN.getText();
				String courseID = textFieldAdminCourseID.getText();
	
				
				if(ssn.isEmpty() || courseID.isEmpty()) {
					messageBoardAdmin.setText("Please type in all fields");
				}else {
					try {
						Student st = Controller.findStudent(ssn);
						Course c = Controller.findCourse(courseID);
						
						
						if(st == null || c == null) {
							messageBoardAdmin.setText("The student does not exist");
						}else {
							ArrayList<HasStudied> hs = Controller.showResult(ssn, courseID);
							if (hs.isEmpty()) {
								messageBoardAdmin.setText("The student with ssn: " + st.getSsn() + "has not" + "\n" + "examined from the course");
							}else {
								for (HasStudied x : hs) {
									dataModelAdmin.addRow(new Object[] { x.getSsn(), x.getCourseID(), x.getGrade() });
								}
							}
						}
					}catch (SQLException sql) {
						messageBoardAdmin.setText(ErrorHandling.getMessageForErrorCode(sql.getErrorCode(), ""));
					}
				}
				textFieldAdminSSN.setText(null);
				textFieldAdminCourseID.setText(null);
				
			}
		});
		btnShowResultForStudent.setBounds(38, 118, 182, 23);
		panel_2.add(btnShowResultForStudent);
		
		JButton btnShowGradePercentage = new JButton("Show Grade Percentage");
		btnShowGradePercentage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dataModelAdmin.setRowCount(0);
				String courseID = textFieldAdminCID.getText();
				
				
				if(courseID.isEmpty()) {
					messageBoardAdmin.setText("Please type in all fields");
				}else {
					try {
						
						Course c = Controller.findCourse(courseID);
						
						if(c == null) {
							messageBoardAdmin.setText("Either the student or" + "\n" + "the course does not exist");
						}else {
							HashMap<String, String> a_list = Controller.getGradePercentage(courseID);
							if(a_list.isEmpty()) {
								messageBoardAdmin.setText("No one has examined from the course");
							}else {
								for(Map.Entry<String, String> entry : a_list.entrySet()) {
									String grade = entry.getKey();
									String percent = entry.getValue() + "%";
									dataModelAdmin.addRow(new Object[] { grade, percent });
								}
								
							}
						}
					}catch (SQLException sql) {
						messageBoardAdmin.setText(ErrorHandling.getMessageForErrorCode(sql.getErrorCode(), ""));
					}
				}
				textFieldAdminCID.setText("");
				
			}
		});
		btnShowGradePercentage.setBounds(354, 50, 200, 23);
		panel_2.add(btnShowGradePercentage);
		
		JButton btnShowFailedStudents = new JButton("Show Failed Students");
		btnShowFailedStudents.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dataModelAdmin.setRowCount(0);
				String courseID = textFieldAdminCourseID.getText();
				
				if (courseID.isEmpty()) {
					messageBoardAdmin.setText("Please type in all fields");
				}else {
					try {
						Course c = Controller.findCourse(courseID);
						if (c == null) {
							messageBoardAdmin.setText("The course does not exist");
						}else {
							ArrayList<HasStudied> hs = Controller.showFailedStudents(courseID);
							if (hs.isEmpty()) {
								messageBoardAdmin.setText("No student has examined" + "\n" + "or no one has failed");
							}else {
								for (HasStudied x : hs) {
									dataModelAdmin.addRow(new Object[] {x.getSsn(), x.getCourseID(), x.getGrade() });
								}
							}
						}
						}catch (SQLException sql) {
							messageBoardAdmin.setText(ErrorHandling.getMessageForErrorCode(sql.getErrorCode(), ""));
						}
					
				}
				textFieldAdminCourseID.setText(null);
				
				
			}
		});
		btnShowFailedStudents.setBounds(40, 84, 180, 23);
		panel_2.add(btnShowFailedStudents);
		
		JButton btnShowTroughput = new JButton("Show Troughput");
		btnShowTroughput.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dataModelAdmin.setRowCount(0);
				try {
					HashMap<String, String> throughput = Controller.getThroughput();
					
					for(Map.Entry<String, String> entry : throughput.entrySet()) {
						String courseID = entry.getKey();
						String percent = entry.getValue() + "%";
						dataModelAdmin.addRow(new Object[] { courseID, percent} );
					}
				}catch (SQLException sql) {
					messageBoardAdmin.setText(ErrorHandling.getMessageForErrorCode(sql.getErrorCode(), ""));
				}
				
			}
		});
		btnShowTroughput.setBounds(354, 84, 200, 23);
		panel_2.add(btnShowTroughput);
		
		JTabbedPane tabbedPane_3 = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.addTab("Uppgift 2", null, tabbedPane_3, null);
		
		
		JPanel panel_3 = new JPanel();
		tabbedPane_3.addTab("", null, panel_3, null);
		panel_3.setLayout(null);
		
		
		
		JTable table_3 = new JTable(new DefaultTableModel(new Object[][] {}, new String[] {"Column_1", "Column_2", "Column_3"} ));
		table_3.setRowSelectionAllowed(false);
		table_3.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table_3.setBounds(10, 118, 570, 254);
		panel_3.add(table_3);
		
		DefaultTableModel dataModelTask2 = (DefaultTableModel) table_3.getModel();

		JLabel lblMessageBoard_2 = new JLabel("Message board");
		lblMessageBoard_2.setBounds(10, 226, 100, 14);
		panel_2.add(lblMessageBoard_2);
		
		textFieldAdminCID = new JTextField();
		textFieldAdminCID.setBounds(354, 134, 160, 20);
		panel_2.add(textFieldAdminCID);
		textFieldAdminCID.setColumns(10);
		
		JLabel lblCourseId_3 = new JLabel("Course ID:");
		lblCourseId_3.setBounds(286, 137, 60, 14);
		panel_2.add(lblCourseId_3);
		
		JLabel lblResults = new JLabel("Results");
		lblResults.setBounds(294, 225, 46, 14);
		panel_2.add(lblResults);
		
		JTextArea messageBoard_2 = new JTextArea();
		messageBoard_2.setBounds(10, 426, 570, 107);
		panel_3.add(messageBoard_2);
		
		
		
		
		
		
		String[] tables = {" ", "Absence", "Portal Setup", "Qualification", "Relative", "Statistics Group"};
		JComboBox tables_list = new JComboBox(tables);
		tables_list.setBounds(10, 41, 95, 33);
		tables_list.setSelectedItem(tables_list);
		panel_3.add(tables_list);
		
		JButton btnShowInformation = new JButton("Show information");
		btnShowInformation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String listChoice = (String) tables_list.getSelectedItem();
				dataModelTask2.setRowCount(0);
				dataModelTask2.addRow(new Object[] { tables_list.getSelectedItem() });
				if (listChoice.equals(" ")) {
					messageBoard_2.setText("Please choose an item");
				}else {
					try {
						if (listChoice == "Absence") {
							Controller_2.updateAbsence(dataModelTask2);
						}else if (listChoice == "Portal Setup") {
							Controller_2.updatePortalSetup(dataModelTask2);
						}else if (listChoice == "Qualification") {
							Controller_2.updateQualification(dataModelTask2);
						}else if (listChoice == "Relative") {
							Controller_2.updateRelatives(dataModelTask2);
						}else if (listChoice == "Statistics Group") {
							Controller_2.updateStatisticsGroup(dataModelTask2);
						}
						
					}catch (SQLException sql) {
						messageBoard_2.setText(ErrorHandling.getMessageForErrorCode(sql.getErrorCode(), ""));
					}
				}
				
			}
		});
		btnShowInformation.setBounds(124, 41, 146, 33);
		panel_3.add(btnShowInformation);
		
		
		String[] tables2 = {"", "Employee", "All Indexes", "All Keys", "All Table Constraints", "Most Rows", "All Tables 1", "All Columns 1", "All Tables 2", "All Columns 2"};
		
		JComboBox tables_list2 = new JComboBox(tables2);
		tables_list2.setBounds(297, 41, 130, 33);
		tables_list2.setSelectedItem(tables2);
		panel_3.add(tables_list2);
		
		
		
		JButton btnShowMetadata = new JButton("Show metadata");
		btnShowMetadata.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String listChoice = (String) tables_list2.getSelectedItem();
				dataModelTask2.setRowCount(0);
				if (listChoice == "") {
					messageBoard_2.setText("Please choose an item");
				}else {
					try  {
						if (listChoice == "Employee") {
							Controller_2.updateEmployeeMetaData(dataModelTask2, "");
						}else if (listChoice == "All Indexes") {
							Controller_2.updateIndexes(dataModelTask2);
						}else if (listChoice == "All Keys") {
							Controller_2.updateAllKeys(dataModelTask2);
						}else if (listChoice == "All Table Constraints") {
							Controller_2.updateConstraints(dataModelTask2);
						}else if (listChoice == "Most Rows") {
							Controller_2.updateTableNameMostRows(dataModelTask2);
						}else if (listChoice == "All Tables 1") {
							Controller_2.updateTables(dataModelTask2);
						}else if (listChoice == "All Columns 1") {
							Controller_2.updateColumns(dataModelTask2);
						}else if (listChoice == "All Tables 2") {
							Controller_2.updateTables2(dataModelTask2);
						}else if (listChoice == "All Columns 2") {
							Controller_2.updateColumns2(dataModelTask2);
						}
				
					}catch (SQLException sql) {
						messageBoard_2.setText(ErrorHandling.getMessageForErrorCode(sql.getErrorCode(), ""));
					}
				}
				
			}
		});
		btnShowMetadata.setBounds(450, 41, 130, 33);
		panel_3.add(btnShowMetadata);
		
		
		
		
		
		
		JLabel lblResults_3 = new JLabel("Results");
		lblResults_3.setBounds(10, 95, 46, 14);
		panel_3.add(lblResults_3);
		
		JLabel lblMessageBoard_3 = new JLabel("Message Board");
		lblMessageBoard_3.setBounds(10, 401, 95, 14);
		panel_3.add(lblMessageBoard_3);
		
		JLabel lblChosseAnItem = new JLabel("Choose an item from any of the lists below");
		lblChosseAnItem.setBounds(10, 16, 260, 14);
		panel_3.add(lblChosseAnItem);
		
		JTabbedPane tabbedPane_6 = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.addTab("Uppgift 3", null, tabbedPane_6, null);
		
		JPanel panel_4 = new JPanel();
		tabbedPane_6.addTab("", null, panel_4, null);
		panel_4.setLayout(null);
		
		JTextArea messageBoard_3 = new JTextArea();
		messageBoard_3.setBounds(54, 445, 503, 60);
		panel_4.add(messageBoard_3);
		
		ImageIcon excelImg = new ImageIcon("C:\\Users\\Administrator\\eclipse-workspace\\database-programming\\src\\icon\\excel.png");
		ImageIcon accessImg = new ImageIcon("C:\\Users\\Administrator\\eclipse-workspace\\database-programming\\src\\icon\\access.png");
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(54, 69, 503, 28);
		comboBox.addItem("");
		comboBox.addItem("Question 1: How much is 100 NOK?");
		comboBox.addItem("Question 2: What value is traded for the most amount of SEK?");
		comboBox.addItem("Question 3: At which address and city is Fotograferna AB located?");
		comboBox.addItem("Question 4: Names of all employees who have been sick");
		comboBox.addItem("Question 5: Name and family relation of all employees");
		comboBox.addItem("Question 6: What customers is handled by Andreas Berglund?");
		comboBox.addItem("Question 7: What bank accounts belong to the customer with number 10000?");
		panel_4.add(comboBox);
		
		JButton btnExcel = new JButton("Excel");
		btnExcel.setBounds(54, 197, 161, 111);
		btnExcel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int index = comboBox.getSelectedIndex();
				String name ="Book" + (index) + ".xlsx";
				messageBoard_3.setText("");
				try {
					Controller_3.openFile(name);
				}catch (Exception e) {
					messageBoard_3.setText("File does not exist");
				}
				
			}
		});
		btnExcel.setIcon(excelImg);
		panel_4.add(btnExcel);
		
		JButton btnAccess = new JButton("Access");
		btnAccess.setBounds(371, 197, 186, 111);
		btnAccess.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int index = comboBox.getSelectedIndex();
				String name = "Access" + (index) + ".accdb";
				messageBoard_3.setText("");
				
				try {
					Controller_3.openFile(name);
				}catch (Exception e) {
					
					messageBoard_3.setText("File does not exist");
					
				}
				
			}
		});
		btnAccess.setIcon(accessImg);
		panel_4.add(btnAccess);
		
		JLabel lblMessageBoard_4 = new JLabel("Message Board");
		lblMessageBoard_4.setBounds(54, 418, 124, 14);
		panel_4.add(lblMessageBoard_4);
		
		JLabel lblChooseAnItem = new JLabel("Choose an item from the list");
		lblChooseAnItem.setBounds(54, 42, 194, 14);
		panel_4.add(lblChooseAnItem);
		
		
		
		
		
		
	}
}

