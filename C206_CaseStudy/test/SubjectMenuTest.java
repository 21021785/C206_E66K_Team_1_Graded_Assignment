import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class SubjectMenuTest {

	private Subject sj1;
	private Subject sj2;
	private Subject sj3;

	private ArrayList<Subject> subjectList;

	public SubjectMenuTest() {
		super();
	}

	@Before
	public void setUp() throws Exception {
		sj1 = new Subject("Subject001", "Math", "Min age 3");
		sj2 = new Subject("Subject002", "Science", "Min age 7");
		sj3 = new Subject("Subject003", "Coding", "Min age 14");

		subjectList = new ArrayList<Subject>();
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
		
		//error
		isReturned = SubjectMenu.doDeleteSubject(subjectList, "Subject003");
		assertFalse("Test if subject Subject003 is not delete?", isReturned);
		
	}

	@After
	public void tearDown() throws Exception {
		sj1 = null;
		sj2 = null;
		sj3 = null;
		subjectList = null;
	}

}
