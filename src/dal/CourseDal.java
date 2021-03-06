package dal;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;

import databaseConnection.DBConnection;
import model.Course;

public class CourseDal {
	private Connection conn = null;
	private PreparedStatement ps = null;
	
	public CourseDal() {     
	
	}
	
	//Start connection
	private ResultSet runExecuteQuery(String sqlString) throws SQLException {
		conn = DBConnection.getConnection();
		ps = conn.prepareStatement(sqlString);
		ResultSet rs = ps.executeQuery();
		return rs;
	}

	//Start connection, run ps and executeUpdate
	public void runExecuteUpdate(String sqlString) throws SQLException {
		conn = DBConnection.getConnection();
		ps = conn.prepareStatement(sqlString);
		ps.executeUpdate();
	}


	//Find a course
	public Course findCourse(String courseID) throws SQLException {
		String sqlString = "SELECT * FROM Course WHERE courseID = '" + courseID + "';";
		ResultSet rs = runExecuteQuery(sqlString);
		if (rs.next()) {
			courseID = rs.getString(1);
			String courseName = rs.getString(2);
			int credits = rs.getInt(3);
			Course c = new Course(courseID, courseName, credits);
			ps.close();
			conn.close();      
			return c;
		
		}
		return null;
	}


	//Add new course
	public void addCourse(String courseID, String courseName, int credits) throws SQLException{
		String sqlString = "INSERT INTO Course VALUES ( '" + courseID + "', '" + courseName + "', " + credits + ");";
		runExecuteUpdate(sqlString);
		conn.close();
	}

	//Remove course
	public void removeCourse(String courseID) throws SQLException {
		String sqlString = "DELETE FROM Course WHERE courseID ='" + courseID + "';";
		runExecuteUpdate(sqlString);
		ps.close();
		conn.close();
	}

	//retrieve all courses
	public ArrayList<Course> getAllCourses() throws SQLException {
		ArrayList<Course> allCourses = new ArrayList<Course>();
		String sqlString = "SELECT * FROM Course";
	
		ResultSet rs = runExecuteQuery(sqlString);
		while (rs.next()) {
			String courseID = rs.getString(1);
			String courseName = rs.getString(2);
			int credit = rs.getInt(3);
			Course c = new Course(courseID, courseName, credit);
			allCourses.add(c);
		}
		ps.close();
		conn.close();
		return allCourses;
	}

	//retrieve grades for a certain course
	public HashMap<String, String> getGradePercentage(String courseID) throws SQLException {
		HashMap<String, String> map = new HashMap<String, String>();
	
		String sqlString = "SELECT grade, (COUNT(grade)* 100 / (SELECT count(*) FROM HasStudied WHERE courseID ='" + courseID
			+ "')) AS 'percentage' FROM HasStudied WHERE courseID = '" + courseID + "' GROUP BY grade";

		ResultSet rs = runExecuteQuery(sqlString);
		while (rs.next()) {
			String grade = rs.getString(1);
			String percent = rs.getString(2);
			map.put(grade, percent);
		}
			ps.close();
			conn.close();
			return map;
		}


	//retrieve top 10 throughput
	public HashMap<String, String> getThroughput() throws SQLException {
		HashMap<String, String> map = new HashMap<String, String>();
	
		String sqlString = "SELECT TOP 10 UPPER(courseID) AS 'CourseID', (SUM(CASE WHEN grade != 'U' THEN 1 ELSE 0 END)*100) / COUNT (courseID) AS 'Percent Passed' "
			+ "FROM HasStudied " + "GROUP BY courseID " + "ORDER BY 'Percent Passed' DESC";

		ResultSet rs = runExecuteQuery(sqlString);
		while (rs.next()) {
			String courseID = rs.getString(1);
			String percent = rs.getString(2);
			map.put(courseID, percent);

		}
		return map;
	}

	public String courseNotFound(String str) {
		String cNotExists = "The course does not exist";
		return cNotExists;
	}


}
