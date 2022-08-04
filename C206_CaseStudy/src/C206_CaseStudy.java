import java.util.ArrayList;

public class C206_CaseStudy {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ArrayList<Student> studentList = new ArrayList<Student>();
		ArrayList<Teacher> teacherList = new ArrayList<Teacher>();
		ArrayList<Tuition> tuitionList = new ArrayList<Tuition>();
		
		studentList.add(new Student(1,"Susan", 'F',98763421,"24/04/2005", "Hougang","Math","NIL"));
		studentList.add(new Student(2,"Jonathan", 'M',89431275,"16/10/2007", "Potong Pasir","Science","I had a great class today! "
				+"The teacher was patient and explained the theories well."));
		teacherList.add(new Teacher("Ms Lee", "History"));
		teacherList.add(new Teacher("Mr Toh", "Math"));
		//acnfnvinrjnr
		
		int option = 0;
		


	}
	
	public static void setHeader(String header) {
		Helper.line(40, "-");
		System.out.println(header);
		Helper.line(40, "-");
	}
	
	public static void login() {
		Helper.line(40, "-");
		Helper.readString("Login ");
	}
	
	public static void studentMenu() {
		Helper.line(40, "-");
		System.out.println("STUDENT MENU");
		Helper.line(40, "-");
		System.out.println("1. Register Account");
		System.out.println("2. Edit account");
		System.out.println("3. Search tuition and timetable");
		System.out.println("4. Register for tuition");
		System.out.println("5. Cancel tuition");
		System.out.println("6. Quit");
	}
	
	public static void tuitionAdministratorMenu() {
		Helper.line(40, "-");
		System.out.println("TUITION ADMINISTRATOR MENU");
		Helper.line(40, "-");
		System.out.println("1. Register accounton behalf of Student");
		System.out.println("2. Edit account");
		System.out.println("3. Search for title (title, mode, dates)");
		System.out.println("4. Quit");
	}
	
	public static void tuitionManagerMenu() {
		Helper.line(40, "-");
		System.out.println("TUITION MANAGER MENU");
		Helper.line(40, "-");
		System.out.println("1. Search and view tuition timetable details");
		System.out.println("2. Record/edit equiry information");
		System.out.println("3. Assign teahcer to subject group");
		System.out.println("4. Search and view teacher details");
		System.out.println("5. Quit");
	}
	
	public static void addStudent(ArrayList<Student> studentList, Student s) {
		studentList.add(s);
		
	}
	

}
