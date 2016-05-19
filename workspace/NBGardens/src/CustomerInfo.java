import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

public class CustomerInfo {

	private int customerID;                                                                                                                  
	private String forename;
	private int credit;
	private String status;

	//TODO - constructors
	//comment so this is changed for git purposes, can be removed


	public void login (String email, String password)
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
				//this triggers if the email and password don't match
				System.out.println("Login failed, incorrect username or password.");
			}
			
			else 
			{
				 this.customerID = rs.getInt("IDCustomer");
				 
				 System.out.println("Login successful");
				 //maybe say welcome name
				 //search customer db for customerID and return name
			}
			
		} 
		
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//nb - close connections
		
		//This shouldn't trigger, just there so there is a return
		System.out.println("Something has gone wrong with logging in");
		
		
	}
	
	
	public void logout()
	{
	
		this.customerID = 0;
		this.forename = null;
		this.credit = 0;
		this.status = null;
	
	}
	
	public void register(String forname, String surname, Date _DoB, String houseNumber, String postcode, String creditCheck, String status, String phoneNumber, String emailAddress){
		
		
		
		
	}
	
	
	public int checkCredit()
	{
	
		return this.credit;
	
	}
}
