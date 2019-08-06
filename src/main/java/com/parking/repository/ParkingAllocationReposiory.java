package com.parking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.parking.model.ParkingAllocation;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface ParkingAllocationReposiory extends JpaRepository<ParkingAllocation, Long>  {
	
public List<ParkingAllocation> findByParkingAvailaleDate(LocalDate parkingavailaledate);
	
}
