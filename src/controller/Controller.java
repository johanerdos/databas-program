package controller;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;

import dal.CourseDal;
import dal.StudentDal;
import errorCode.ErrorHandling;
import errorCode.ResponseTime;
import model.HasStudied;
import model.Student;
import model.Course;
import model.Studies;

public class Controller {
	
	static CourseDal cd = new CourseDal();
	static StudentDal sd = new StudentDal();
	static ErrorHandling eh = new ErrorHandling();
	static ResponseTime rt = new ResponseTime();
	
	public Controller() {
		
	}
	
	public static void addStudent (String ssn, String name, String email) throws SQLException {
		sd.addStudent(ssn, name, email);
	}
	
	public static Student findStudent(String ssn) throws SQLException {
		return sd.findStudent(ssn);
	}
	
	public static void removeStudent(String ssn) throws SQLException {
		sd.removeStudent(ssn);
	}
	
	public static void addCourse(String courseID, String courseName, int credits) throws SQLException {
		cd.addCourse(courseID, courseName, credits);
	}
	
	public static Course findCourse(String courseID) throws SQLException {
		return cd.findCourse(courseID);
	}
	
	public static void removeCourse(String courseID) throws SQLException {
		cd.removeCourse(courseID);
	}
	
	public static void addStudentToCourse(String ssn, String courseID) throws SQLException {
		sd.addStudentToCourse(ssn, courseID);
	}

	public static void removeStudentFromCourse(String ssn, String courseID) throws SQLException {
		sd.removeStudentFromCourse(ssn, courseID);
		
	}
	
	public static void addStudentToHasStudied(String ssn, String courseID, String grade) throws SQLException {
		sd.addStudentToHasStudied(ssn, courseID, grade);
	}
	
	//public static String generateGrade(String ssn, String courseID) throws SQLException {
		//return sd.generateGrade(ssn, courseID);
	//}
	
	public static ArrayList<HasStudied> showResult(String ssn, String courseID) throws SQLException {
		return sd.showResult(ssn, courseID);
	}
	
	public static ArrayList<HasStudied> showAllStudentResult (String courseID) throws SQLException {
		return sd.showAllStudentResult(courseID);
	}
	
	public static HashMap<String, String> getGradePercentage(String courseID) throws SQLException {
		return cd.getGradePercentage(courseID);
	}
	public static String result (ArrayList<String> test){
		return sd.result(test);
	}
	
	public static String cNotFound(String str) {
		return cd.courseNotFound(str);
	}

	public static String studentNotFound(String ssn) {
		return sd.studentNotFound(ssn);
	}

	public static ArrayList<HasStudied> showFailedStudents(String courseID) throws SQLException {
		return sd.showFailedStudents(courseID);
	}
	
	public static HashMap<String, String> getThroughput() throws SQLException {
		return cd.getThroughput();
	}

	public static Student findStudentStudying(String ssn) throws SQLException {
		return sd.findStudentStudying(ssn);
	}
	
	public static String getErrorMessage(int errorCode, String prefix) {
		return eh.getMessageForErrorCode(errorCode, prefix);
	}
	
	public static String responseTime() {
		return rt.responseTime();
	}
	

}
