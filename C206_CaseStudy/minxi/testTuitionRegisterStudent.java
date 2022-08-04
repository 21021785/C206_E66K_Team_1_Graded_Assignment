import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class testTuitionRegisterStudent {
	private Register s1;
	private Register s2;
	
	
	@Before
	public void setUp() throws Exception {
		//prepare test data
		s1 = new Register("001","0011", "susan@gmail.com","pending","2022-09-13");
		s2 = new Register("002","0022", "thomas@gmail,com", "pending", "2022-07-19");
		
		registerList = new ArrayList<Register>();
		
	}
	@Test
	public void testAddRegister() {
		// Item list is not null, so that can add a new item - boundary
		assertNotNull("Check if there is valid register arraylist to add to", registerList);
		//Given an empty list, after adding 1 item, the size of the list is 1 - normal
		//The item just added is as same as the first item of the list
		TuitionRegisterStudent.addRegister(registerList, s1);
		assertEquals("Check that register arraylist size is 1", 1, registerList.size());
		assertSame("Check that registration is added", s1, registerList.get(0));
		
		//Add another item. test The size of the list is 2? -normal
		//The item just added is as same as the second item of the list
		TuitionRegisterStudent.addRegister(registerList, s2);
		assertEquals("Check that Camcorder arraylist size is 2", 2, registerList.size());
		assertSame("Check that registration is added", s2, registerList.get(1));
	}
	@Test
	public void testRetrieveAllRegister() {
		// Test if Item list is not null but empty -boundary
		assertNotNull("Test if there is valid register arraylist to retrieve item", registerList);
		
		//test if the list of camcorders retrieved from the SourceCentre is empty - boundary
		String allRegister= TuitionRegisterStudent.retrieveAllRegister(registerList);
		String testOutput = "";
		assertEquals("Check that ViewAllRegisterList", testOutput, allRegister);
		
		//Given an empty list, after adding 2 items, test if the size of the list is 2 - normal
		ResourceCentre.addRegister(registerList, s1);
		ResourceCentre.addRegister(registerList, s2);
		assertEquals("Test that register arraylist size is 2?", 2, registerList.size());
		
		//test if the expected output string same as the list of camcorders retrieved from the SourceCentre	
		allRegister= TuitionRegisterStudent.retrieveAllRegister(registerList);
		testOutput = String.format("%-10s %-10s %-30s %-10s %-20s\n","001","0011", "susan@gmail.com","pending","2022-09-13");
		testOutput += String.format("%-10s %-10s %-30s %-10s %-20s\n","002","0022", "thomas@gmail,com", "pending", "2022-07-19" );
	
		assertEquals("Test that ViewAllRegisterList", testOutput, allRegister);
		
	}
	@Test
	public void testDoDelete() {
		//boundary
		assertNotNull("test if there is valid register arraylist to delete from", registerList);
		
		TuitionRegisterStudent.addRegister(registerList, s1);
		// normal
		Boolean ok = TuitionRegisterStudent.doDeleteRegister(registerList, "001" );
		assertTrue("Test if an available item is ok to delete?", ok);
		//error condition
		ok = TuitionRegisterStudent.doDeleteRegister(registerList, "001" );
		assertFalse("Test if the same item is NOT ok to delete again?", ok);	
		//error condition
		ResourceCentre.addCamcorder(registerList, s2);	
		s2.remove();
		ok = TuitionRegisterStudent.doDeleteRegister(registerList, "002");
		assertFalse("Test that un-available item is NOT ok to retrieve?", ok);
		//error condition
		ok = TuitionRegisterStudent.doDeleteRegister(registerList, "002" );
		assertFalse("Test that non-exsiting item is NOT ok to retrieve?", ok);
		
	}

}
