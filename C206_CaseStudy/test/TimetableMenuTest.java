import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TimetableMenuTest {
	private Timetable ti1;
	private Timetable ti2;
	private ArrayList<Timetable> timetableList;
	

	public TimetableMenuTest() {
		super();
	}
	

	@Before
	public void setUp() throws Exception {

		ti1 = new Timetable("1", 350.00, "01/07/2018", "1600", "01/10/2018", "1800", "Face to face");
		ti2 = new Timetable("2", 400.00, "01/01/2018", "1800", "01/06/2018", "2000", "Online");
					
		timetableList= new ArrayList<Timetable>();
	}
	
	
	@Test
	public void testAddTimetable() {
		//Timetable list is not null, so can add a new item 
		assertNotNull("Test if there is valid timetable arraylist to add to", timetableList);
		
		//Given an empty list, after adding 1 item, the size of the list is 1
		TimetableMenu.addTimetable(timetableList,ti1);
		assertEquals("Test if that Timetable arraylist size is 1?", 1, timetableList.size());
		
		//The item just added is as same as the first item of the list
		assertSame("Test that Timetable is added same as 1st item of the list?", ti1, timetableList.get(0));
		
		//Add another item. test The size of the list is 2?
		TimetableMenu.addTimetable(timetableList, ti2);
		assertEquals("Test that Timetable arraylist size is 2?", 2, timetableList.size());
		assertSame("Test that Timetable is added same as 2nd item of the list?", ti2, timetableList.get(1));
	
	}
	
	@Test
	public void testViewTimetable() {
		// Test if Timetable list is not null but empty, so that can add a new item
		assertNotNull("Test if there is valid Timetable arraylist to add to", timetableList);
		
		//test if the list of timetables retrieved from the TimetableMenu is empty
		String allTimetable= TimetableMenu.retrieveAllTimetable(timetableList);
		String testOutput = "";
		assertEquals("Check that ViewAllTimetableList", testOutput, allTimetable);
				
		//Given an empty list, after adding 2 items, test if the size of the list is 2
		TimetableMenu.addTimetable(timetableList,ti1);
		TimetableMenu.addTimetable(timetableList,ti2);
		assertEquals("Test if that Timetable arraylist size is 2?", 2, timetableList.size());
		
		//test if the expected output string same as the list of timetables retrieved from the TimetableMenu
		allTimetable= TimetableMenu.retrieveAllTimetable(timetableList);

		testOutput = String.format("%-10s %-10.2f %-15s %-15s %-15s %-10s %-10s\n", "1", 350.00, "01/07/2018", "1600", "01/10/2018", "1800", "Face to face");
		testOutput += String.format("%-10s %-10.2f %-15s %-15s %-15s %-10s %-10s\n", "2", 400.00, "01/01/2018", "1800", "01/06/2018", "2000", "Online");
	
		assertEquals("Check that ViewAllCamcorderlist matches", testOutput, allTimetable);
		
	}
	
	@Test
	public void testDeleteTimetable() {

		// Test valid timetable arraylist
		assertNotNull("Test if there is valid timetable arraylist to add to", timetableList);

		// Add timetable
		TimetableMenu.addTimetable(timetableList, ti1);
		assertEquals("Test if that Timetable arraylist size is 1?", 1, timetableList.size());
		
		// Test delete of object not within list
		TimetableMenu.doDeleteTimetable(timetableList, "3");
		assertEquals("Test if that Timetable arraylist size is 1?", 1, timetableList.size());
		
		// Test successful delete
		TimetableMenu.doDeleteTimetable(timetableList, "1");
		assertEquals("Test if that Timetable arraylist size is 0?", 0, timetableList.size());
	}
	

	@After
	public void tearDown() throws Exception {
		ti1 = null;
		ti2 = null;
		timetableList = null;
	}

}
