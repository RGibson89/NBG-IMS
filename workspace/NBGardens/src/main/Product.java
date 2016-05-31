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
	int minimumStockLevel;
	int review;
	int relevance;
	




	public Product(int productID, String name, String description, String category, double weight, double price, String productStatus, int quantityInStock,  int defaultStockQuantity, int minimumStockLevel, int review) 
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
		this.review = review;
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
	public int getMinimumStockLevel() {
		return minimumStockLevel;
	}	
	public int getRelevance() {
		return relevance;
	}
public void setRelevance(int relevance) {
		this.relevance = relevance;
	}
	public int getReview() {
		return review;
	}

}