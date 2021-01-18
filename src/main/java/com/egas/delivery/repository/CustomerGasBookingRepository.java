package com.egas.delivery.repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.egas.delivery.entity.CustomerGasBooking;

@Repository
public interface CustomerGasBookingRepository extends CrudRepository<CustomerGasBooking, Integer>
{
	List<CustomerGasBooking> findByCustCity(String custCity);
	
	public CustomerGasBooking findByCustPancard(String custPancard);
}
