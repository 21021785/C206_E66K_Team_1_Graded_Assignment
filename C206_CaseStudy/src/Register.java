
public class Register {
	private String RegID;
	private String timetableID;
	private String email;
	private String status;
	private String RegDate;
	private String waitList;


public Register(String RegID, String timetableID, String email, String status, String RegDate, String waitList) {
	this.RegID = RegID;
	this.timetableID = timetableID;
	this.email = email;
	this.status = status;
	this.RegDate = RegDate;	
	this.waitList = waitList;
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

public void setWaitList(String waitList) {
	this.waitList = waitList;
}

public String getWaitList() {
	return waitList;
}


@Override
public String toString() {
	String output=  String.format("%-10s %-20s %-20s %-10s %-20s %-10s\n", getRegID(), getTimetableID(),
			getEmail(), getStatus(),getRegDate(), getWaitList());;
	return output;
	//minxi
}




}


