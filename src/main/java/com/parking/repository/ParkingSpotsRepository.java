package com.parking.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.parking.model.ParkingSpots;

@Repository
public interface ParkingSpotsRepository extends JpaRepository<ParkingSpots, Long>{
	
	
	@Query("select u from ParkingSpots u where u.employeeDetails.employeeId is null")
	public List<ParkingSpots> freeParkingSpots();
	
	@Query("select u from ParkingSpots u where u.employeeDetails.employeeId=:employeeId")
	public Optional<ParkingSpots> getParkingSpots(@Param("employeeId") Long employeeId);

	
}
