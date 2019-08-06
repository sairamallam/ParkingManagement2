package com.parking.service;

import java.time.LocalDate;
import java.time.Period;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.parking.model.EmployeeDetails;
import com.parking.repository.EmployeeDetailsRepository;

@Service
public class EmployeeService implements IEmployeeService {
	@Autowired
	EmployeeDetailsRepository employeeDetailsRepository;

	@Override
	public ResponseEntity<String> registration(EmployeeDetails employeeDetails) {
	Period diff=Period.between(employeeDetails.getJoiningDate(), LocalDate.now());

	if(diff.getYears()<15) {
		//allocate the parking place
		
	}
		
		employeeDetailsRepository.save(employeeDetails);
		return new ResponseEntity<>("employee sucsessfully registerd", HttpStatus.OK);
	}

	
}
