package com.parking.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity @Setter @Getter @ToString @AllArgsConstructor @NoArgsConstructor
public class ParkingSpots {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long parkingId;
	private Long parkingName;

	@OneToOne @JoinColumn(name = "employeeId")
	EmployeeDetails employeeDetails;

	public Long getParkingId() {
		return parkingId;
	}

	public void setParkingId(Long parkingId) {
		this.parkingId = parkingId;
	}

	public Long getParkingName() {
		return parkingName;
	}

	public void setParkingName(Long parkingName) {
		this.parkingName = parkingName;
	}

	public EmployeeDetails getEmployeeDetails() {
		return employeeDetails;
	}

	public void setEmployeeDetails(EmployeeDetails employeeDetails) {
		this.employeeDetails = employeeDetails;
	}
	
	
	
	
}
