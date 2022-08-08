import java.util.ArrayList;

public class SubjectMenu {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ArrayList<Subject> subjectList = new ArrayList<Subject>();

		subjectList.add(new Subject("Subject001", "Math", "Min age 3"));
		subjectList.add(new Subject("Subject002", "Science", "Min age 7"));
		subjectList.add(new Subject("Subject003", "Coding", "Min age 14"));

		
		ArrayList<Teacher> teacherList = new ArrayList<Teacher>();

		teacherList.add(new Teacher("Teacher001", "Justin", "Male", "justin@email.com", "Math,English", "Math"));
		teacherList.add(new Teacher("Teacher002", "Min Xi", "Female", "minxi@email.com", "Math,Sch", "Math"));
		teacherList.add(new Teacher("Teacher003", "YongLer", "Male", "yongler@email.com", "Com,English", "Math"));

		
		
		int option = 0;

		while (option != 3) {
			
			SubjectMenu.menu();
			option = Helper.readInt("Enter an option > ");

			if(option == 1) {
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

				} else if (option == 3) {
					// Return item
					SubjectMenu.setHeader("DELETE SUBJECT");	

					SubjectMenu.deleteSubject(subjectList);
					
				} 
			}
			else if(option == 2) {
				SubjectMenu.displayTeacherMenu();
				option = Helper.readInt("Enter an option > ");

				if (option == 1) {
					// View all items
					SubjectMenu.viewAllTeacher(teacherList);

					SubjectMenu.searchTeacher(teacherList);

				} else if (option == 2) {
					// Assign Teacher
					SubjectMenu.setHeader("Assign teacher");
					
					SubjectMenu.assignTeacher(teacherList,subjectList);
					
				}
			}
			else if (option == 3) {
				System.out.println("Bye!");
			} else {
				System.out.println("Invalid option");
			}

		}

	}

	public static void menu() {
		Helper.line(40, "-");
		System.out.println("MENU");
		Helper.line(40, "-");

		System.out.println("1. Subject Menu");
		System.out.println("2. Teacher Menu");
		System.out.println("3. Quit");
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

	public static void displayTeacherMenu() {
		Helper.line(40, "-");
		System.out.println("Teacher MENU");
		Helper.line(40, "-");

		System.out.println("1. View all and Search teachers");
		System.out.println("2. Assign teacher to subject group");
		System.out.println("3. Quit");
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

	// TeacherMenu.java

	// ================================= Option 1 View (CRUD - Read)
	// =================================
	public static String retrieveAllTeacher(ArrayList<Teacher> teacherList) {
		String output = "";

		for (int i = 0; i < teacherList.size(); i++) {

			output += String.format("%-15s %-15s %-20s %-10s %-25s %-20s\n", teacherList.get(i).getSubjectGroup(),
					teacherList.get(i).getTeacherID(), teacherList.get(i).getTeacherName(),
					teacherList.get(i).getTeacherGender(), teacherList.get(i).getTeacherEmail(),
					teacherList.get(i).getTeacherQualification());
		}
		return output;
	}

	public static void viewAllTeacher(ArrayList<Teacher> teacherList) {
		SubjectMenu.setHeader("Teacher LIST");
		String output = String.format("%-15s %-15s %-20s %-10s %-25s %-20s\n", "SubjectGroup", "Teacher Id", "Name",
				"Gender", "Email", "Qualification");
		output += retrieveAllTeacher(teacherList);
		System.out.println(output);
	}

	public static String retrieveAllSubjectDesc(ArrayList<Subject> subjectList) {
		String output = "";

		for (int i = 0; i < subjectList.size(); i++) {

			output += String.format("%-30s\n", subjectList.get(i).getDescription());
		}
		return output;
	}

	public static void viewAllSubjectDesc(ArrayList<Subject> subjectList) {
		SubjectMenu.setHeader("SUBJECT LIST");
		String output = String.format("%-30s\n", "Subjects");
		output += retrieveAllSubjectDesc(subjectList);
		System.out.println(output);
	}

	// ================================= Option 2 Assign (CURD- Update)
	// =================================
	public static boolean doAssignTeacher(ArrayList<Teacher> teacherList, String id, String subjectGroup) {

		boolean isAssigned = false;

		for (int i = 0; i < teacherList.size(); i++) {

			String teacherId = teacherList.get(i).getTeacherID();

			if (id.equalsIgnoreCase(teacherId)) {

				teacherList.get(i).setSubjectGroup(subjectGroup);

				isAssigned = true;

			}
		}
		return isAssigned;
	}

	public static void assignTeacher(ArrayList<Teacher> teacherList, ArrayList<Subject> subjectList) {
		SubjectMenu.viewAllTeacher(teacherList);
		String id = Helper.readString("Enter teacher id > ");
		SubjectMenu.viewAllSubjectDesc(subjectList);
		String subject = Helper.readString("Enter subject group > ");
		Boolean isAssigned = doAssignTeacher(teacherList, id, subject);
		if (isAssigned == false) {
			System.out.println("Invalid teacher Id");
		} else {
			System.out.println("Teacher " + id + " have assigned a subject");
		}
	}

	// ================================= Option 3 Search Teacher (CRUD -
	// search)=================================
	public static boolean doSearchTeacher(ArrayList<Teacher> teacherList, String id) {
		boolean isSearched = false;
		String output = String.format("%-15s %-15s %-20s %-10s %-25s %-20s\n", "SubjectGroup", "Id", "Name", "Gender",
				"Email", "Qualification");

		for (int i = 0; i < teacherList.size(); i++) {
			if (id.equalsIgnoreCase(teacherList.get(i).getTeacherID())) {

				output += String.format("%-15s %-15s %-20s %-10s %-25s %-20s\n", teacherList.get(i).getSubjectGroup(),
						teacherList.get(i).getTeacherID(), teacherList.get(i).getTeacherName(),
						teacherList.get(i).getTeacherGender(), teacherList.get(i).getTeacherEmail(),
						teacherList.get(i).getTeacherQualification());
				isSearched = true;
				System.out.print(output);
			}
		}
		return isSearched;

	}

	public static void searchTeacher(ArrayList<Teacher> teacherList) {
		SubjectMenu.viewAllTeacher(teacherList);
		String id = Helper.readString("Enter teacher id > ");
		Boolean isSearched = doSearchTeacher(teacherList, id);

		if (isSearched == false) {
			System.out.println("Invalid teacher id");
		} else {
			System.out.println("");
		}
	}

}
