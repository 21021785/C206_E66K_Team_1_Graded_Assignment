/*
 * import static org.junit.Assert.*;
 * 
 * import java.util.ArrayList;
 * 
 * import org.junit.After; import org.junit.Before; import org.junit.Test;
 * 
 * public class C206_CaseStudyTest { private Student s1; private Student s2;
 * private Student s3; private Teacher t1; private Teacher t2;
 * 
 * private ArrayList<Student> studentList; private ArrayList<Teacher>
 * teacherList;
 * 
 * 
 * public C206_CaseStudyTest() { super(); }
 * 
 * 
 * @Before public void setUp() throws Exception { s1 = new Student(1,"Susan",
 * 'F',98763421,"24/04/2005", "Hougang","Math","NIL"); s2 = new
 * Student(2,"Jonathan", 'M',89431275,"16/10/2007",
 * "Potong Pasir","Science","I had a great class today! "
 * +"The teacher was patient and explained the theories well. "); t1 = new
 * Teacher("Ms Lee", "History"); t2 = new Teacher("Mr Toh", "Math");
 * 
 * studentList= new ArrayList<Student>(); teacherList= new ArrayList<Teacher>();
 * }
 * 
 * @Test public void testRegisterForStudent() { //Item list is not null, so can
 * add a new item
 * assertNotNull("Test if there is valid Student arraylist to add to",
 * studentList);
 * 
 * //Given an empty list, after adding 1 item, the size of the list is 1
 * C206_CaseStudy.addStudent(studentList,s1);
 * assertEquals("Test if that Student arraylist size is 1?", 1,
 * studentList.size());
 * 
 * //The item just added is as same as the first item of the list
 * assertSame("Test that Student is added same as 1st item of the list?", s1,
 * studentList.get(0));
 * 
 * //Add another item. test The size of the list is 2?
 * C206_CaseStudy.addStudent(studentList, s2);
 * C206_CaseStudy.addStudent(studentList, s3);
 * assertEquals("Test that Student arraylist size is 3?", 3,
 * studentList.size());
 * assertSame("Test that Student is added same as 3rd item of the list?", s3,
 * studentList.get(2));
 * 
 * }
 * 
 * @Test public void testRegisterStudentForTuition() {
 * assertNotNull("test if there is valid Student arrayList to register student for tuition"
 * ,studentList);
 * 
 * C206_CaseStudy.addStudent(studentList, s1);
 * 
 * //normal //Boolean ok = C206_CaseStudy.doRegisterStudentTuition(studentList,
 * 1); //assertTrue("Test if student able to register for tuition?", ok);
 * //assertFalse() }
 * 
 * 
 * 
 * 
 * 
 * @Test public void c206_test() { //fail("Not yet implemented");
 * assertTrue("C206_CaseStudy_SampleTest ",true); }
 * 
 * @After public void tearDown() throws Exception { s1 = null; s2 = null; t1 =
 * null; t2 = null; studentList = null; teacherList = null; }
 * 
 * }
 */