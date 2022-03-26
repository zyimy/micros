package com.servicios.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.servicios.entity.Car;

@Repository
public interface UserRepository extends JpaRepository<Car, Long> {
	
	
	
}
