
package dal;

import java.sql.*;
import model.Course;
import model.Studies;
import databaseConnection.DBConnection;
import model.Student;
import model.HasStudied;

public class StudentDal {
	
	private Connection conn = null;
	private PreparedStatement ps = null;
	
	CourseDal c = new CourseDal();
	// startar connection, k�r preparedStatement sedan h�mtar resultSet
	private ResultSet runExecuteQuery(String sqlString) throws SQLException {
		conn = DBConnection.getConnection();
		ps = conn.prepareStatement(sqlString);
		ResultSet rs = ps.executeQuery();
		return rs;
	}
	// startar connection, k�r preparedStatement sedan uppdaterar databasen
	private void runExecuteUpdate (String sqlString) throws SQLException {
		conn = DBConnection.getConnection();
		ps = conn.prepareStatement(sqlString);
		ps.executeUpdate();
	}
	// l�gger till student
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
//h�mtar en student och dess resultat fr�n en kurs
	public HasStudied getResultFromCourse(String ssn, String courseID,String grade) throws SQLException {
		HasStudied s = null;
		String sqlString = "select * from Studied where courseID = ' " + courseID + "' and ssn = '" + ssn + "';";
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
	//bortagning av student
	public void removeStudent(String ssn) throws SQLException {
		
		String sqlString = "DELETE FROM Student WHERE ssn = '" + ssn + "';";
		runExecuteUpdate(sqlString);
		conn.close();
	
	}
	//bortagning av student fr�n en kurs (studies)
	public void removeStudentStudies (String ssn, String courseID) throws SQLException {
		String sqlString = "DELETE FROM Studies WHERE ssn = '" + ssn + "' AND courseID = '" + courseID + "';";
		runExecuteUpdate(sqlString);
		conn.close();
	}
	//l�gger till en student till l�ser kurs, om de inte redan l�ser 45hp och inte
	//redan l�st kursen
	
	
	
	
}