package com.parking.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.parking.model.EmployeeDetails;

public interface EmployeeDetailsRepository  extends JpaRepository<EmployeeDetails, Long> {

	
	
}
