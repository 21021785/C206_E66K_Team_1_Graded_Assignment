public class Teacher{
	private String teacherID;
	private String teacherName;
	private String teacherGender;
	private String teacherEmail;
	private String teacherQualification;
	private String subjectGroup;
	
	public Teacher(String teacherID, String teacherName, String teacherGender, String teacherEmail, String teacherQualification, String subject) {
		// super(name, description, preRequisite);
		this.teacherID = teacherID;
		this.teacherName = teacherName;
		this.teacherGender = teacherGender;
		this.teacherEmail = teacherEmail;
		this.teacherQualification = teacherQualification;
		this.subjectGroup = subject;
	}

	public String getTeacherName() {
		return teacherName;
	}

	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}

	public String getTeacherID() {
		return teacherID;
	}

	public void setTeacherID(String teacherID) {
		this.teacherID = teacherID;
	}

	public String getTeacherGender() {
		return teacherGender;
	}

	public void setTeacherGender(String teacherGender) {
		this.teacherGender = teacherGender;
	}

	public String getTeacherEmail() {
		return teacherEmail;
	}

	public void setTeacherEmail(String teacherEmail) {
		this.teacherEmail = teacherEmail;
	}

	public String getTeacherQualification() {
		return teacherQualification;
	}

	public void setTeacherQualification(String teacherQualification) {
		this.teacherQualification = teacherQualification;
	}

	public String getSubjectGroup() {
		return subjectGroup;
	}

	public void setSubjectGroup(String subject) {
		this.subjectGroup = subject;
	}
}

