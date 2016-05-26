package tests;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.lang.String;
import java.math.BigDecimal;
import java.util.ArrayList;

public class CustomerController {

	private int idCustomer;                                                                                                                  
	private String forename;
	private int credit;
	private String status;
	ArrayList wishList = new ArrayList();


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
		
		String select = "SELECT `Customer_idCustomer` FROM `Customer` WHERE `email` = \"" + email + "\" AND `password` "
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
				idCustomer = rs.getInt("Customer_idCustomer");
				return 1;
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
		return -1;
		
		//nb - close connections
		
		//This shouldn't trigger, just there so there is a return
		//"Something has gone wrong with logging in";
		
		
		
	}
	
	
	public void logout()
	{
	
		this.idCustomer = 0;
		this.forename = null;
		this.credit = 0;
		this.status = null;
	
	}
	
	public int register(String forename, String surname, String _DoB, String houseNumber, String postcode, String county, String creditCheck, String phoneNumber, String emailAddress, String gender, String password){
		
	Statement stmt = null;
	ResultSet rs = null;
	int passwordHash = password.hashCode();
	
	try {
		stmt = ConnectionManager.conn.createStatement();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	String select = "INSERT INTO address VALUES ( \""+ postcode + "\", \""+ houseNumber + "\", null, null, null, \""+ county + "\")" ;
	
	try {
		stmt.executeUpdate(select);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		return 0;
	}
	
	

	Date date = Calendar.getInstance().getTime();
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	String formattedDate = sdf.format(date);
	System.out.println(date);
	String select1 = "INSERT INTO customer VALUES ( null, \""+ forename + "\", \""+ surname + "\", \""+ _DoB + "\", \""+ houseNumber + "\", \""+ postcode + "\", "+ creditCheck + ", \"active\", \""+ phoneNumber + "\", \""+ emailAddress + "\", 10000, \""+ gender + "\", \"" + formattedDate + "\", " + passwordHash + ")" ;
	
	try {
		return stmt.executeUpdate(select1);
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
	
	public void createBasket(int idCustomer, String houseNumber, String postcode, boolean wishList){
		
		Statement stmt = null;
		ResultSet rs = null;
		BigDecimal pOrderValue = new BigDecimal(0.00);
		BigDecimal pOrderPaid = new BigDecimal(0.00);
		BigDecimal pOrderWeight = new BigDecimal(0.00);
		
		
		try {
			stmt = ConnectionManager.conn.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String select = "INSERT INTO customerorder VALUES ( ,\""+ idCustomer + "\", \""+ houseNumber + "\", \""+ postcode + "\", "+ pOrderValue + ", " + pOrderPaid + ", " + pOrderWeight + ", " + wishList + ")" ;
		
		try {
			stmt.executeUpdate(select);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		
		try {
			stmt = ConnectionManager.conn.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String select1 = "SELECT idOrder from customerOrder" ;
		
		try {
			stmt.executeQuery(select1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		
		
	}
	
	public void viewBasket(int idOrder){
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			stmt = ConnectionManager.conn.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String select = "SELECT * FROM customerorderline WHERE `Customer Order_idOrder` = " + idOrder;
		String select1 = "SELECT OrderValue FROM customer order";
		try {
			stmt.executeQuery(select);
			stmt.executeQuery(select1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
	}
	
	public void checkout(int idCustomer, int idOrder){
		
	}
	
	
	
	
}
