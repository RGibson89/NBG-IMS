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
@Table(name="Address")
public class Address {

	@Id
	@NotNull
	@Column(name="postcode", nullable=false)
	private String postcode;
	
	@NotNull
	@Column(name="houseNumber", nullable=false)
	private int houseNumber;
	
	@NotNull
	@Column(name="addressLine2", nullable=false)
	private String addressLine2;
	
	@NotNull
	@Column(name="addressLine3", nullable=false)
	private String addressLine3;
	
	public Address(String postcode, int houseNumber, String addressLine2, String addressLine3) {
		this.postcode = postcode;
		this.houseNumber = houseNumber;
		this.addressLine2 = addressLine2;
		this.addressLine3 = addressLine3;
	}

	public String getPostcode() {
		return postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	public int getHouseNumber() {
		return houseNumber;
	}

	public void setHouseNumber(int houseNumber) {
		this.houseNumber = houseNumber;
	}

	public String getAddressLine2() {
		return addressLine2;
	}

	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}

	public String getAddressLine3() {
		return addressLine3;
	}

	public void setAddressLine3(String addressLine3) {
		this.addressLine3 = addressLine3;
	}
	
	
}
