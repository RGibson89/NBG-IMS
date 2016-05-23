import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.lang.String;

public class CustomerController {

	private int idCustomer;                                                                                                                  
	private String forename;
	private int credit;
	private String status;


	//TODO - constructors
	//comment so this is changed for git purposes, can be removed


	public int login (String email, String password)
	{	
		ConnectionManager connect = new ConnectionManager();
		//NB - close statements and resultsets after use
		Statement stmt = null;
		ResultSet rs = null;
		int passwordHash = password.hashCode();
		
		try {
			connect.connect();
			stmt = connect.conn.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//fucking insecure
		//String select = "SELECT Login Password FROM mydb.online Login Details where Login email = " + email + ";";
		
		String select = "SELECT `Customer_idCustomer` FROM `customer login details` WHERE `Login email` = \"" + email + "\" AND `Login password` "
				+ "= \"" + password + "\"";
		
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
	
	
	public void logout()
	{
	
		this.idCustomer = 0;
		this.forename = null;
		this.credit = 0;
		this.status = null;
	
	}
	
	public int register(String forename, String surname, String _DoB, String houseNumber, String postcode, String creditCheck, String phoneNumber, String emailAddress, String gender, String password){
		
	Statement stmt = null;
	ResultSet rs = null;
	int passwordHash = password.hashCode();
	
	try {
		stmt = ConnectionManager.conn.createStatement();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	Date date = new Date();
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy/mm/dd");
	String formattedDate = sdf.format(date);
	String select = "INSERT INTO Customer VALUES ( , "+ forename + ", "+ surname + ", "+ _DoB + ", "+ houseNumber + ", "+ postcode + ", "+ creditCheck + ", \"active\", "+ phoneNumber + ", "+ emailAddress + ", 10000, "+ gender + ", "+ forename + ", " + formattedDate + ", " + passwordHash + ")" ;
	
	try {
		rs = stmt.executeQuery(select);
		System.out.println("Thank you " + forename + " for joining NB Gardens!");
		return 1;
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		return 0;
	}
}
	
	
	
	public int checkCredit()
	{
	
		return this.credit;
	
	}
}
