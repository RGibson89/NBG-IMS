public class Product {
String name;
String description;
int productID;
int quantityInStock;
double weight;
double price;




public Product(String name, String description, int productID, int quantityInStock, double weight, double price) 
{
	this.name = name;
	this.description = description;
	this.productID = productID;
	this.quantityInStock = quantityInStock;
	this.weight = weight;
	this.price = price;
}





public String getName() {
	return name;
}
public String getDescription() {
	return description;
}
public int getproductID() {
	return productID;
}
public int getQuantityInStock() {
	return quantityInStock;
}
public double getWeight() {
	return weight;
}
public double getPrice() {
	return price;
}

}
