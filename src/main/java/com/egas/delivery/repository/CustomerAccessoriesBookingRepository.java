package com.egas.delivery.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.egas.delivery.entity.CustomerAccessoriesBooking;

@Repository
public interface CustomerAccessoriesBookingRepository extends CrudRepository<CustomerAccessoriesBooking,Integer>
{
	public List<CustomerAccessoriesBooking> findByCustBookingCity(String custBookingCity);
	
	public CustomerAccessoriesBooking findByCustPancard(String custPancard);
}
