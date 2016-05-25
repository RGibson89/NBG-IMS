package main;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.sql.Statement;
import java.util.ArrayList;

public class SearchFunction {
	
	ArrayList<Product> productList;
	String[] searchTerms;
	
	JComboBox<String> categoryBox; 
	JTextField searchBar;
	JTextField priceLowBox;
	JTextField priceHighBox;
	
	public void demoSearch(){
		
		//Create a GUI to input search terms
		JFrame demoSearch = new JFrame();
		demoSearch.setTitle("Demonstration Search Bar");
		JPanel top = new JPanel();
		demoSearch.add(top, BorderLayout.NORTH);
		JLabel demoInstruction = new JLabel("Search within:");
		top.add(demoInstruction, BorderLayout.WEST);
		JPanel mid = new JPanel();
		demoSearch.add(mid, BorderLayout.CENTER);
		String[] categories = new String[] {"Gnomes", "Plants and Seeds", "Garden Tools", "Furnature", "Pools and Hot-tubs", "Garden Care"};
		categoryBox = new JComboBox<String>(categories);
		categoryBox.setPreferredSize(new Dimension (150, 30));
		mid.add(categoryBox);
		searchBar = new JTextField("Search");
		searchBar.setPreferredSize(new Dimension (400, 30));
		mid.add(searchBar);
		JButton go = new JButton("GO");
		go.setPreferredSize(new Dimension (51, 30));
		mid.add(go);
		JPanel bot = new JPanel();
		demoSearch.add(bot, BorderLayout.SOUTH);
		bot.add(new JLabel("For products between £"));
		priceLowBox = new JTextField("0.00");
		bot.add(priceLowBox);
		bot.add(new JLabel(" and £"));
		priceHighBox = new JTextField("10000.00");
		bot.add(priceHighBox);
		demoSearch.pack();
		demoSearch.setVisible(true);
		go.addActionListener(new ActionListener(){
			
			//add an action listener to initiate searches
			@Override
			public void actionPerformed(ActionEvent e) {
				String category = (String) categoryBox.getSelectedItem();
				String searchLine = searchBar.getText();
				String priceLow = priceLowBox.getText();
				String priceHigh = priceHighBox.getText();
				try {
					search(category, searchLine, priceLow, priceHigh);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}	
			}
		});
	}
	//begin search		
	public void search(String category, String search, String priceLow, String priceHigh) throws SQLException{	
		
		
		String searchLine = "";
		//split the search term into an array of terms
		searchTerms = search.split(" ");
		
		//create a search line checking for any of the searched terms	
		for (String searchTerm: searchTerms){
			searchLine = searchLine + searchTerm + "', or '";
		}
		String select = "select idProduct, Name, Description, Category, Weight, Price, ProductStatus, ProductStockQuantity, DefaultStockLevel, MinimumStockLevel, Review"
				+ " from PRODUCT WHERE Category = '" + category + "' and Description contains '" + searchLine + "' and WHERE price < " + scan(priceHigh, "high") + " and WHERE price > " + scan(priceLow, "low");
		
		System.out.println(select);		
		
		//create an SQL connection and apply search line
		Statement stmt = null;
		ResultSet rs = null;
		try {
			stmt = ConnectionManager.conn.createStatement();
		}
		catch (SQLException e) {
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
			//String category = rs.getString("Category");
			double weight = rs.getDouble("Weight");
			double price = rs.getDouble("Price");
			String productStatus = rs.getString("ProductStatus");
			int quantityInStock = rs.getInt("ProductStockQuantity");
			int defaultStockQuantity = rs.getInt("DefaultStockLevel");
			String minimumStockLevel = rs.getString("MinimumStockLevel");
			int Review = rs.getInt("Review");
			
			Product product = new Product(productID, name, description, category, weight, price, productStatus, quantityInStock,  defaultStockQuantity, minimumStockLevel, Review);
			productList.add(product);
		}
	}
	
	public double scan(String textBox, String highLow){
		double x;
		//try{
			x = Double.parseDouble(textBox);
		//}
		//catch(NumberFormatException){
		//  	if (highLow.equals("high")){
		// 		x = 10000;
		//	}
		//  	else if (highLow.equals("low")){
		//  		x = 0;
		//  	}	
	//	}
		return x;
	}
}
