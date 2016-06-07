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

@Entity
@Table(name="supplier")
public class Supplier {

	@Id
	@NotNull
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="idSupplier", nullable=false, unique=true)
	private long idManufactuer;
	
	@NotNull
	@Column(name="Address_HouseNumber_Name", nullable=false)
	private String ManufactuerPhone;
	
	@NotNull
	@Column(name="Manufactuer Email", nullable=false)
	private long ManufactuerEmail;
	

	public Supplier(long idManufactuer, String ManufactuerPhone, long ManufactuerEmail) {
		this.idManufactuer = idManufactuer;
		this.ManufactuerPhone = ManufactuerPhone;
		this.ManufactuerEmail = ManufactuerEmail;
	}


	public long getIdManufactuer() {
		return idManufactuer;
	}


	public void setIdManufactuer(long idManufactuer) {
		this.idManufactuer = idManufactuer;
	}


	public String getManufactuerPhone() {
		return ManufactuerPhone;
	}


	public void setManufactuerPhone(String manufactuerPhone) {
		ManufactuerPhone = manufactuerPhone;
	}


	public long getManufactuerEmail() {
		return ManufactuerEmail;
	}


	public void setManufactuerEmail(long manufactuerEmail) {
		ManufactuerEmail = manufactuerEmail;
	}

	
	
}
