package tests;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CustomerLogin {

	public static int login (String email, String password)
	{
	
		ConnectionManager connect = new ConnectionManager();
		//NB - close statements and resultsets after use
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			connect.connect();
			stmt = connect.conn.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//fucking insecure
		//String select = "SELECT Login Password FROM mydb.online Login Details where Login email = " + email + ";";
		
		String select = "SELECT `Customer_idCustomer` from `customer login details` WHERE `login email` ='" + email + "';";	
		
		try {
			 rs = stmt.executeQuery(select);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("AAAAAAAAAAA");
			e.printStackTrace();
			
		}
		
		try {
			
			while(rs.next()) {
				int customerID = rs.getInt("Customer_idCustomer");
				System.out.println(customerID);
				return customerID;
		}
			
			
			/*if (!rs.isBeforeFirst())
			{
				//this triggers if the email and password don't match, translate the returned int in the calling class
				//"Login failed, incorrect username or password.";
				return 0;
			}
			
			else 
			{
				 
			}*/
			
		} 
		
		catch (SQLException e) 
		{
		
			return 0;
		}
		
		//nb - close connections
		
		//This shouldn't trigger, just there so there is a return
		//"Something has gone wrong with logging in";
		return -1;
		
	}
	
	
}
