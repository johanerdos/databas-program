package model;

import java.util.ArrayList;

public class HasStudied {
	private String ssn;
	private String courseID;
	private String grade;
	private ArrayList<HasStudied> showResult = new ArrayList<HasStudied>();
	
	
	public ArrayList<HasStudied> getShowResult() {
		return showResult;
	}

	public void setShowResult(ArrayList<HasStudied> showResult) {
		this.showResult = showResult;
	}

	public HasStudied (String ssn, String courseID, String grade) {
		this.ssn = ssn;
		this.courseID = courseID;
		this.grade = grade;
	}

	public String getSsn() {
		return ssn;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
	}

	public String getCourseID() {
		return courseID;
	}

	public void setCourseID(String courseID) {
		this.courseID = courseID;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}
	
	@Override
	public String toString() {
		return ssn + ", " + courseID + ", " + grade;
	}
}
