package com.parking.service;

import java.time.LocalDate;

import org.springframework.http.ResponseEntity;

public interface ParkingService {
	
	public	ResponseEntity<String> parkingAllocation(Long employeeId);
	public	ResponseEntity<String> parkingRequest(Long employeeId, LocalDate toDate, LocalDate fromDate);
	public	ResponseEntity<String> parkingRelease(Long employeeId, LocalDate toDate, LocalDate fromDate);
	public	ResponseEntity<String> allocatedparkingChecking(Long employeeId);


}
