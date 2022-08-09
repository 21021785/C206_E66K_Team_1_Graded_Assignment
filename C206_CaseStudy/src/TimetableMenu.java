import java.util.ArrayList;

public class TimetableMenu {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ArrayList<Timetable> timetableList = new ArrayList<Timetable>();

		timetableList.add(new Timetable("1", 250.00, "01/01/2022", "1400", "01/06/2022", "1600", "Face to face"));
		timetableList.add(new Timetable("2", 300.00, "01/07/2022", "1600", "01/10/2022", "1800", "Online"));
		
		int option = 0;

		while (option != 4) {

			TimetableMenu.menu();
			option = Helper.readInt("Enter an option > ");

			if (option == 1) {
				// Add new timetable
				Timetable tt = inputTimetable();
				TimetableMenu.addTimetable(timetableList, tt);
				System.out.println("New timetable added");

			} else if (option == 2) {
				// View timetable
				TimetableMenu.viewAllTimetable(timetableList);
				
			} else if (option == 3) {
				// Delete timetable
				TimetableMenu.deleteTimetable(timetableList);
				}
			}

	}
	
	public static void menu() {
		TimetableMenu.setHeader("TIMETABLE");
		System.out.println("1. Add Tuition Timetable");
		System.out.println("2. View Tuition Timetable");
		System.out.println("3. Delete Tuition Timetable");
		System.out.println("4. Quit");
		Helper.line(80, "-");

	}
	
	public static void setHeader(String header) {
		Helper.line(80, "-");
		System.out.println(header);
		Helper.line(80, "-");
	}
	
	
	//Add
	public static Timetable inputTimetable() {
		String ID = Helper.readString("Enter ID > ");
		double price = Helper.readDouble("Enter price > ");
		String startDate = Helper.readString("Enter starting date > ");
		String startTime = Helper.readString("Enter starting time > ");
		String endDate = Helper.readString("Enter ending date > ");
		String endTime = Helper.readString("Enter ending time > ");
		String mode = Helper.readString("Enter mode > ");

		Timetable tt= new Timetable(ID, price, startDate, startTime, endDate, endTime, mode);
		return tt;
		
	}
	public static void addTimetable(ArrayList<Timetable> timetableList, Timetable tt) {
		
		timetableList.add(tt);
		
	}
	
	
	//View
	public static String retrieveAllTimetable(ArrayList<Timetable> timetableList) {
		String output = "";

		for (int i = 0; i < timetableList.size(); i++) {

			output += String.format("%-10s %-10.2f %-15s %-15s %-15s %-10s %-10s\n", timetableList.get(i).getTimetableID(),
					timetableList.get(i).getPrice(),
					timetableList.get(i).getStartDate(),
					timetableList.get(i).getStartTime(),
					timetableList.get(i).getEndDate(),
					timetableList.get(i).getEndTime(),
					timetableList.get(i).getMode());
		}
		return output;
	}
	public static void viewAllTimetable(ArrayList<Timetable> timetableList) {
		TimetableMenu.setHeader("TIMETABLE LIST");
		String output = String.format("%-10s %-10s %-15s %-15s %-15s %-10s %-10s\n", "ID", "Price",
				"Start Date", "Start Time", "End Date", "End Time", "Mode");
		 output += retrieveAllTimetable(timetableList);	
		System.out.println(output);
	}
	
	//Delete
	public static void deleteTimetable(ArrayList<Timetable> timetableList) {
		TimetableMenu.viewAllTimetable(timetableList);
		String ID = Helper.readString("Enter ID > ");
		TimetableMenu.doDeleteTimetable(timetableList, ID);
		
	}
	
	
	//Perform the delete
	public static void doDeleteTimetable(ArrayList<Timetable> timetableList, String ID) {
		boolean exists = false;

		for (int i = 0; i < timetableList.size(); i++) {
			if (ID.equalsIgnoreCase(timetableList.get(i).getTimetableID())) {
				exists = true;
			}
		}

		if (exists == true) {
			for (int i = 0; i < timetableList.size(); i++) {
				if (ID.equalsIgnoreCase(timetableList.get(i).getTimetableID())) {
					timetableList.remove(i);
					break;
				}
			}
			System.out.println("Timetable with ID " + ID + " has been successfully removed.");
		} else {
			System.out.println("Timetable removal failed, please check that a correct ID has been inputted.");
		}
		
	}

}
