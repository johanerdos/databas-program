package model;

public class Student {
	
	private String ssn;
	private String name;
	private String email;
	
	public Student(String ssn, String name, String email) {
		this.ssn = ssn;
		this.name = name;
		this.email = email;
	}

	public String getSsn() {
		return ssn;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
		
}
