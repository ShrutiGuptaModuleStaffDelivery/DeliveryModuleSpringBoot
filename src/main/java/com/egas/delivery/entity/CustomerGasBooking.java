package com.egas.delivery.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class CustomerGasBooking {

	@Id
	@GeneratedValue
	private Integer custGasId;
	private String custPancard;
	public String custFirstName;
	public String custLastName;
	public String custState;
	public String custCity;
	public String custAddress;
	public String custContact;
	public String custApply="Gas Cylinder";
	public String custGasBookingStatus="Approved";
	public String custGasDeliveryStatus="Pending";
	
	public CustomerGasBooking() {
		// TODO Auto-generated constructor stub
	}

	public CustomerGasBooking(String custPancard, String custFirstName, String custLastName, String custState,
			String custCity, String custAddress, String custContact) 
	{
		super();
		this.custPancard = custPancard;
		this.custFirstName = custFirstName;
		this.custLastName = custLastName;
		this.custState = custState;
		this.custCity = custCity;
		this.custAddress = custAddress;
		this.custContact = custContact;
	}
	
	public CustomerGasBooking(Integer custGasId,String custPancard, String custFirstName, String custLastName, String custState,
			String custCity, String custAddress, String custContact) 
	{
		super();
		this.custGasId=custGasId;
		this.custPancard = custPancard;
		this.custFirstName = custFirstName;
		this.custLastName = custLastName;
		this.custState = custState;
		this.custCity = custCity;
		this.custAddress = custAddress;
		this.custContact = custContact;
	}

	public Integer getCustGasId() {
		return custGasId;
	}

	public void setCustGasId(Integer custGasId) {
		this.custGasId = custGasId;
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

	public String getCustCity() {
		return custCity;
	}

	public void setCustCity(String custCity) {
		this.custCity = custCity;
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

	public String getCustGasBookingStatus() {
		return custGasBookingStatus;
	}

	public void setCustGasBookingStatus(String custGasBookingStatus) {
		this.custGasBookingStatus = custGasBookingStatus;
	}

	public String getCustGasDeliveryStatus() {
		return custGasDeliveryStatus;
	}

	public void setCustGasDeliveryStatus(String custGasDeliveryStatus) {
		this.custGasDeliveryStatus = custGasDeliveryStatus;
	}

	public String getCustApply() {
		return custApply;
	}

	public void setCustApply(String custApply) {
		this.custApply = custApply;
	}

	@Override
	public String toString() {
		return "custPancard=" + custPancard + ", custFirstName=" + custFirstName + ", custLastName="
				+ custLastName + ", custState=" + custState + ", custCity=" + custCity + ", custAddress=" + custAddress
				+ ", custContact=" + custContact + ", custApply=" + custApply + ", custGasBookingStatus="
				+ custGasBookingStatus + ", custGasDeliveryStatus=" + custGasDeliveryStatus;
	}
	
			
}
