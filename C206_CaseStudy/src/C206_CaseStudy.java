import java.util.ArrayList;

public class C206_CaseStudy {
	private static final int OPTION_ADD = 2;
	private static final int OPTION_DELETE = 3;
	private static final int OPTION_VIEW = 1;
	private static final int OPTION_SEARCH = 4;
	private static final int OPTION_UPDATE = 5;
	private static final int OPTION_WAITLIST = 6;

	private static final int OPTION_QUIT = 7;

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

		ArrayList<Tuition> tuitionList = new ArrayList<Tuition>();

		tuitionList.add(new Tuition("001", "Math Tuition", "Math", "Includes A-math, E-math etc", 4, "Min Age 13",
				"Low Jun Jie", "Math Tuition"));
		tuitionList.add(new Tuition("002", "Science Tuition", "Science", "Includes Bio, physics and Chemistry", 6,
				"Min Age 13", "Tan Wen Xiong", "Science Tuition"));
		tuitionList.add(new Tuition("003", "Coding Tuition", "Coding", "Includes C++, python and Java", 5, "Min Age 15",
				"John Pang", ""));

		ArrayList<Register> registerList = new ArrayList<Register>();

		registerList.add(new Register("001", "0011", "susan@gmail.com", "pending", "2022-09-13", "no"));
		registerList.add(new Register("002", "0022", "thomas@gmail.com", "pending", "2022-07-19", "no"));

		ArrayList<Timetable> timetableList = new ArrayList<Timetable>();

		timetableList.add(new Timetable("1", 250.00, "01/01/2022", "1400", "01/06/2022", "1600", "Face to face"));
		timetableList.add(new Timetable("2", 300.00, "01/07/2022", "1600", "01/10/2022", "1800", "Online"));

		ArrayList<Student> studentList = new ArrayList<Student>();

		studentList
				.add(new Student("Mary", 'F', 85674367, "12 February 2005", "Blk 985 Ang Mo Kio St 97 #07-983 794985"));
		studentList
				.add(new Student("John", 'M', 85674367, "12 February 2005", "Blk 493 Sengkang Ave 53 #03-09 345493"));

		int option = 0;

		while (option != 7) {

			C206_CaseStudy.menu();
			option = Helper.readInt("Enter an option > ");

			if (option == 1) {
				while (option != 4) {

					TuitionMenu.displayTuitionMenu();
					option = Helper.readInt("Enter an option > ");

					if (option == 1) {
						// View all items
						TuitionMenu.viewAllTuition(tuitionList);

					} else if (option == 2) {
						// Add a Subject
						TuitionMenu.setHeader("ADD TUITION");

						Tuition tt = TuitionMenu.inputTuition();
						TuitionMenu.addTuition(tuitionList, tt);
						System.out.println("Tuition added");

					} else if (option == 3) {
						// Return item
						TuitionMenu.setHeader("DELETE TUITION");

						TuitionMenu.deleteTuition(tuitionList);

					} else if (option == 4) {
						System.out.println("Bye!");
					} else {
						System.out.println("Invalid option");
					}

				}
			} else if (option == 2) {

				option = 0;
				while (option != 4) {
					SubjectMenu.displaySubjectMenu();
					option = Helper.readInt("Enter an option > ");

					if (option == 1) {
						// View all items
						SubjectMenu.viewAllSubject(subjectList);

					} else if (option == 2) {
						// Add a Subject
						SubjectMenu.setHeader("ADD SUBJECT");

						Subject sj = SubjectMenu.inputSubject();
						SubjectMenu.addSubject(subjectList, sj);
						System.out.println("Subject added");

					} else if (option == 3) {
						// Return item
						SubjectMenu.setHeader("DELETE SUBJECT");

						SubjectMenu.deleteSubject(subjectList);

					} else if (option == 4) {
						System.out.println("Bye!");
					} else {
						System.out.println("Invalid option");
					}
				}
			}  else if (option == 3) {
				option = 0;
				while (option != 4) {

					TimetableMenu.menu();
					option = Helper.readInt("Enter an option > ");

					if (option == 1) {
						// Add new timetable
						Timetable tt = TimetableMenu.inputTimetable();
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
			} else if (option == 4) {
				option = 0;
				while (option != 4) {

					StudentMenu.displayStudentMenu();
					option = Helper.readInt("Enter an option > ");

					if (option == 1) {
						// Add a Subject
						StudentMenu.setHeader("Register Account");

						Student st = StudentMenu.inputStudent();
						StudentMenu.addStudent(studentList, st);
						System.out.println("Account Registered");

					} else if (option == 2) {
						// View all items
						for (int i = 0; i < studentList.size(); i++) {
							System.out.print(studentList.get(i));
						}
					} else if (option == 3) {
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
			else if (option == 5) {
				option = 0;

				while (option != OPTION_QUIT) {

					TuitionRegisterStudent.menu();
					option = Helper.readInt("Enter an option > ");

					if (option == OPTION_VIEW) {
						TuitionRegisterStudent.viewAllRegister(registerList);

					} else if (option == OPTION_ADD) {
						TuitionRegisterStudent.setHeader("ADD");

						Register rr = TuitionRegisterStudent.addRegister();
						TuitionRegisterStudent.addRegister(registerList, rr);
						System.out.println("New Registration added");

					} else if (option == OPTION_DELETE) {
						TuitionRegisterStudent.setHeader("DELETE");

						TuitionRegisterStudent.deleteRegister(registerList);
					} else if (option == OPTION_SEARCH) {
						TuitionRegisterStudent.setHeader("SEARCH");
						TuitionRegisterStudent.searchRegister(registerList);

					} else if (option == OPTION_UPDATE) {
						TuitionRegisterStudent.setHeader("UPDATE TUITION STATUS");
						TuitionRegisterStudent.UpdateStatus(registerList);
					} else if (option == OPTION_WAITLIST) {
						TuitionRegisterStudent.setHeader("PLACE STUDENT ON WAIT LIST");
						TuitionRegisterStudent.WaitList(registerList);

					} else if (option == OPTION_QUIT) {
						System.out.println("Bye!");
					} else {
						System.out.println("Invalid option");

					}
				}
			} 
			else if (option == 6) {
				option = 0;

				while (option != 3) {
					SubjectMenu.displayTeacherMenu();
					option = Helper.readInt("Enter an option > ");

					if (option == 1) {
						// View all items
						SubjectMenu.viewAllTeacher(teacherList);

						SubjectMenu.searchTeacher(teacherList);

					} else if (option == 2) {
						// Assign Teacher
						SubjectMenu.setHeader("Assign teacher");

						SubjectMenu.assignTeacher(teacherList, subjectList);

					} else if (option == 3) {
						System.out.println("Bye!");
					} else {
						System.out.println("Invalid option");
					}
				}
			}
			else if (option == 7) {
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
		System.out.println("1. Tuition menu");
		System.out.println("2. Subject menu");
		System.out.println("3. Timetable Menu");
		System.out.println("4. Student Menu");
		System.out.println("5. Register for tuition menu");
		System.out.println("6. Assign teacher to tuition menu");
		System.out.println("7. Quit");
	}

}
