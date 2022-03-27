package com.servicios.controller;

import java.util.List;
import java.util.Map;

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

import com.servicios.entity.User;
import com.servicios.model.Bike;
import com.servicios.model.Car;
import com.servicios.service.UserService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	
	@GetMapping("/all")
	public ResponseEntity<List<User>>listAll(@RequestParam(defaultValue = "0")Integer pageNo,
			@RequestParam(defaultValue = "10")Integer pageSize,
			@RequestParam(defaultValue = "id")String sorBy ){
		
		List<User>lista= userService.listaUser(pageNo, pageSize, sorBy);
		
		if (lista.isEmpty()) {
			return ResponseEntity.noContent().build();
		}else {
			return ResponseEntity.ok(lista);
		}
		
		
	}
	
	@GetMapping("/id/{id}")
	public ResponseEntity<User>getIdUser(@PathVariable("id")int id){
		User user = userService.getById(id);
		
		if (user==null) {
			
			return ResponseEntity.notFound().build();
			
		}else {
			return ResponseEntity.ok(user);
		}
	}
	
	@PostMapping
	public ResponseEntity<User> save(@RequestBody User user) {
		User user2 = userService.saveUser(user);
		
	  return ResponseEntity.ok(user);
			
		}
	
	
	@GetMapping("/allUser")
	
	public ResponseEntity<List<User>>listUser()
			{
		
		List<User>lista= userService.lista();
		
		if (lista.isEmpty()) {
			return ResponseEntity.noContent().build();
		}else {
			return ResponseEntity.ok(lista);
		}
		
		
	}
	
	@GetMapping("/cars/{userId}")
	public ResponseEntity<List<Car>>listaCars(@PathVariable("userId")int userId){
		User user =userService.getById(userId);
		
		if (user==null) 
			return ResponseEntity.notFound().build();
		List<Car>lista=userService.getCars(userId);
		return ResponseEntity.ok(lista);
		
	}
	
	@GetMapping("/bikes/{id}")
	public ResponseEntity<List<Bike>>listaBikes(@PathVariable("id")int userId){
		User user =userService.getById(userId);
		
		if (user==null) {
			return ResponseEntity.notFound().build();
		}else {
			List<Bike>lista=userService.getBikes(userId);
			return ResponseEntity.ok(lista);
		}
	}
	
	@PostMapping("/savecar/{userId}")
	public ResponseEntity<Car>saveCars(@PathVariable("userId") int userId, @RequestBody Car car){
		Car carNew = userService.saveCar(userId, car);
		
		return ResponseEntity.ok(car);
	}
	
	@PostMapping("/savebike/{userId}")
	public ResponseEntity<Bike>saveBikes(@PathVariable("userId") int userId, @RequestBody Bike bike){
		Bike bikeNew = userService.saveBike(userId, bike);
		
		return ResponseEntity.ok(bike);
	}
	
	@GetMapping("/getAll/{userId}")
	public ResponseEntity<Map<String,Object>>getAllVehicles(@PathVariable("userId") int userId){
		Map<String,Object>result = userService.getUsersAndVehicles(userId);
		return ResponseEntity.ok(result);
		
	}
	

}
