public class Student {
	private String name;
	private char gender;
	private String mobile;
	private String dob;
	private String residence;
	private String interest; 
	private String feeedback;
	
	public Student (String name, char gender, String mobile, String dob, String country, 
			String interest, String feedback) {
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

	public void setName(String name) {
		this.name = name;
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
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

