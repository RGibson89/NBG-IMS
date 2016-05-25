package src.main;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class Search {
	
	
	
	public void search(){
	
		int boxes = 1;
		//Textbox on UI for keyword, checkbox to declare keyword mandetory, button to create another set thereof. 
		//When button pressed: boxes++, create new textBox (label: <boxes>), create new checkbox (label: <boxes>),
		//add to textBoxArrayList at posistion [boxes] and to checkBoxArrayList at position [boxes]. 
		String[] vitalWordBox = new String [boxes];
		String[] keyWordBox = new String [boxes];
		for (int i=1; 1<=boxes; i++){
			int j = 1;
			int k = 1;
			String query = textBoxArrayList[i].read();
			
			if(query.trim().equals("")){
			}
			else{
				if (checkBoxArrayList[i]){
					vitalWordBox[j] = query;
					j++;
				}
				else{
				keyWordBox[k] = "or";
				k++;
				}
			}
		}	
		String searchLine = "";
		int h = 1;
		for (String a : vitalWordBox){
			searchLine = searchLine + "'" + vitalWordBox[h] + "' and ";
			h++;
		}
		h = 1;
		searchLine = searchLine + "(";
		for (String b : keyWordBox){
			searchLine = searchLine + "'" + keyWordBox[h] + "' or ";
			h++;
		}
		searchLine = searchLine + "'')";
		
	String select = "select idProduct, Name, Description, Category, Weight, Price, ProductStatus, ProductStockQuantity, DefaultStockLevel, MinimumStockLevel, Review from PRODUCT WHERE description contains "
			+ searchLine + "' and WHERE price < " + scan(priceHighBox, "high") + " and WHERE price > " + scan(priceLowBox, "low");
	
	Statement stmt = null;
	ResultSet rs = null;
	
	try {
		stmt = ConnectionManager.conn.createStatement();
	} catch (SQLException e) {
		e.printStackTrace();
	}
	
	try {
		 rs = stmt.executeQuery(select);
	} catch (SQLException e) {
		e.printStackTrace();
	}	
	
	while (rs.next());{
		int productID = rs.getInt("idProduct");
		String name = rs.getString("Name");
		String description = rs.getString("Description");
		String category = rs.getString("Category");
		double weight = rs.getDouble("Weight");
		double price = rs.getDouble("Price");
		String productStatus = rs.getString("ProductStatus");
		int quantityInStock = rs.getInt("ProductStockQuantity");
		int defaultStockQuantity = rs.getInt("DefaultStockLevel");
		String minimumStockLevel = rs.getString("MinimumStockLevel");
		int Review = rs.getInt("Review");
		
		Product product = new Product(int productID, String name, String description, String category, double weight, double price, String productStatus, int quantityInStock,  int defaultStockQuantity, String minimumStockLevel, int Review)
	}
	
	}
	public double scan(TextBox textBox, String highLow){
		try{
		x = parsedouble(read.textbox);
		return x;
		}
		catch(NumberFormatException){
		  	if (highLow.equals("high")){
		 		return 10000;
			}
		  	else if (highLow.equals("low")){
		  		return 0;
		  	}	
		}
	}
}
//	
//	'" + keywordBox[ + "' " + check(keyword1andor) + " '" + read(keywordBox2) + "' " + check(keyword2andor) + " '" read(keywordBox3) + "' " + check(keyword1andor) + " '" + read(keywordBox4)
//	+ 


	
/*calling code
 * Arraylist<String>[] query;
 * 
 * 
 * read(keywordBox1)
 * read(keywordBox2)
 * read(keywordBox3)
 * read(keywordBox4)
 * 
 * public void read(textBox){
 *	String query = scan.textbox
 * 	if(query.trim().equals("")){
 *	}
 * 	else {
 * 		searchKeywords.add(query);
 * 	}
 * }
 * double priceLow = scan(priceLowBox, low);
 * double priceHigh = scan(priceHighBox, high);
 * 
 * public double scan(TextBox textBox, String highLow){
 * 	try{
 * 		x = parsedouble(read.textbox);
 * 		return x;
 * 	}
 * 		catch(NumberFormatException){
 * 		if (highLow.equals("high")){
 * 			return 10000;
 * 		}
 * 		else if (highLow.equals("low")){
 * 			return 0;
 * 		}
 * String catagory = read.catagoryBox();
 * AdvancedSearch (query, priceLow, priceHigh, catagory);
 */
