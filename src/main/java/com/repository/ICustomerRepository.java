package com.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.entities.CustomerEntity;

@Repository
public interface ICustomerRepository extends JpaRepository<CustomerEntity, Long> {
	
}
