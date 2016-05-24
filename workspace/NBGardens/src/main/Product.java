package main;
public class Product {
	int productID;
	String name;
	String description;
	String category;
	double weight;
	double price;
	String productStatus;
	int quantityInStock;
	int defaultStockQuantity;
	String minimumStockLevel;
	int Review;
	
	
	
	public Product(int productID, String name, String description, String category, double weight, double price, String productStatus, int quantityInStock,  int defaultStockQuantity, String minimumStockLevel, int Review) 
	{
		this.productID = productID;
		this.name = name;
		this.description = description;
		this.category = category;
		this.weight = weight;
		this.price = price;
		this.quantityInStock = quantityInStock;
		this.defaultStockQuantity = defaultStockQuantity;
		this.minimumStockLevel = minimumStockLevel;
		this.Review = Review;
	}
	
	
	
	
	public int getproductID() {
		return productID;
	}
	public String getName() {
		return name;
	}
	public String getDescription() {
		return description;
	}
	public String getCategory() {
		return category;
	}
	public double getWeight() {
		return weight;
	}
	public double getPrice() {
		return price;
	}
	public String getProductStatus() {
		return productStatus;
	}
	public int getQuantityInStock() {
		return quantityInStock;
	}
	public int getDefaultStockQuantity() {
		return defaultStockQuantity;
	}
	public String getMinimumStockLevel() {
		return minimumStockLevel;
	}
}