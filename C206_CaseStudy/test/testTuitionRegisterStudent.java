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
	
	private ArrayList<Register> registerList;
	@Before
	public void setUp() throws Exception {
		//prepare test data
		s1 = new Register("001","0011", "susan@gmail.com","pending","2022-09-13", "no");
		s2 = new Register("002","0022", "thomas@gmail,com", "pending", "2022-07-19","no");
		
		
		registerList = new ArrayList<Register>();
	}
	@Test
	public void testAddRegister() {
		// Item list is not null, so that can add a new item - boundary
		assertNotNull("Test if there is valid register arraylist to add to", registerList);
		//Given an empty list, after adding 1 item, the size of the list is 1 - normal
		//The item just added is as same as the first item of the list
		TuitionRegisterStudent.addRegister(registerList, s1);
		assertEquals("Test that register arraylist size is 1", 1, registerList.size());
		assertSame("Test that registration is added", s1, registerList.get(0));
		
		//Add another item. test The size of the list is 2? -normal
		//The item just added is as same as the second item of the list
		TuitionRegisterStudent.addRegister(registerList, s2);
		assertEquals("Test that Camcorder arraylist size is 2", 2, registerList.size());
		assertSame("Test that registration is added", s2, registerList.get(1));
	}
	@Test
	public void testRetrieveAllRegister() {
		// Test if Item list is not null but empty -boundary
		assertNotNull("Test if there is valid register arraylist to retrieve item", registerList);
		
		//test if the list of register retrieved from the SourceCentre is empty - boundary
		String allRegister= TuitionRegisterStudent.retrieveAllRegister(registerList);
		String testOutput = "";
		assertEquals("Test that ViewAllRegisterList", testOutput, allRegister);
		
		//Given an empty list, after adding 2 items, test if the size of the list is 2 - normal
		TuitionRegisterStudent.addRegister(registerList, s1);
		TuitionRegisterStudent.addRegister(registerList, s2);
		assertEquals("Test that register arraylist size is 2?", 2, registerList.size());
		
		//test if the expected output string same as the list of registers retrieved from the SourceCentre	
		allRegister= TuitionRegisterStudent.retrieveAllRegister(registerList);
		testOutput = String.format("%-10s %-20s %-20s %-10s %-20s %-10s\n","001","0011", "susan@gmail.com","pending","2022-09-13","no");
		testOutput += String.format("%-10s %-20s %-20s %-10s %-20s %-10s\n","002","0022", "thomas@gmail,com", "pending", "2022-07-19","no" );
	
		assertEquals("Test that ViewAllRegisterList", testOutput, allRegister);
		
	}
	@Test
	public void testDeleteReigster() {
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
		TuitionRegisterStudent.addRegister(registerList, s2);	
		registerList.remove(s2);
		ok = TuitionRegisterStudent.doDeleteRegister(registerList, "002");
		assertFalse("Test that un-available item is NOT ok to retrieve?", ok);
		//error condition
		ok = TuitionRegisterStudent.doDeleteRegister(registerList, "002" );
		assertFalse("Test that non-exsiting item is NOT ok to retrieve?", ok);
		
	}
	
	@Test
	public void testDoSearchRegister() {
		//boundary
		assertNotNull("test if there is valid register arraylist to search from", registerList);
		
		TuitionRegisterStudent.addRegister(registerList, s1);
		// normal
		Boolean ok = TuitionRegisterStudent.doSearchRegister(registerList, "001");
		assertTrue("Test if an available item is ok to display?", ok);
		//error condition
		ok = TuitionRegisterStudent.doSearchRegister(registerList, "003" );
		assertFalse("Test that non-exsiting item is NOT ok to display?", ok);	
	}
	
	@Test
	public void testDoUpdateStatus() {
		//boundary
		assertNotNull("test if there is valid register arraylist to update", registerList);
		
		TuitionRegisterStudent.addRegister(registerList, s1);
		s1.setStatus("comfirmed");
		// normal
		Boolean ok = TuitionRegisterStudent.doUpdateStatus(registerList, "001", "comfirmed" );
		assertTrue("Test if student is comfirmed to go for tuition?", ok);
		
		//error condition
		ok = TuitionRegisterStudent.doUpdateStatus(registerList, "004", "comfirmed" );
		assertFalse("Test if non-existing student is NOT ok to update status to comfirmed?", ok);	
			
	}
	
	@Test
	public void testDoWaitList() {
		//boundary
		assertNotNull("test if there is valid register arraylist to put student on waitList", registerList);
		
		TuitionRegisterStudent.addRegister(registerList, s1);
		s1.setWaitList("yes");
		// normal
		Boolean ok = TuitionRegisterStudent.doWaitList(registerList, "001", "yes" );
		assertTrue("Test if student is in the waiting list?", ok);
		
		//error condition
		ok = TuitionRegisterStudent.doWaitList(registerList, "004", "yes" );
		assertFalse("Test if non-existing student is NOT ok to be in the waiting list?", ok);
		//minxi 
	}
		

}
