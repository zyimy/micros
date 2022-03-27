package com.servicios.feingclients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.servicios.model.Bike;


@FeignClient(name = "bike-service", url="http://localhost:8003/bike")
public interface BikeFeingClient {
	
	@PostMapping
	Bike save(@RequestBody Bike bike);
	
	@GetMapping("/byuser/{userId}")
	List<Bike>getBikes(@PathVariable("userId") int userId);

}
