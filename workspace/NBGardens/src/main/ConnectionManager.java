
import java.sql.*;


public class ConnectionManager {

	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost/myDB";
	
	static final String USER = "root";
	static final String PASS = "1234";
	
	static Connection conn = null;
	static Statement stmt = null;
	static ResultSet rs = null;
	
	
	//this opens the connection
	public static void connect() 
	{
		  
	  
	  try 
	  {
	    Class.forName("com.mysql.jdbc.Driver");
	    conn = DriverManager.getConnection( DB_URL, USER, PASS);
	    System.out.println("Connected to database");
	    System.out.println();
	    
	    
	    
	  } 
	  catch (SQLException sqle) 
	  {
		  sqle.printStackTrace();
		  
		} 
	  catch (Exception e) 
	  {
		  e.printStackTrace();
		  
		}
	  
	  
 
	}
		  
		  
		  
		  
	//this closes the statement	  
	public static void closeStatement()	  
		  
	{
		  
		
		try 
		  {
		    if (stmt != null)
		     stmt.close();
		    
		  } 
		  
		  catch (SQLException se) 
		  { 
			  
		  }
		
	}
		  
	//this closes the results	  
	public static void closeResults()	  
			  
		{
		
		  try 
		  {
		    if (rs != null)
		     rs.close();
		    
		  } 
		  
		  catch (SQLException se) 
		  { 
			  
		  }
		  
		}
	
	
	//this closes the connection	  
	public static void closeConnect()	  
			  
	{
		  
		  try 
		  {
		    if (conn != null)
		    	conn.close();
		    	conn = null;
		    	System.out.println();
				System.out.println("see ya");
		  }
		  
		  catch (SQLException se) 
		  {
		    se.printStackTrace();
		  }
		
		  

	}
	
}