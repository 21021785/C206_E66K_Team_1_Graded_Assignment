public class Student extends Subject{
	private int studentID;
	private String name;
	private char gender;
	private int mobile;
	private String dob;
	private String residence;
	private String interest; 
	private String feeedback;
	//burh
	//tests
	//bruh
	public Student (int studentID, String name, char gender, int mobile, String dob, String country, 
			String interest, String feedback) {
		this.studentID = studentID;
		this.name = name;
		this.gender = gender;
		this.mobile = mobile;
		this.dob = dob;
		this.residence = residence;
		this.interest = interest;
		this.feeedback = feedback;
	}

	public String getName() {
		return name;
	}

	public int getStudentID() {
		return studentID;
	}

	public void setStudentID(int studentID) {
		this.studentID = studentID;
	}

	public void setName(String name) {
		this.name = name;
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	public int  getMobile() {
		return mobile;
	}

	public void setMobile(int mobile) {
		this.mobile = mobile;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getResidence() {
		return residence;
	}

	public void setCountry(String residence) {
		this.residence = residence;
	}

	public String getInterest() {
		return interest;
	}

	public void setInterest(String interest) {
		this.interest = interest;
	}

	public String getFeeedback() {
		return feeedback;
	}

	public void setFeeedback(String feeedback) {
		this.feeedback = feeedback;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", gender=" + gender + ", mobile=" + mobile + ", dob=" + dob + ", residence="
				+ residence + ", interest=" + interest + ", feeedback=" + feeedback + "]";
	}
	
}


