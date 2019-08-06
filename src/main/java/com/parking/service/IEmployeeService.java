package com.parking.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.parking.model.EmployeeDetails;

public interface IEmployeeService {
	
	public ResponseEntity<String> registration(EmployeeDetails employeeDetails);
	

}
