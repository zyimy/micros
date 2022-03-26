package com.servicios.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.servicios.entity.Bike;

@Repository
public interface BikeRepository extends JpaRepository<Bike, Long> {
	
	
	
}
