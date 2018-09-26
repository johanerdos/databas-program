package model;

public class HasStudied {
	private String ssn;
	private String courseID;
	private String grade;
	
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
}
