package com.qa.nbg_ims.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="product")
@NamedQueries({
	@NamedQuery(name=Product.FIND_BY_ID , query="SELECT p WHERE p.productID = :id"),
	@NamedQuery(name=Product.FIND_BY_NAME , query="SELECT p WHERE p.name = :name"),
	@NamedQuery(name=Product.FIND_BY_DESCRIPTION , query="SELECT p WHERE p.description = :description")
})
public class Product {
	
	public static final String FIND_BY_ID = "Product.findById";
	public static final String FIND_BY_NAME = "Product.findByName";
	public static final String FIND_BY_DESCRIPTION = "Product.findByDescription";

	@Id
	@NotNull
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="productID", nullable=false, unique=true)
	long productID;
	
	@NotNull
	@Column(name="name", nullable=false, unique=false)
	String name;
	
	@NotNull
	@Column(name="description", nullable=false, unique=false)
	String description;
	
	@NotNull
	@Column(name="category", nullable=false, unique=false)
	String category;
	
	@NotNull
	@Column(name="weight", nullable=false, unique=false)
	double weight;
	
	@NotNull
	@Column(name="review", nullable=true, unique=false)
	float review;
	
	public Product(long productID, String name, String description, String category, double weight, float review) {
		this.productID = productID;
		this.name = name;
		this.description = description;
		this.category = category;
		this.weight = weight;
		this.review = review;
	}

	public long getProductID() {
		return productID;
	}

	public void setProductID(long productID) {
		this.productID = productID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public float getReview() {
		return review;
	}

	public void setReview(float review) {
		this.review = review;
	}
	
}

