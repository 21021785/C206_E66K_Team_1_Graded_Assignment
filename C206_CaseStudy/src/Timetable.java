
public class Timetable{
	private String timetableID;
	private double price; //Price of Tuition
	private String startDate;
	private String startTime;
	private String endDate;
	private String endTime;
	private String mode; //Physical or Online
	
	



	public Timetable(String timetableID, double price, String startDate, String startTime, String endDate, String endTime, String mode) {
		this.timetableID = timetableID;
		this.price = price;
		this.startDate = startDate;
		this.startTime = startTime;
		this.endDate = endDate;
		this.endTime = endTime;
		this.mode = mode;
	}


	public String getTimetableID() {
		return timetableID;
	}


	public void setTimetableID(String timetableID) {
		this.timetableID = timetableID;
	}


	public double getPrice() {
		return price;
	}


	public void setPrice(double price) {
		this.price = price;
	}


	public String getStartDate() {
		return startDate;
	}


	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}


	public String getStartTime() {
		return startTime;
	}


	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}


	public String getEndDate() {
		return endDate;
	}


	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}


	public String getEndTime() {
		return endTime;
	}


	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}


	public String getMode() {
		return mode;
	}


	public void setMode(String mode) {
		this.mode = mode;
	}
	
	
	
	
	
	

}
