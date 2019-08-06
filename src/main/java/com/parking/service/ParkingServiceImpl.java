package com.parking.service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.parking.exception.EmployeeException;
import com.parking.model.EmployeeDetails;
import com.parking.model.ParkingAllocation;
import com.parking.model.ParkingSpots;
import com.parking.repository.EmployeeDetailsRepository;
import com.parking.repository.ParkingAllocationReposiory;
import com.parking.repository.ParkingSpotsRepository;

@Service
public class ParkingServiceImpl implements ParkingService {

	@Autowired
	ParkingSpotsRepository parkingSpotsRepository;

	@Autowired
	EmployeeDetailsRepository employeeDetailsRepository;
	
	@Autowired
	ParkingAllocationReposiory parkingAllocationReposiory;

	@Override
	public ResponseEntity<String> parkingAllocation(Long employeeId) {

		if (employeeDetailsRepository.findById(employeeId).isPresent())
			throw new EmployeeException("employee not existed");

		List<ParkingSpots> parkingSpotsFree = parkingSpotsRepository.freeParkingSpots();
		if (parkingSpotsFree.isEmpty())
			throw new EmployeeException("all parkings are full");

		EmployeeDetails employeeDetails = new EmployeeDetails();
		employeeDetails.setEmployeeId(employeeId);

		parkingSpotsFree.get(0).setEmployeeDetails(employeeDetails);
		parkingSpotsRepository.save(parkingSpotsFree.get(0));

		return ResponseEntity.ok().body("parking id = " + parkingSpotsFree.get(0).getParkingId());
	}

	@Override
	public ResponseEntity<String> parkingRequest(Long employeeId, LocalDate toDate, LocalDate fromDate) {

		if (employeeDetailsRepository.findById(employeeId).isPresent())
			throw new EmployeeException("employee not existed");
		
		Optional<ParkingSpots> parkingSpots = parkingSpotsRepository.getParkingSpots(employeeId);
		if(!parkingSpots.isPresent())
			throw new EmployeeException("parking not existed");
			
		
		//iterare the freedates from date to todate
		long numOfDaysBetween = ChronoUnit.DAYS.between(fromDate, toDate);
		 List<LocalDate> freeDates = IntStream.iterate(0, i -> i + 1).limit(numOfDaysBetween).mapToObj(i -> fromDate.plusDays(i))
				.collect(Collectors.toList());
		 ParkingAllocation  parkingAllocation=new ParkingAllocation();
		 
		 
		 for(LocalDate freeDate: freeDates) {
			 parkingAllocation.setParkingAvailaleDate(freeDate);
			 parkingAllocation.setParkingSpots(parkingSpots.get());
			 parkingAllocationReposiory.save(parkingAllocation);
			 
		 }
 		return ResponseEntity.ok().body("updated succsesfuly");

	}

	@Override
	public ResponseEntity<String> parkingRelease(Long employeeId, LocalDate toDate, LocalDate fromDate) {

		return null;
	}

	@Override
	public ResponseEntity<String> allocatedparkingChecking(Long employeeId) {

		
		return null;
	}

}
