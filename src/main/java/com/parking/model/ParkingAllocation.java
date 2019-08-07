package com.parking.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity @Setter @Getter @ToString @AllArgsConstructor @NoArgsConstructor
public class ParkingAllocation {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long parkingAllocationId;
	private LocalDate parkingAvailaleDate;

	@ManyToOne
	@JoinColumn(name = "employeeId")
	EmployeeDetails employeeDetails;


	@ManyToOne
	@JoinColumn(name = "parkingId")
	ParkingSpots parkingSpots;


	public Long getParkingAllocationId() {
		return parkingAllocationId;
	}


	public void setParkingAllocationId(Long parkingAllocationId) {
		this.parkingAllocationId = parkingAllocationId;
	}


	public LocalDate getParkingAvailaleDate() {
		return parkingAvailaleDate;
	}


	public void setParkingAvailaleDate(LocalDate parkingAvailaleDate) {
		this.parkingAvailaleDate = parkingAvailaleDate;
	}


	public EmployeeDetails getEmployeeDetails() {
		return employeeDetails;
	}


	public void setEmployeeDetails(EmployeeDetails employeeDetails) {
		this.employeeDetails = employeeDetails;
	}


	public ParkingSpots getParkingSpots() {
		return parkingSpots;
	}


	public void setParkingSpots(ParkingSpots parkingSpots) {
		this.parkingSpots = parkingSpots;
	}

	
}
