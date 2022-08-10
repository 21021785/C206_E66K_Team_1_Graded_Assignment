import java.util.ArrayList;

public class TuitionMenu {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ArrayList<Tuition> tuitionList = new ArrayList<Tuition>();
		
		tuitionList.add(new Tuition("001", "Math Tuition", "Math", "Includes A-math, E-math etc", 4.0, "Min Age 13", "Low Jun Jie", "Math Tuition"));
		tuitionList.add(new Tuition("002", "Science Tuition", "Science", "Includes Bio, physics and Chemistry", 6.0, "Min Age 13", "Tan Wen Xiong", "Science Tuition"));
		tuitionList.add(new Tuition("003", "Coding Tuition", "Coding", "Includes C++, python and Java", 5.0, "Min Age 15", "John Pang", ""));
		
		int option = 0;

		while (option != 4) {

			TuitionMenu.displayTuitionMenu();
			option = Helper.readInt("Enter an option > ");

			if (option == 1) {
				// View all items
				TuitionMenu.viewAllTuition(tuitionList);

			} else if (option == 2) {
				// Add a Subject
				TuitionMenu.setHeader("ADD TUITION");

				Tuition tt = inputTuition();
				TuitionMenu.addTuition(tuitionList, tt);
				System.out.println("Tuition added");

			}
			else if (option == 3) {
				// Return item
				TuitionMenu.setHeader("DELETE TUITION");	

				
				TuitionMenu.deleteTuition(tuitionList);
				

			} else if (option == 4) {
				System.out.println("Bye!");
			} else {
				System.out.println("Invalid option");
			}

		}
		
	}
	
	

	public static void displayTuitionMenu() {
		Helper.line(160, "=");
		System.out.println("TUITION MENU");
		Helper.line(160, "=");

		System.out.println("1. View all tuitions");
		System.out.println("2. Add tuition");
		System.out.println("3. Delete tuition");
		System.out.println("4. Quit");
	}
	
	public static void setHeader(String header) {
		Helper.line(160, "=");
		System.out.println(header);
		Helper.line(160, "=");
	}
	
	public static Tuition inputTuition() {
		String code = Helper.readString("Enter Tuition Code > ");
		String title = Helper.readString("Enter Tuition Title > ");
		String subject = Helper.readString("Enter Tuition Subject > ");
		String description = Helper.readString("Enter Tuition Description > ");
		double duration = Helper.readDouble("Enter Tuition Duration (Hours) > ");
		String preReq = Helper.readString("Enter Tuition Pre Requisites > ");
		String teacher = Helper.readString("Enter Tuition Teacher > ");
		String tuition = Helper.readString("Enter Tuition > ");

		Tuition tt= new Tuition(code, title, subject, description, duration, preReq, teacher, tuition);
		return tt;
		
	}
	
	public static void addTuition(ArrayList<Tuition> tuitionList, Tuition tt) {
		
		tuitionList.add(tt);
		
	}
	
	public static String retrieveAllTuition(ArrayList<Tuition> tuitionList) {
		String output = "";
		
		for (int i = 0; i < tuitionList.size(); i++) {
			
			output += String.format("%-15s %-20s %-10s %-40s %-20f %-15s %-5s \n",  tuitionList.get(i).getCode(), tuitionList.get(i).getTitle(), tuitionList.get(i).getSubject(), 
					tuitionList.get(i).getDescription(), tuitionList.get(i).getDuration(), tuitionList.get(i).getPreReq(), tuitionList.get(i).getTeacher());
		}
		return output;
	}
	
	public static void viewAllTuition(ArrayList<Tuition> tuitionList) {
		
		TuitionMenu.setHeader("TUITION LIST");
		String output = String.format("%-15s %-20s %-10s %-40s %-20s %-15s %-5s \n", "TUITION CODE", "DESCRIPTION",
				 "SUBJECT", "DESCRIPTION","DURATION (Hours)","PRE REQUISITES","TEACHER");
		Helper.line(160, "=");
		 output += retrieveAllTuition(tuitionList);
		System.out.println(output);
	}
	
	public static boolean doDeleteTuition(ArrayList<Tuition> tuitionList, String code) {
		boolean isReturned = false;

		for (int i = 0; i < tuitionList.size(); i++) {
			if (code.equalsIgnoreCase(tuitionList.get(i).getCode())) {
				tuitionList.remove(i);
				isReturned = true;
				
			}
		}
		return isReturned;
		
	}
	
	public static void deleteTuition(ArrayList<Tuition> tuitionList) {
		TuitionMenu.viewAllTuition(tuitionList);
		String delTuition = Helper.readString("Enter Tuition code > ");
		Boolean isReturned = doDeleteTuition(tuitionList, delTuition);
		if (isReturned == false) {
			System.out.println("Invalid Tuition Code");
		} else {
			System.out.println("Tuition " + delTuition + " deleted");
		}
	}
	//aj
}
