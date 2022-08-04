import java.util.ArrayList;

public class C206_CaseStudy {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ArrayList<Student> studentList = new ArrayList<Student>();
		ArrayList<Teacher> teacherList = new ArrayList<Teacher>();
		ArrayList<Tuition> tuitionList = new ArrayList<Tuition>();
		
		studentList.add(new Student("Susan", 'F',"98763421","24/04/2005", "Hougang","Math","NIL"));
		studentList.add(new Student("Jonathan", 'M',"89431275","16/10/2007", "Potong Pasir","Science","I had a great class today! "
				+"The teacher was patient and explained the theories well. "));
		teacherList.add(new Teacher("Ms Lee", "History"));
		teacherList.add(new Teacher("Mr Toh", "Math"));
		//acnfnvinrjnr


	}
	
	public static void studentMenu() {
		Helper.line(40, "-");
		System.out.println("TUITION MENU");
		Helper.line(40, "-");
		System.out.println("1. Add a Student");
		System.out.println("2. View all staff");
		System.out.println("3. Update Student info");
		System.out.println("4. Generate Montly report");
		System.out.println("5. Quit");
	}
	
	public static void teacherMenu() {
		Helper.line(40,)
	}

}
