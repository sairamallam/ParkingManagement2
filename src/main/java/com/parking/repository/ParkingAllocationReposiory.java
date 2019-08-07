package com.parking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.parking.model.ParkingAllocation;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface ParkingAllocationReposiory extends JpaRepository<ParkingAllocation, Long>  {
	
public List<ParkingAllocation> findByParkingAvailaleDate(LocalDate parkingavailaledate);


@Query("select u from ParkingAllocation u where u.parkingSpots.parkingId is null and u.employeeDetails.employeeId is not null and u.parkingAvailaleDate=:parkingAvailaleDate")
public List<ParkingAllocation> emptyParkingData(@Param("parkingAvailaleDate")LocalDate parkingAvailaleDate);


@Query("select u from ParkingAllocation u where u.parkingSpots.parkingId is not null and u.employeeDetails.employeeId is null and u.parkingAvailaleDate=:parkingAvailaleDate")
public List<ParkingAllocation> emptyEmploayeeData(@Param("parkingAvailaleDate")LocalDate parkingAvailaleDate);

	
}
