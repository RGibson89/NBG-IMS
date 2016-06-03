package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import com.qa.nbg_ims.dabaseconnectors.ConnectionManager;

public class DBQueryTests {
	
	
	
	
	
	
	ConnectionManager connect = new ConnectionManager();
	
	@Test
	public void checkConnection() {
		/*
		 * Tests to check jdbc connection tot he mysql database
		 */
		
		//Checks if the connection exists once the connect method has been called.
		try {
			connect.connect();
			assertNotNull(connect.conn);
		} catch(Exception exc) {
			exc.printStackTrace();
		}
		
	}
	
	

	@Test
	public void checkCustomerSearch() {
		/*
		 * Tests to check if customerSearch function works correctly.
		 */
		
		try {
			CustomerSearch search = new CustomerSearch();
			assertEquals("2 Jim Mingerly 1998-01-01 34 WN4 3DS Active 7541256487 JM@jimmy.com 0", search.searchCustomer("", " ", 2));
			System.out.println("\n" + "Customer Search Succesful -- correct data -- test - Passed");
				
		} catch(Exception exc) {
			System.out.println("Customer Search Fail -- correct data -- test - Failed");
		}
		
	}	

}
