package com.qa.nbg_ims.service;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.qa.nbg_ims.dabaseconnectors.ConnectionManager;
import com.qa.nbg_ims.entities.Product;

public class SearchFunction {

	ArrayList<Product> productList = new ArrayList<Product>();
	ArrayList<Product> productListSorted;
	String[] searchTerms;

	// JComboBox<String> categoryBox;
	// JTextField searchBar;
	// JTextField priceLowBox;
	// JTextField priceHighBox;
	// JFrame demoSearcher = new JFrame();
	//
	public SearchFunction() {

	}

	public void demoSearch(){
//		
//		//Create a GUI to input search terms
//		demoSearcher.setTitle("Demonstration Search Bar");
//		JPanel top = new JPanel();
//		demoSearcher.add(top, BorderLayout.NORTH);
//		JLabel demoInstruction = new JLabel("Search within:");
//		top.add(demoInstruction, BorderLayout.WEST);
//		JPanel mid = new JPanel();
//		demoSearcher.add(mid, BorderLayout.CENTER);
		String[] categories = new String[] {"Gnomes", "Plants and Seeds", "Garden Tools", "Furnature", "Pools and Hot-tubs", "Garden Care"};
//		categoryBox = new JComboBox<String>(categories);
//		categoryBox.setPreferredSize(new Dimension (150, 30));
//		mid.add(categoryBox);
//		searchBar = new JTextField("Search");
//		searchBar.setPreferredSize(new Dimension (400, 30));
//		mid.add(searchBar);
//		JButton go = new JButton("GO");
//		go.setPreferredSize(new Dimension (51, 30));
//		mid.add(go);
//		JPanel bot = new JPanel();
//		demoSearcher.add(bot, BorderLayout.SOUTH);
//		bot.add(new JLabel("For products between �"));
//		priceLowBox = new JTextField("0.00");
//		bot.add(priceLowBox);
//		bot.add(new JLabel(" and �"));
//		priceHighBox = new JTextField("10000.00");
//		bot.add(priceHighBox);
//		demoSearcher.pack();
//		demoSearcher.setVisible(true);
//		go.addActionListener(new ActionListener(){
			
//			//add an action listener to initiate searches
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				String category = (String) categoryBox.getSelectedItem();
//				String searchLine = searchBar.getText();
//				String priceLow = priceLowBox.getText();
//				String priceHigh = priceHighBox.getText();
				try {
					search(category, searchLine, priceLow, priceHigh);
				}
				catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

	// demoSearcher.dispose();
	// }
	// });
	// }
	// begin search
	public void search(String cat, String search, String priceLow, String priceHigh) throws SQLException{	
		
		
		String searchLine = "'";
		//split the search term into an array of terms
		searchTerms = search.split(" ");
		
		//create a search line checking for any of the searched terms	
		for (String searchTerm: searchTerms){
			searchLine = searchLine + searchTerm + "|";
		}
		
		//if searching a department creates that part of the SQ
		String category ="";
		if (cat != "ALL")
		{
			category = "Category = '" + cat + "' and"; 
		}
		
		//This is the query that will run
		String select = "select idProduct, Name, Description, Category, Weight, Price, ProductStatus, ProductStockQuantity, DefaultStockLevel, MinimumStockLevel, Review"
				+ " from product WHERE " + category + " Description REGEXP " + searchLine + "Squiggle' and price < " + scan(priceHigh, "high") + " and price > " + scan(priceLow, "low") +";";
		
		System.out.println(select);		
//		
//		//create an SQL connection and apply search line
//		ConnectionManager.connect();
//		Statement stmt = null;
//		ResultSet rs = null;
//		try {
//			stmt = ConnectionManager.conn.createStatement();
//		}
//		catch (SQLException e) {
//			e.printStackTrace();
//		}
//		
//		try {
//			 rs = stmt.executeQuery(select);
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}	
//		
//		
//		while (rs.next()){
//
//			int productID = rs.getInt("idProduct");
//			String name = rs.getString("Name");
//			String description = rs.getString("Description");
//			//String category = rs.getString("Category");
//			double weight = rs.getDouble("Weight");
//			double price = rs.getDouble("Price");
//			String productStatus = rs.getString("ProductStatus");
//			int quantityInStock = rs.getInt("ProductStockQuantity");
//			int defaultStockQuantity = rs.getInt("DefaultStockLevel");
//			int minimumStockLevel = rs.getInt("MinimumStockLevel");
//			int review = rs.getInt("Review");
//			
			
			//adds all the products to a list
			productList.add(new Product(productID, name, description, category, weight, price, productStatus, quantityInStock,  defaultStockQuantity, minimumStockLevel, review));
			
		}

	// prints out product names, not needed for final product
	for(

	Product p:productList)
	{
		System.out.println(p.getName());
	}

	}

	public void sort(){
		int relevanceMax = 0;
		for (Product product: productList){
			
			int relevance = 0;
		
			for(String term: searchTerms){
				if (product.name.contains(term)){
					relevance++;
				}	
				if (product.description.contains(term)){
					relevance++;
				}
			}
				product.setRelevance(relevance);
				if (relevance > relevanceMax) {
					relevanceMax = relevance;
				}
		}
		for (int i = relevanceMax; i>0 ; i--){
			for (Product product: productList){
				int relevance = product.getRelevance();
				if (relevance == relevanceMax){
					productListSorted.add(product);
				}
			}
		}	
	}
//
//
//
// public double scan(String textBox, String highLow){
// double x = 0;
// try{
// x = Double.parseDouble(textBox);
// }
// catch(NumberFormatException a){
// if (highLow.equals("high")){
// x = 10000;
// }
// else if (highLow.equals("low")){
// x = 0;
// }
// }
// return x;
// }
// }