package tests;


import static org.junit.Assert.*;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;


public class NBGTests {

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
	public void checkCorrectLogin() {
		/*
		 * Tests to check if login authentification returns works correctly
		 */
		
		try {
			CustomerLogin checkLogin = new CustomerLogin();
			assertEquals(3, checkLogin.login("harryR@gmail.com", "Harry123"));
			System.out.println("Login auth -- correct data -- test - Passed");
				
		} catch(Exception exc) {
			System.out.println("Login auth -- correct data -- test - Failed");
		}
		
	}
	
	@Test
	public void checkIncorrectLogin() {
		/*
		 * Tests to check if login authentification denies
		 */
		
		try {
			CustomerLogin checkLogin = new CustomerLogin();
			assertNotEquals(3, checkLogin.login("harryR@ail.com", "Harry123"));
			System.out.println("Login auth -- incorrect data -- test - Passed");
		} catch(Exception exc) {
			System.out.println("Login auth -- incorrect data -- test - Failed");
		}
	}
	
	@Test
	public void checkRegistration(){
		/*
		 * Tests to check if a customer is added when the register command completes
		 */
		Statement stmt = null;
		ResultSet rs = null;
		try {
			stmt = ConnectionManager.conn.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			CustomerController checkRegister = new CustomerController();
			assertEquals(1,checkRegister.register("James", "Farrell", "1992-01-21", "1", "PP4 IC1", "West Midlands", "true", "07011111111", "james@farrell.com", "M", "hello"));
			
				
			System.out.println("Registration auth -- correct data -- test - Passed");
			String select2 = "DELETE FROM customer WHERE email =  'james@farrell.com'";
			String select3 = "DELETE FROM address WHERE postcode =  'PP4 IC1'";
			try {
				stmt.executeUpdate(select2);
				stmt.executeUpdate(select3);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				
			}
			
				
		} catch(Exception exc) {
			System.out.println("Registration auth -- correct data -- test - Failed");
		}

		

		
	}

	
	
}