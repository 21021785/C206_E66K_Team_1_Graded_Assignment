import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;



public class StudentMenuTest {

	private Student s1;
	private Student s2;
	
	private ArrayList<Student> studentList;
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		
		
		s1 = (new Student("Mary", 'F', 85674367, "12 February 2005", "Blk 985 Ang Mo Kio St 97 #07-983 794985"));
		s2 = (new Student("John", 'M', 85674367, "12 February 2005", "Blk 493 Sengkang Ave 53 #03-09 345493"));
		
		studentList = new ArrayList<Student>();
	}

	@After
	public void tearDown() throws Exception {
		s1 = null;
		s2 = null;
		studentList = null;
	}

	@Test
	public void testAddStudent() {
		// Item list is not null, so that can add a new item - boundary
		assertNotNull("Test if there is valid student arraylist to add to", studentList);
		//Given an empty list, after adding 1 item, the size of the list is 1 - normal
		//The item just added is as same as the first item of the list
		StudentMenu.addStudent(studentList, s1);
		assertEquals("Test that student arraylist size is 1", 1, studentList.size());
		assertSame("Test that student is added", s1, studentList.get(0));
		
		//Add another item. test The size of the list is 2? -normal
		//The item just added is as same as the second item of the list
		StudentMenu.addStudent(studentList, s2);
		assertEquals("Test that student arraylist size is 2", 2, studentList.size());
		assertSame("Test that student is added", s2, studentList.get(1));
	}
	@Test
	public void testRetrieveAllStudent() {
		// Test if Item list is not null but empty -boundary
		assertNotNull("Test if there is valid register arraylist to retrieve item", studentList);
		
		//test if the list of register retrieved from the SourceCentre is empty - boundary
		String allStudent= StudentMenu.retrieveAllStudent(studentList);
		String testOutput = "";
		assertEquals("Test that ViewAllStudentList", testOutput, allStudent);
		
		//Given an empty list, after adding 2 items, test if the size of the list is 2 - normal
		StudentMenu.addStudent(studentList, s1);
		StudentMenu.addStudent(studentList, s2);
		assertEquals("Test that student arraylist size is 2?", 2, studentList.size());
		
		//test if the expected output string same as the list of registers retrieved from the SourceCentre	
		allStudent= StudentMenu.retrieveAllStudent(studentList);
		testOutput = String.format("%-15s %1s %9s %-15s %-40s\n","Mary", "F", "85674367", "12 February 2005", "Blk 985 Ang Mo Kio St 97 #07-983 794985");
		testOutput += String.format("%-15s %1s %9s %-15s %-40s\n","John", "M", "85674367", "12 February 2005", "Blk 493 Sengkang Ave 53 #03-09 345493");
		assertEquals("Test that ViewAllStudentList", testOutput, allStudent);
		
	}
	@Test
	public void testDeleteStudent() {
		//boundary
		assertNotNull("test if there is valid student arraylist to delete from", studentList);
		
		StudentMenu.addStudent(studentList, s1);
		// normal
		Boolean ok = StudentMenu.doDeleteStudent(studentList, "Mary" );
		assertTrue("Test if an available item is ok to delete?", ok);
		//error condition
		ok = StudentMenu.doDeleteStudent(studentList, "Mary" );
		assertFalse("Test if the same item is NOT ok to delete again?", ok);	
		//error condition
		StudentMenu.addStudent(studentList, s2);	
		studentList.remove(s2);
		ok = StudentMenu.doDeleteStudent(studentList, "John");
		assertFalse("Test that un-available item is NOT ok to retrieve?", ok);
		//error condition
		ok = StudentMenu.doDeleteStudent(studentList, "John" );
		assertFalse("Test that non-exsiting item is NOT ok to retrieve?", ok);
		
	}

}
