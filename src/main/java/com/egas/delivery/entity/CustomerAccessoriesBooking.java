package com.egas.delivery.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class CustomerAccessoriesBooking
{
	@Id
	@GeneratedValue
	private Integer custAccessoriesId;
	private String custPancard;
	public String custFirstName;
	public String custLastName;
	public String custState;
	public String custBookingCity;
	public String custAddress;
	public String custContact;
	public String custAccessories;
	public String custAccessoriesBookingStatus="Approved";
	public String custAccessoriesDeliveryStatus="Pending";
	
	public CustomerAccessoriesBooking() {
		// TODO Auto-generated constructor stub
	}

	public CustomerAccessoriesBooking(String custPancard, String custFirstName, String custLastName, String custState,
			String custBookingCity, String custAddress, String custContact, String custAccessories) 
	{
		super();
		this.custPancard = custPancard;
		this.custFirstName = custFirstName;
		this.custLastName = custLastName;
		this.custState = custState;
		this.custBookingCity = custBookingCity;
		this.custAddress = custAddress;
		this.custContact = custContact;
		this.custAccessories = custAccessories;
	}

	public Integer getCustAccessoriesId() {
		return custAccessoriesId;
	}

	public void setCustAccessoriesId(Integer custAccessoriesId) {
		this.custAccessoriesId = custAccessoriesId;
	}

	public String getCustPancard() {
		return custPancard;
	}

	public void setCustPancard(String custPancard) {
		this.custPancard = custPancard;
	}

	public String getCustFirstName() {
		return custFirstName;
	}

	public void setCustFirstName(String custFirstName) {
		this.custFirstName = custFirstName;
	}

	public String getCustLastName() {
		return custLastName;
	}

	public void setCustLastName(String custLastName) {
		this.custLastName = custLastName;
	}

	public String getCustState() {
		return custState;
	}

	public void setCustState(String custState) {
		this.custState = custState;
	}

	public String getCustBookingCity() {
		return custBookingCity;
	}

	public void setCustBookingCity(String custBookingCity) {
		this.custBookingCity = custBookingCity;
	}

	public String getCustAddress() {
		return custAddress;
	}

	public void setCustAddress(String custAddress) {
		this.custAddress = custAddress;
	}

	public String getCustContact() {
		return custContact;
	}

	public void setCustContact(String custContact) {
		this.custContact = custContact;
	}

	public String getCustAccessories() {
		return custAccessories;
	}

	public void setCustAccessories(String custAccessories) {
		this.custAccessories = custAccessories;
	}

	public String getCustAccessoriesBookingStatus() {
		return custAccessoriesBookingStatus;
	}

	public void setCustAccessoriesBookingStatus(String custGasBookingStatus) {
		this.custAccessoriesBookingStatus = custGasBookingStatus;
	}

	public String getCustAccessoriesDeliveryStatus() {
		return custAccessoriesDeliveryStatus;
	}

	public void setCustAccessoriesDeliveryStatus(String custGasDeliveryStatus) {
		this.custAccessoriesDeliveryStatus = custGasDeliveryStatus;
	}
}