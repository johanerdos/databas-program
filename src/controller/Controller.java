package controller;

import java.sql.*;


import dal.CourseDal;
import dal.StudentDal;
import model.HasStudied;
import model.Student;
import model.Course;
import model.Studies;

public class Controller {
	
	static CourseDal cd = new CourseDal();
	static StudentDal sd = new StudentDal();
	
	public Controller() {
		
	}
	
	public static void addStudent (String ssn, String name, String email) throws SQLException {
		sd.addStudent(ssn, name, email);
	}
	
	public static Student findStudent(String ssn) throws SQLException {
		return sd.findStudent(ssn);
	}
	
	public void removeStudent(String ssn) throws SQLException {
		sd.removeStudent(ssn);
	}
	
	public static void addCourse(String courseID, String courseName, int credits) throws SQLException {
		cd.addCourse(courseID, courseName, credits);
	}
	
	public static Course findCourse(String courseID) throws SQLException {
		return cd.findCourse(courseID);
	}
	
	

}
