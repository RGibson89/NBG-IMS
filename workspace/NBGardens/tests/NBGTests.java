package tests;

import static org.junit.Assert.*;

import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.*;

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
	
}
		