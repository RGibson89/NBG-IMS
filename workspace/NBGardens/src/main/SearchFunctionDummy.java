//this is a dummy function to search the searchFunction

package main;

import java.sql.SQLException;

public class SearchFunctionDummy {

	public static void main(String[] args) {
	

		
		SearchFunction searchM = new SearchFunction();
		
		try {
					//category, description keywords, price in, price max
			searchM.search("Gnome", "Girl Snow", "0", "1000");
			
			//NB - What if user searches for | or ;? sanitise inputs
			
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
		
		
		
		
	}

}
