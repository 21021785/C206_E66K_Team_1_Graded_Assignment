/*
 * I declare that this code was written by me. 
 * I do not copy or allow others to copy my code. 
 * I understand that copying code is considered as plagiarism.
 * 
 * Student Name: sbuff
 * Student ID: {type your id here}
 * Class: {type your class here}
 * Date/Time created: Tuesday 09-08-2022 12:05
 */

/**
 * @author sbuff
 *
 */
import java.util.ArrayList;
public class StudentMenu {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ArrayList<Student> studentList = new ArrayList<Student>();
		
		studentList.add(new Student("Mary", 'F', 85674367, "12 February 2005", "Blk 985 Ang Mo Kio St 97 #07-983 794985"));
		studentList.add(new Student("John", 'M', 85674367, "12 February 2005", "Blk 493 Sengkang Ave 53 #03-09 345493"));
		
		int option = 0;

		while (option != 4) {

			StudentMenu.displayStudentMenu();
			option = Helper.readInt("Enter an option > ");

			if (option == 1) {
				// Add a Subject
				StudentMenu.setHeader("Register Account");

				Student st = inputStudent();
				StudentMenu.addStudent(studentList, st);
				System.out.println("Account Registered");


			} else if (option == 2) {
				// View all items
				for(int i = 0; i < studentList.size(); i++) {   
				    System.out.print(studentList.get(i));
				}
			}
			else if (option == 3) {
				// Return item
				StudentMenu.setHeader("Delete Account");	

				
				StudentMenu.deleteStudent(studentList);
				

			} else if (option == 4) {
				System.out.println("Quit");
			} else {
				System.out.println("Invalid option");
			}

		}
		
	}
	
	

	public static void displayStudentMenu() {
		Helper.line(160, "=");
		System.out.println("STUDENT MENU");
		Helper.line(160, "=");

		System.out.println("1. Register student account");
		System.out.println("2. View all student accounts");
		System.out.println("3. Delete student account");
		System.out.println("4. Quit");
	}
	
	public static void setHeader(String header) {
		Helper.line(160, "=");
		System.out.println(header);
		Helper.line(160, "=");
	}
	
	public static Student inputStudent() {
		String name = Helper.readString("Full name: ");
		char gender = Helper.readChar("Specify your gender(M/F): ");
		int mobile = Helper.readInt("Mobile number: ");
		String dob = Helper.readString("Date of birth(eg: 9 March 2002): ");
		String residence = Helper.readString("Address: ");

		Student st = new Student(name, gender, mobile, dob, residence);
		return st;
	}
	
	public static void addStudent(ArrayList<Student> studentList, Student st) {
		
		studentList.add(st);
		
	}
	
	public static String retrieveAllStudent(ArrayList<Student> studentList) {
		String output = "";
		
		for (int i = 0; i < studentList.size(); i++) {
			
			output += String.format("%-15s %1s %9s %-15s %-40s\n", studentList.get(i).getName(),
					studentList.get(i).getGender(), studentList.get(i).getMobile(), studentList.get(i).getDob(), studentList.get(i).getResidence());
		}
		return output;
	}
	
	public static void viewAllStudent(ArrayList<Student> studentList) {
		
		StudentMenu.setHeader("Student Account");
		String output = String.format("%-15s -%1s -%9s %-15s %-40s\n", "NAME", "GENDER", "MOBILE", "DOB", "RESIDENCE");
		output += retrieveAllStudent(studentList);
		System.out.println(output);
	}
	
	public static boolean doDeleteStudent(ArrayList<Student> studentList, String name) {
		boolean isReturned = false;

		for (int i = 0; i < studentList.size(); i++) {
			if (name.equalsIgnoreCase(studentList.get(i).getName())) {
				studentList.remove(i);
				isReturned = true;
				
			}
		}
		return isReturned;
		
	}
	
	public static void deleteStudent(ArrayList<Student> studentList) {
		StudentMenu.viewAllStudent(studentList);
		String name = Helper.readString("Enter name > ");
		Boolean isReturned = doDeleteStudent(studentList, name);
		if (isReturned == false) {
			System.out.println("Invalid Account");
		} else {
			System.out.println("Student account " + name + " deleted");
		}
	}
}

