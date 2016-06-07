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
@Table(name="orderevent")
public class OrderEvent {

	@NotNull
	@Column(name="eventTime", nullable=false)
	private String eventTime;
	
	@NotNull
	@Column(name="orderID", nullable=false)
	private long orderID;
	
	@NotNull
	@Column(name="employeeID", nullable=false)
	private long employeeID;
	
	@NotNull
	@Column(name="eventDescription", nullable=false)
	private String eventDescription;
	
	public OrderEvent(String eventTime, long orderID, long employeeID, String eventDescription) {
		this.eventTime = eventTime;
		this.orderID = orderID;
		this.employeeID = employeeID;
		this.eventDescription = eventDescription;
	}

	public String getEventTime() {
		return eventTime;
	}

	public void setEventTime(String eventTime) {
		this.eventTime = eventTime;
	}

	public long getOrderID() {
		return orderID;
	}

	public void setOrderID(long orderID) {
		this.orderID = orderID;
	}

	public long getEmployeeID() {
		return employeeID;
	}

	public void setEmployeeID(long employeeID) {
		this.employeeID = employeeID;
	}

	public String getEventDescription() {
		return eventDescription;
	}

	public void setEventDescription(String eventDescription) {
		this.eventDescription = eventDescription;
	}
	
	
}
