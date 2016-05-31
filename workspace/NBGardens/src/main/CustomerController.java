package main;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.lang.String;
import java.math.BigDecimal;

public class CustomerController {

	private int idCustomer;                                                                                                                  
	private String forename;
	private int credit;
	private String status;
	private ArrayList basket = new ArrayList();


	//TODO - constructors
	//comment so this is changed for git purposes, can be removed


	public void login (String email, String password)
	{			
		//NB - close statements and resultsets after use
		Statement stmt = null;
		ResultSet rs = null;
		int passwordHash = password.hashCode();
		
		try {
			stmt = ConnectionManager.conn.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//fucking insecure
		//String select = "SELECT Login Password FROM mydb.online Login Details where Login email = " + email + ";";
		
		String select = "SELECT IDcustomer FROM mydb.online Customer WHERE Email = " + email + " AND CustomerPassword = " + passwordHash + ";";
		
		
		
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
				 this.idCustomer = rs.getInt("IDCustomer");
				 
				 System.out.println("Login successful");
				 //maybe say welcome name
				 //search customer db for idCustomer and return name
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
	
		this.idCustomer = 0;
		this.forename = null;
		this.credit = 0;
		this.status = null;
	
	}
	
	public void register(String forename, String surname, Date _DoB, String houseNumber, String postcode, String creditCheck, String status, String phoneNumber, String emailAddress, String gender, String password){
		
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
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	
	public int checkCredit()
	{
	
		return this.credit;
	
	}

	public void addToBasket(int idProduct){
		basket.add(idProduct);
	}
	
	public void addToWishlist(int idProduct, int quantity){
		
		Statement stmt = null;
		ResultSet rs = null;
		int idOrder = 0;
		BigDecimal price = null;
		double weight = 0.00;
		try {
			stmt = ConnectionManager.conn.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String select = "SELECT idOrder FROM customerorder WHERE Customer_idCustomer = " + idCustomer + "AND wishlist = 1" ;
		
		try {
			rs = stmt.executeQuery(select);
			idOrder = rs.getInt("idOrder");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String select1 = "SELECT Price FROM Product WHERE idProduct = " + idProduct;
		
		try {
			rs = stmt.executeQuery(select1);
			price = rs.getBigDecimal("Price");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String select2 = "SELECT Weight FROM Product WHERE idProduct = " + idProduct;
		
		try {
			rs = stmt.executeQuery(select2);
			weight = rs.getDouble("Weight");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String insert = "INSERT INTO customerorderline VALUES (, "+ idOrder + ", "+ idProduct + ","+ quantity + ","+ price + ","+ weight + ") WHERE `Customer Order_idOrder` = " + idOrder;
		
		try {
			stmt.executeUpdate(insert);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void viewBasket(){
		
		Statement stmt = null;
		ResultSet rs = null;
		String productName;
		BigDecimal productPrice;
		String productDescription;

		try {
			stmt = ConnectionManager.conn.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (int i=0; i<basket.size();i++)
		{
			String select = "SELECT Name FROM product WHERE idProduct = " + basket.get(i);
			
			try {
				rs = stmt.executeQuery(select);
				productName = rs.getString("Name");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			String select1 = "SELECT Price FROM product WHERE idProduct = " + basket.get(i);
			
			try {
				rs = stmt.executeQuery(select1);
				productPrice = rs.getBigDecimal("Price");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			String select2 = "SELECT Description FROM product WHERE idProduct = " + basket.get(i);
			
			try {
				rs = stmt.executeQuery(select2);
				productDescription = rs.getString("Name");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}
	
	public void viewWishlist(){
		
		
	}
	
	public void moveWishlistToBasket(){
		
	}
	
	public void processPayment(){
		
	}
	
}
