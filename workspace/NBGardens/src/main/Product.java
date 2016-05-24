public class Product {
int productID;
String name;
String description;
String catagory;
double weight;
double price;
String productStatus;
int quantityInStock;
int defaultStockQuantity;
String minimumStockLevel;



public Product(int productID, String name, String description, String catagory, double weight, double price, String productStatus, int quantityInStock,  int defaultStockQuantity, String minimumStockLevel) 
{
	this.productID = productID;
	this.name = name;
	this.description = description;
	this.catagory = catagory;
	this.weight = weight;
	this.price = price;
	this.quantityInStock = quantityInStock;
	this.defaultStockQuantity = defaultStockQuantity;
	this.minimumStockLevel = minimumStockLevel;
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
public String getCatagory() {
	return catagory;
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
