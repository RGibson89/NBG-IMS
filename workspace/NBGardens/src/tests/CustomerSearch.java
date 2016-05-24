package tests;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import com.sun.org.apache.regexp.internal.recompile;

public class CustomerSearch{
	
	
	
	public static String searchCustomer(String forename, String surname, int customerID) throws ParseException{
		
		String fail = "Customer search has failed";
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
	
	//
	String search = "Select * From customer where Forename = '" + forename +"' && Surname = '"+ surname +"' OR idCustomer = '"+customerID+"';";	
 
	 
	 try {
		rs = stmt.executeQuery(search);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		System.out.println(e);
	}
 
 //Saves results from query into variables 
	try{
		while(rs.next()){
			
			int id = rs.getInt("idCustomer");
			String fName = rs.getString("Forename");
			String sName = rs.getString ("Surname");
			String DoB = rs.getString("DoB");
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
			java.util.Date date = sdf.parse(DoB);
		    java.sql.Date sqlDate = new Date(date.getTime());
		    String houseN = rs.getString("Address_HouseNumber_Name");
			String postcode = rs.getString("Address_Postcode");
			String status = rs.getString("Status");
			String phoneNum= rs.getString("ContactPhone");
			String email = rs.getString("Email");
			int credit = rs.getShort("OutstandingCredit");
			
		    
			//prints results
			String customerResult = (id +" "+ fName +" "+ sName +" "+ sqlDate +" "+ houseN +" "+ postcode +" "+ status +" "+ phoneNum +" "+ email +" "+ credit);
			System.out.println(customerResult);
			return customerResult;
			
		}
		}
		
		catch (SQLException e) 
		{
			//prints exception and fail string
		System.out.println(e);
		System.out.println(fail);
		return fail;
		}
	
	
return fail;
	}
		
	
	

	
}
