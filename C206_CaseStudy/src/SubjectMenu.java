import java.util.ArrayList;

public class SubjectMenu {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ArrayList<Subject> subjectList = new ArrayList<Subject>();

		subjectList.add(new Subject("Subject001", "Math", "Min age 3"));
		subjectList.add(new Subject("Subject002", "Science", "Min age 7"));
		subjectList.add(new Subject("Subject003", "Coding", "Min age 14"));

		int option = 0;

		while (option != 5) {

			SubjectMenu.displaySubjectMenu();
			option = Helper.readInt("Enter an option > ");

			if (option == 1) {
				// View all items
				SubjectMenu.viewAllSubject(subjectList);

			} else if (option == 2) {
				// Add a Subject
				SubjectMenu.setHeader("ADD SUBJECT");

				Subject sj = inputSubject();
				SubjectMenu.addSubject(subjectList, sj);
				System.out.println("Subject added");

			}
			else if (option == 3) {
				// Return item
				SubjectMenu.setHeader("DELETE SUBJECT");	

				SubjectMenu.deleteSubject(subjectList);
				

			} else if (option == 4) {
				System.out.println("Bye!");
			} else {
				System.out.println("Invalid option");
			}

		}

	}

	public static void displaySubjectMenu() {
		Helper.line(40, "-");
		System.out.println("Subject MENU");
		Helper.line(40, "-");

		System.out.println("1. View all subjects");
		System.out.println("2. Add subject");
		System.out.println("3. Delete subject");
		System.out.println("4. Quit");
	}

	public static void setHeader(String header) {
		Helper.line(80, "-");
		System.out.println(header);
		Helper.line(80, "-");
	}

	
	// display all subject
	public static String retrieveAllSubject(ArrayList<Subject> subjectList) {
		String output = "";

		for (int i = 0; i < subjectList.size(); i++) {

			output += String.format("%-15s %-30s %-20s\n", subjectList.get(i).getName(),
					subjectList.get(i).getDescription(), subjectList.get(i).getPreRequisite());
		}
		return output;
	}

	public static void viewAllSubject(ArrayList<Subject> subjectList) {
		SubjectMenu.setHeader("SUBJECT LIST");
		String output = String.format("%-15s %-30s %-20s\n", "NAME", "DESCRIPTION", "PREREQUISITE");
		output += retrieveAllSubject(subjectList);
		System.out.println(output);
	}

	
	// add subject
	public static Subject inputSubject() {
		String name = Helper.readString("Enter name > ");
		String description = Helper.readString("Enter description > ");
		String preRequisite = Helper.readString("Enter pre-requisite > ");

		Subject sj = new Subject(name, description, preRequisite);
		return sj;
	}

	public static void addSubject(ArrayList<Subject> subjectList, Subject sj) {
		// write your code here

		subjectList.add(sj);

	}
	
	
	// delete subject
	public static boolean doDeleteSubject(ArrayList<Subject> subjectList, String name) {
		boolean isReturned = false;

		for (int i = 0; i < subjectList.size(); i++) {
			if (name.equalsIgnoreCase(subjectList.get(i).getName())) {
				subjectList.remove(i);
				isReturned = true;
				
			}
		}
		return isReturned;
		
	}
	public static void deleteSubject(ArrayList<Subject> subjectList) {
		SubjectMenu.viewAllSubject(subjectList);
		String name = Helper.readString("Enter name > ");
		Boolean isReturned = doDeleteSubject(subjectList, name);
		
		if (isReturned == false) {
			System.out.println("Invalid Name");
		} else {
			System.out.println("Subject " + name + " deleted");
		}
	}
}
