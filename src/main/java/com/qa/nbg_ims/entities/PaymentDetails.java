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
@Table(name="paymentdetails")
public class PaymentDetails {

	@Id
	private long customerID;
	private long cardNumber;
	private String billingPostcode;
	private String cardExpiry;
	private String cardType;
	private int issueNumber;
	private String billingHouseNumber;
	
	public PaymentDetails(long customerID, long cardNumber, String billingPostcode,
			              String cardExpiry, String cardType, int issueNumber, String billingHouseNumber) {
		this.customerID = customerID;
		this.cardNumber = cardNumber;
		this.billingPostcode = billingPostcode;
		this.cardExpiry = cardExpiry;
		this.cardType = cardType;
		this.issueNumber = issueNumber;
		this.billingHouseNumber = billingHouseNumber;
	}
}
