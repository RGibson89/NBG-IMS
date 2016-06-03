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
import javax.validation.constraints.Size;

import com.qa.nbg_ims.util.ProductStatus;

@Entity
@Table(name="product")
@NamedQueries({
	@NamedQuery(name=Stock.FIND_BY_STATUS, query="SELECT p WHERE p.status = :status"),
	@NamedQuery(name=Stock.FIND_BY_LOW_STOCK, query="SELECT p WHERE p.availibleStock <= p.minimumStock")
})
public class Stock {
	public static final String FIND_BY_STATUS = "Stock.findByStatus";
	public static final String FIND_BY_LOW_STOCK = "Sock.findByLowStock";
	@Id
	@NotNull
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="productID", nullable=false, unique=true)
	private long productID;
	@NotNull
	@Column(name="price", nullable=false)
	private double price;
	@NotNull
	@Size(min=5, max=12)
	@Column(name="status", nullable=false, length=12)
	private ProductStatus productStatus;
	@NotNull
	@Column(name="actualStock", nullable=false)
	private int acualStock;
	@NotNull
	@Column(name="availibleStock", nullable=false)
	private int availibleStock;
	@NotNull
	@Column(name="minimumStock", nullable=false)
	private int minimumStockLevel;
	
	public Stock(long productID, double price, ProductStatus productStatus, int acualStock, int availibleStock,
			int minimumStockLevel) {
		this.productID = productID;
		this.price = price;
		this.productStatus = productStatus;
		this.acualStock = acualStock;
		this.availibleStock = availibleStock;
		this.minimumStockLevel = minimumStockLevel;
	}

	public Stock(double price, ProductStatus productStatus, int acualStock, int availibleStock, int minimumStockLevel) {
		this.price = price;
		this.productStatus = productStatus;
		this.acualStock = acualStock;
		this.availibleStock = availibleStock;
		this.minimumStockLevel = minimumStockLevel;
	}
	
	public Stock() { }

	public long getProductID() {
		return productID;
	}

	public double getPrice() {
		return price;
	}

	public ProductStatus getProductStatus() {
		return productStatus;
	}

	public int getAcualStock() {
		return acualStock;
	}

	public int getAvailibleStock() {
		return availibleStock;
	}

	public int getMinimumStockLevel() {
		return minimumStockLevel;
	}

	public void setProductID(long productID) {
		this.productID = productID;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public void setProductStatus(ProductStatus productStatus) {
		this.productStatus = productStatus;
	}

	public void setAcualStock(int acualStock) {
		this.acualStock = acualStock;
	}

	public void setAvailibleStock(int availibleStock) {
		this.availibleStock = availibleStock;
	}

	public void setMinimumStockLevel(int minimumStockLevel) {
		this.minimumStockLevel = minimumStockLevel;
	}
}