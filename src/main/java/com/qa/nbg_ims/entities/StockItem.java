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
import java.math.BigDecimal;

import com.qa.nbg_ims.util.ProductStatus;

@Entity
@Table(name="stockItem")
public class StockItem {
	@Id
	@NotNull
	@Column(name="productID", nullable=false, unique=true)
	private long productID;
	@Id
	@NotNull
	@Column(name="manufacturerID", nullable=false, unique=true)
	private long manufacturerID;
	@NotNull
	@Size(min=5, max=12)
	@Column(name="costPrice", nullable=false, length=12)
	private BigDecimal costPrice;

	
	public StockItem(long productID, long manufacturerID, BigDecimal costPrice) {
		this.productID = productID;
		this.manufacturerID = manufacturerID;
		this.costPrice = costPrice;

	}


	public long getProductID() {
		return productID;
	}


	public void setProductID(long productID) {
		this.productID = productID;
	}


	public long getManufacturerID() {
		return manufacturerID;
	}


	public void setManufacturerID(long manufacturerID) {
		this.manufacturerID = manufacturerID;
	}


	public BigDecimal getCostPrice() {
		return costPrice;
	}


	public void setCostPrice(BigDecimal costPrice) {
		this.costPrice = costPrice;
	}
}


