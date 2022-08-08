import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TuitionMenuTest {
	
	private Tuition tt1;
	private Tuition tt2;
	private Tuition tt3;
	
	private ArrayList<Tuition> tuitionList;
	
	public TuitionMenuTest() {
		super();
	}
	@Before
	public void setUp() throws Exception {
		
		tt1 = new Tuition("001", "Math Tuition", "Math", "Includes A-math, E-math etc", 4, "Min Age 13", "Low Jun Jie", "Math Tuition");
		tt2 = new Tuition("002", "Science Tuition", "Science", "Includes Bio, physics and Chemistry", 6, "Min Age 13", "Tan Wen Xiong", "Science Tuition");
		tt3 = new Tuition("003", "Coding Tuition", "Coding", "Includes C++, python and Java", 5, "Min Age 15", "John Pang", "");
		
		tuitionList = new ArrayList<Tuition>();
	}
	
	public void testRetrieveAllSubject() {
		// Test if Item list is not null but empty, so that can add a new item
		assertNotNull("Test if there is valid Tuition arraylist to add to", tuitionList);

		// test if the list of Tuition retrieved from the SourceCentre is empty
		String allTuition = TuitionMenu.retrieveAllTuition(tuitionList);
		String testOutput = "";
		assertEquals("Check that ViewAllTuitionList", testOutput, allTuition);

		// Given an empty list, after adding 2 items, test if the size of the list is 2
		TuitionMenu.addTuition(tuitionList, tt1);
		TuitionMenu.addTuition(tuitionList, tt2);
		assertEquals("Test if that Tuition arraylist size is 2?", 2, tuitionList.size());

		// test if the expected output string same as the list of Tuition retrieved from
		// the SourceCentre
		allTuition = TuitionMenu.retrieveAllTuition(tuitionList);

		testOutput = String.format("%-15s %-30s %-20s\n", "Subject001", "Math", "Min age 3");
		testOutput += String.format("%-15s %-30s %-20s\n", "Subject002", "Science", "Min age 7");

		assertEquals("Check that ViewAllTuitionlist", testOutput, allTuition);

	}

	@Test
	public void testAddTuition() {
		// Item list is not null, so that can add a new item
		assertNotNull("Test if there is valid Tuition arraylist to add to", tuitionList);

		// Given an empty list, after adding 1 item, the size of the list is 1
		TuitionMenu.addTuition(tuitionList, tt1);
		assertEquals("Test if that Tuition arraylist size is 1?", 1, tuitionList.size());

		// The item just added is as same as the first item of the list
		assertSame("Test that Tuition is added same as 1st item of the list?", tt1, tuitionList.get(0));

		// Add another item. test The size of the list is 2?
		TuitionMenu.addTuition(tuitionList, tt2);
		TuitionMenu.addTuition(tuitionList, tt3);
		assertEquals("Test that Tuition arraylist size is 3?", 3, tuitionList.size());
		assertSame("Test that Tuition is added same as 3rd item of the list?", tt3, tuitionList.get(2));
	}

	@Test
	public void testDoDeleteTuition() {
		// fail("Not yet implemented");
		// write your code here

		// boundary
		assertNotNull("Test if there is valid Tuition arraylist to add to", tuitionList);

		// error
		TuitionMenu.addTuition(tuitionList, tt1);
		Boolean isReturned = TuitionMenu.doDeleteTuition(tuitionList, "001");
		System.out.print(isReturned);
		assertTrue("Test if tuition 001 is deleted?", isReturned);

		// error
		isReturned = TuitionMenu.doDeleteTuition(tuitionList, "003");
		assertFalse("Test if tuition 003 is not delete?", isReturned);

	}
	@After
	public void tearDown() throws Exception {
		tt1 = null;
		tt2 = null;
		tt3 = null;
		tuitionList = null;
	}
}
