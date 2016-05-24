
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CustomerLogin {

	public static int login (String email, String password)
	{
	
		//NB - close statements and resultsets after use
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			stmt = ConnectionManager.conn.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//fucking insecure
		//String select = "SELECT Login Password FROM mydb.online Login Details where Login email = " + email + ";";
		
		String select = "SELECT IDcustomer FROM mydb.online Login Details where Login email = " + email + " Login Password = " + password + ";";
		
		
		
		try {
			 rs = stmt.executeQuery(select);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			
			if (!rs.isBeforeFirst())
			{
				//this triggers if the email and password don't match, translate the returned int in the calling class
				//"Login failed, incorrect username or password.";
				return 0;
			}
			
			else 
			{
				 int customerID = rs.getInt("IDCustomer");
				 return customerID;
			}
			
		} 
		
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//nb - close connections
		
		//This shouldn't trigger, just there so there is a return
		//"Something has gone wrong with logging in";
		return -1;
		
	}
	
	
}
