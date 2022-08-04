
public class Register {
	private String RegID;
	private String timetableID;
	private String email;
	private String status;
	private String RegDate;


public Register(String RegID, String timetableID, String email, String status, String RegDate) {
	this.RegID = RegID;
	this.timetableID = timetableID;
	this.email = email;
	this.status = status;
	this.RegDate = RegDate;	
}


public String getRegID() {
	return RegID;
}


public void setRegID(String regID) {
	RegID = regID;
}


public String getTimetableID() {
	return timetableID;
}


public void setTimetableID(String timetableID) {
	this.timetableID = timetableID;
}


public String getEmail() {
	return email;
}


public void setEmail(String email) {
	this.email = email;
}


public String getStatus() {
	return status;
}


public void setStatus(String status) {
	this.status = status;
}


public String getRegDate() {
	return RegDate;
}


public void setRegDate(String regDate) {
	RegDate = regDate;
}


@Override
public String toString() {
	return "Register [RegID=" + RegID + ", timetableID=" + timetableID + ", email=" + email + ", status=" + status
			+ ", RegDate=" + RegDate + "]";

}




}


