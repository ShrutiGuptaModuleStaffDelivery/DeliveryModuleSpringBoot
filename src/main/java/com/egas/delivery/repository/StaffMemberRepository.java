package com.egas.delivery.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.egas.delivery.entity.Staff_Member;

@Repository
public interface StaffMemberRepository extends CrudRepository<Staff_Member,Integer>
{

	public Staff_Member findByPancardNumber(String pancardNumber);
}