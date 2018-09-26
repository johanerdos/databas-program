package model;

public class Studies {
	private String ssn;
	private String courseID;
	
	public Studies (String ssn, String courseID) {
		this.ssn = ssn;
		this.courseID = courseID;
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

}
