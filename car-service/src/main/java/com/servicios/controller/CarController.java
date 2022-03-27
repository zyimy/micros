package com.servicios.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.servicios.entity.Car;
import com.servicios.service.CarService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/car")
public class CarController {
	
	@Autowired
	private CarService userService;
	
	
	@GetMapping("/all")
	public ResponseEntity<List<Car>>listAll(@RequestParam(defaultValue = "0")Integer pageNo,
			@RequestParam(defaultValue = "10")Integer pageSize,
			@RequestParam(defaultValue = "id")String sorBy ){
		
		List<Car>lista= userService.listaUser(pageNo, pageSize, sorBy);
		
		if (lista.isEmpty()) {
			return ResponseEntity.noContent().build();
		}else {
			return ResponseEntity.ok(lista);
		}
		
		
	}
	
	@GetMapping("/id/{id}")
	public ResponseEntity<Car>getIdUser(@PathVariable("id")int id){
		Car user = userService.getById(id);
		
		if (user==null) {
			
			return ResponseEntity.notFound().build();
			
		}else {
			return ResponseEntity.ok(user);
		}
	}
	
	@PostMapping
	public ResponseEntity<Car> save(@RequestBody Car user) {
		Car user2 = userService.saveUser(user);
		
	  return ResponseEntity.ok(user);
			
		}
	
	
	@GetMapping("/allCar")
	
	public ResponseEntity<List<Car>>listUser()
			{
		
		List<Car>lista= userService.lista();
		
		if (lista.isEmpty()) {
			return ResponseEntity.noContent().build();
		}else {
			return ResponseEntity.ok(lista);
		}
		
		
	}
	
	@GetMapping("/byUser/{userId}")
	public ResponseEntity<List<Car>> listaUser(@PathVariable("userId")int userId) {
		List<Car>lista= userService.listById(userId);
		
		if (lista.isEmpty()) {
		return	ResponseEntity.noContent().build();
			
		}else {
		
			return ResponseEntity.ok(lista);
		}
		
	}
	

}
