/*
 * I declare that this code was written by me. 
 * I do not copy or allow others to copy my code. 
 * I understand that copying code is considered as plagiarism.
 * 
 * Student Name: sbuff
 * Student ID: {type your id here}
 * Class: {type your class here}
 * Date/Time created: Saturday 06-08-2022 00:58
 */

/**
 * @author sbuff
 *
 */
public class Student {
		private int studentID;
		private String name;
		private char gender;
		private int mobile;
		private String dob;
		private String residence;
		
		public Student (String name, char gender, int mobile, String dob, String residence) {
			this.name = name;
			this.gender = gender;
			this.mobile = mobile;
			this.dob = dob;
			this.residence = residence;

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

		public int getMobile() {
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
		
		@Override
		public String toString() {
			return "Student [name=" + name + ", gender=" + gender + ", mobile=" + mobile + ", dob=" + dob + ", residence="
					+ residence + "]";
		}
		
	}
