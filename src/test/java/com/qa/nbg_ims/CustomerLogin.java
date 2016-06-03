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
		
		String select = "SELECT `idCustomer` from `customer` WHERE `Email` ='" + email + "';";	
		
		try {
			rs = stmt.executeQuery(select);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("AAAAAAAAAAA");
			e.printStackTrace();
			
		}
		
		try {
			
			while(rs.next()) {
				int customerID = rs.getInt("idCustomer");
				return customerID;
		}
			
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