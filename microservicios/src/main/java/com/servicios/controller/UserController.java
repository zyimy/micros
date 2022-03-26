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

import com.servicios.entity.User;
import com.servicios.service.UserService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	
	@GetMapping("/all")
	public ResponseEntity<List<User>>listAll(@RequestParam(defaultValue = "0")Integer pageNo,
			@RequestParam(defaultValue = "0")Integer pageSize,
			@RequestParam(defaultValue = "id_user")String sorBy ){
		
		List<User>lista= userService.listaUser(pageNo, pageSize, sorBy);
		
		if (lista.isEmpty()) {
			return ResponseEntity.noContent().build();
		}else {
			return ResponseEntity.ok(lista);
		}
		
		
	}
	
	@GetMapping("/id/{id}")
	public ResponseEntity<User>getIdUser(@PathVariable("id")Long id){
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
	

}
