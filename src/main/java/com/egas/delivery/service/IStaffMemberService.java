package com.egas.delivery.service;

import java.util.List;
import java.util.Map;

import com.egas.delivery.entity.CustomerAccessoriesBooking;
import com.egas.delivery.entity.CustomerGasBooking;
import com.egas.delivery.entity.Staff_Member;

public interface IStaffMemberService {

public List<Staff_Member> getAllStaffMember();
	
	public Staff_Member saveStaffMember(Staff_Member staffmember);
	
	public Staff_Member updateStaffMember(Map<String,String> updateData);
	
	public boolean staffMemberLogin(String pancardNumber,String password);
	
	public List<CustomerGasBooking> getAllCustomerGasBooking();
	
	public List<CustomerGasBooking> findByCustCity(String custCity);
	
	public List<CustomerAccessoriesBooking> getAllCustomerAccessoriesBooking();
	
	public List<CustomerAccessoriesBooking> findByCustBookingCity(String custBookingCity);
	
	public CustomerGasBooking updateGasDeliveryStatus(Map<String,String> updateData);
	
}
