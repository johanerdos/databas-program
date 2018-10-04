
package dal;

import java.sql.*;
import java.util.ArrayList;
import java.util.Random;

import model.Course;
import model.Studies;
import databaseConnection.DBConnection;
import model.Student;
import model.HasStudied;

public class StudentDal {
	
	private Connection conn = null;
	private PreparedStatement ps = null;
	Course course = new Course(null, null, 0);
	CourseDal c = new CourseDal();
	
	
	// startar connection, kör preparedStatement sedan hämtar resultSet
	private ResultSet runExecuteQuery(String sqlString) throws SQLException {
		conn = DBConnection.getConnection();
		ps = conn.prepareStatement(sqlString);
		ResultSet rs = ps.executeQuery();
		return rs;
	}
	// startar connection, kör preparedStatement sedan uppdaterar databasen
	private void runExecuteUpdate (String sqlString) throws SQLException {
		conn = DBConnection.getConnection();
		ps = conn.prepareStatement(sqlString);
		ps.executeUpdate();
	}
	// lägger till student
	public void addStudent(String ssn, String name, String email) throws SQLException {
		
		String sqlString = "INSERT INTO Student VALUES( '" + ssn + "', '" + name + "', '" + email + "');";
		runExecuteUpdate(sqlString);
		conn.close();
	}
	// hittar student och dess info
	public Student findStudent(String ssn) throws SQLException {
		Student st;
		String sqlString = "SELECT * FROM Student WHERE ssn = '" + ssn + "'";
		ResultSet rs = runExecuteQuery(sqlString);
		if (rs.next()) {
			ssn = rs.getString(1);
			String name = rs.getString(2);
			String email = rs.getString(3);
			st = new Student(ssn, name, email);
			conn.close();
			return st;
		}
		return null;
		
		
	}
//hämtar en student och dess resultat från en kurs
	public HasStudied showResultForStudent(String ssn, String courseID, String grade) throws SQLException {
		HasStudied s = null;
		String sqlString = "SELECT * FROM HasStudied WHERE courseID = ' " + courseID + "' AND ssn = '" + ssn + "';";
		ResultSet rs = runExecuteQuery(sqlString);
		if (rs.next()) {
		    ssn = rs.getString(1);
		    courseID = rs.getString(2);
		    grade = rs.getString(3);
		    s = new HasStudied (ssn, courseID, grade);
		}
		conn.close();
		return s;
		    
			
		}
	
	public ArrayList<HasStudied> showResult(String ssn, String courseID) throws SQLException {
		ArrayList<HasStudied> showResultList = new ArrayList<HasStudied>();
		String sqlString = "SELECT * FROM HasStudied WHERE ssn = '" + ssn + "' AND courseID = '" + courseID + "';";
		ResultSet rs = runExecuteQuery(sqlString);
		while (rs.next()) {
			String social = rs.getString(1);
			String cID = rs.getString(2);
			String grade = rs.getString(3);
			HasStudied hs = new HasStudied(social, cID, grade);
			showResultList.add(hs);
		}
		conn.close();
		return showResultList;
	}
	//bortagning av student
	public void removeStudent(String ssn) throws SQLException {
		
		String sqlString = "DELETE FROM Student WHERE ssn = '" + ssn + "';";
		runExecuteUpdate(sqlString);
		conn.close();
	
	}
	//bortagning av student från en kurs (studies)
	public void removeStudentFromCourse (String ssn, String courseID) throws SQLException {
		String sqlString = "DELETE FROM Studies WHERE ssn = '" + ssn + "' AND courseID = '" + courseID + "';";
		runExecuteUpdate(sqlString);
		conn.close();
	}
	
	//Hämtar alla credits hos en viss student
	
	public int getAllCredits (String ssn) throws SQLException {
		String sqlString = "SELECT credits FROM Studies WHERE ssn = '" + ssn + "';";
		ResultSet rs = runExecuteQuery(sqlString);
		rs.next();
		int totalCredits = rs.getInt(1);
		return totalCredits;
	}
	
	
	//Måste fixa det med att man bara kan läsa max 45 credits/termin.
	public void addStudentToCourse(String ssn, String courseID) throws SQLException {
		//int cred = getAllCredits(ssn);
		int cred = 15;
		
		if (cred <= 45) {
			String sqlString = "INSERT INTO Studies VALUES ('" + ssn + "', '" + courseID + "', '" + cred + "');";
			runExecuteUpdate(sqlString);
			
		}else {
			throw new SQLException();
		}
		conn.close();
		
	}
	public void addStudentToHasStudied(String ssn, String courseID, String grade) throws SQLException {
		String sqlString = "INSERT INTO HasStudied VALUES ('" + ssn + "', '" + courseID + "', '" + grade + "');";
		runExecuteUpdate(sqlString);
		conn.close();
		
	}
	
	public ArrayList<HasStudied> showAllStudentResult(String courseID) throws SQLException {
		ArrayList<HasStudied> studentResults = new ArrayList<HasStudied>();
		String sqlString = "SELECT * FROM HasStudied WHERE courseID = '" + courseID + "';";
		ResultSet rs = runExecuteQuery(sqlString);
		while (rs.next()) {
			String ssn = rs.getString(1);
			courseID = rs.getString(2);
			String grade = rs.getString(3);
			HasStudied hs = new HasStudied(ssn, courseID, grade);
			studentResults.add(hs);
		}
		conn.close();
		return studentResults;
	}
	
	public String result(ArrayList<String> test) {
		String str = null;
		for(int i = 0; i < test.size(); i++) {
			str = str + test.get(i).toString() + "\n";
		}
		return str;
		
	}
	
	public String studentNotFound(String str) {
		String sNotExistMessage = "The student does not exist";
		return sNotExistMessage;
	}
	
	public ArrayList<HasStudied> showFailedStudents(String courseID) throws SQLException {
		String gradeTmp = "U";
		ArrayList<HasStudied> failedStudents = new ArrayList<HasStudied>();
		String sqlString = "SELECT * FROM HasStudied WHERE grade = '" + gradeTmp + "';";
		ResultSet rs = runExecuteQuery(sqlString);
		while (rs.next()) {
			String ssn = rs.getString(1);
			courseID = rs.getString(2);
			String grade = rs.getString(3);
			HasStudied hs = new HasStudied(ssn, courseID, grade);
			failedStudents.add(hs);
		}
		conn.close();
		return failedStudents;
	}
	
	public ArrayList<HasStudied> showThroughput(String courseID) throws SQLException {
		String gradeTmp = "U";
		ArrayList<HasStudied> throughput = new ArrayList<HasStudied>();
		String sqlString = "SELECT * FROM HasStudied WHERE grade != '" + gradeTmp + "';";
		ResultSet rs = runExecuteQuery(sqlString);
		while (rs.next()) {
			String courseName = rs.getString(1);
			courseID = rs.getString(2);
			String credits = rs.getString(3);
			HasStudied hs = new HasStudied(courseID, courseName, credits);
			throughput.add(hs);
		}
		conn.close();
		return throughput;
	}
	
	public Student findStudentStudying(String ssn) throws SQLException {
		Student st;
		String sqlString = "SELECT * FROM Studies WHERE ssn = '" + ssn + "';";
		ResultSet rs = runExecuteQuery(sqlString);
		if (rs.next()) {
			ssn = rs.getString(1);
			String name = rs.getString(2);
			String email = rs.getString(3);
			st = new Student(ssn, name, email);
			conn.close();
			return st;
		}
		return null;
	}
	
}