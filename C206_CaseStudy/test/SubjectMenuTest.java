import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class SubjectMenuTest {

	private Subject sj1;
	private Subject sj2;
	private Subject sj3;

	private Teacher tc1;
	private Teacher tc2;
	private Teacher tc3;

	private ArrayList<Subject> subjectList;
	private ArrayList<Teacher> teacherList;

	public SubjectMenuTest() {
		super();
	}

	@Before
	public void setUp() throws Exception {
		sj1 = new Subject("Subject001", "Math", "Min age 3");
		sj2 = new Subject("Subject002", "Science", "Min age 7");
		sj3 = new Subject("Subject003", "Coding", "Min age 14");

		tc1 = new Teacher("Teacher001", "Justin", "Male", "justin@email.com", "Math,English", "Math");
		tc2 = new Teacher("Teacher002", "Min Xi", "Female", "minxi@email.com", "Math,Sch", "Math");
		tc3 = new Teacher("Teacher003", "YongLer", "Male", "yongler@email.com", "Com,English", "Math");

		subjectList = new ArrayList<Subject>();
		teacherList = new ArrayList<Teacher>();

	}

	@Test
	public void testRetrieveAllSubject() {
		// Test if Item list is not null but empty, so that can add a new item
		assertNotNull("Test if there is valid Subject arraylist to add to", subjectList);

		// test if the list of subject retrieved from the SourceCentre is empty
		String allSubject = SubjectMenu.retrieveAllSubject(subjectList);
		String testOutput = "";
		assertEquals("Check that ViewAllSubjectList", testOutput, allSubject);

		// Given an empty list, after adding 2 items, test if the size of the list is 2
		SubjectMenu.addSubject(subjectList, sj1);
		SubjectMenu.addSubject(subjectList, sj2);
		assertEquals("Test if that Subject arraylist size is 2?", 2, subjectList.size());

		// test if the expected output string same as the list of subject retrieved from
		// the SourceCentre
		allSubject = SubjectMenu.retrieveAllSubject(subjectList);

		testOutput = String.format("%-15s %-30s %-20s\n", "Subject001", "Math", "Min age 3");
		testOutput += String.format("%-15s %-30s %-20s\n", "Subject002", "Science", "Min age 7");

		assertEquals("Check that ViewAllSubjectlist", testOutput, allSubject);

	}

	@Test
	public void testAddSubject() {
		// Item list is not null, so that can add a new item
		assertNotNull("Test if there is valid Subject arraylist to add to", subjectList);

		// Given an empty list, after adding 1 item, the size of the list is 1
		SubjectMenu.addSubject(subjectList, sj1);
		assertEquals("Test if that Subject arraylist size is 1?", 1, subjectList.size());

		// The item just added is as same as the first item of the list
		assertSame("Test that Subject is added same as 1st item of the list?", sj1, subjectList.get(0));

		// Add another item. test The size of the list is 2?
		SubjectMenu.addSubject(subjectList, sj2);
		SubjectMenu.addSubject(subjectList, sj3);
		assertEquals("Test that Subject arraylist size is 3?", 3, subjectList.size());
		assertSame("Test that Subject is added same as 3rd item of the list?", sj3, subjectList.get(2));
	}

	@Test
	public void testDoDeleteSubject() {
		// fail("Not yet implemented");
		// write your code here

		// boundary
		assertNotNull("Test if there is valid Subject arraylist to add to", subjectList);

		// error
		SubjectMenu.addSubject(subjectList, sj1);
		Boolean isReturned = SubjectMenu.doDeleteSubject(subjectList, "Subject001");
		System.out.print(isReturned);
		assertTrue("Test if subject Subject001 is deleted?", isReturned);

		// error
		isReturned = SubjectMenu.doDeleteSubject(subjectList, "Subject003");
		assertFalse("Test if subject Subject003 is not delete?", isReturned);

	}

	@Test
	public void testRetrieveAllTeacher() {
		// Test if Item list is not null but empty, so that can add a new item
		assertNotNull("Test if there is valid Teacher arraylist to add to", teacherList);

		// test if the list of subject retrieved from the SourceCentre is empty
		String allTeacher = SubjectMenu.retrieveAllTeacher(teacherList);
		String testOutput = "";
		assertEquals("Check that ViewAllTeacherList", testOutput, allTeacher);

		// Given an empty list, after adding 2 items, test if the size of the list is 2
		teacherList.add(tc1);
		assertEquals("Test if that Teacher arraylist size is 2?", 1, teacherList.size());

		// test if the expected output string same as the list of subject retrieved from
		// the SourceCentre
		allTeacher = SubjectMenu.retrieveAllTeacher(teacherList);

		testOutput = String.format("%-15s %-15s %-20s %-10s %-25s %-20s\n","Math", "Teacher001", "Justin", "Male",
				"justin@email.com", "Math,English");

		assertEquals("Check that ViewAllTeacherlist", testOutput, allTeacher);

	}
	
	@Test
	public void testDoAssignTeacher() {
		//boundary
		assertNotNull("Test if there is valid Teacher arraylist to add to", teacherList);
		teacherList.add(tc1);
		//error
		Boolean isAssigned = SubjectMenu.doAssignTeacher(teacherList, "Teacher001", "Math");
		
		teacherList.add(tc2);
		isAssigned = SubjectMenu.doAssignTeacher(teacherList, "Teacher002", "Math");
		assertTrue("Test if loaned out amcorder CC0012 is returned- true", isAssigned);
		//error
		isAssigned = SubjectMenu.doAssignTeacher(teacherList, "Teacher003", "Math");
		assertFalse("Test if non-existing amcorder CC0013 is returned - false?", isAssigned);
		
	}
	
	@Test
	public void doSearchTeacher() {
		
		// boundary
		assertNotNull("Test if there is valid Teacher arraylist to add to", teacherList);

		// error
		teacherList.add(tc1);
		Boolean isSearch = SubjectMenu.doSearchTeacher(teacherList, "Teacher001");
		System.out.print(isSearch);
		assertTrue("Test if teacher Teacher001 is found?", isSearch);

		// error
		isSearch = SubjectMenu.doSearchTeacher(teacherList, "Teacher003");
		assertFalse("Test if non-existing teacher Teacher003 is found?", isSearch);

	}

	@After
	public void tearDown() throws Exception {
		sj1 = null;
		sj2 = null;
		sj3 = null;
		subjectList = null;
	}

}
