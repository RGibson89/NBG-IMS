import java.sql.ResultSet;
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
		for (String b : keyWordBox){
			searchLine = searchLine + "'" + keyWordBox[h] + "' or ";
			h++;
		}
		searchLine = searchLine + "''";
		
	String stmt = "select Name, Description, Catagory, Weight, Price, Product_status  from PRODUCT WHERE description contains "
			+ searchLine + "' and WHERE price < " + scan(priceHighBox, "high") + " and WHERE price > " + scan(priceLowBox, "low");
	
	
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
