package com.servicios.service;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.servicios.entity.User;
import com.servicios.feingclients.BikeFeingClient;
import com.servicios.feingclients.CarFeingClient;
import com.servicios.model.Bike;
import com.servicios.model.Car;
import com.servicios.repository.UserRepository;



@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	RestTemplate restTemplate;
	
	@Autowired
	CarFeingClient carFeing;
	
	@Autowired
	BikeFeingClient bikeFeingClient;
	
	public List<User>listaUser(Integer pageNo,Integer pageSize,String sorBy){
	Pageable paging = PageRequest.of(pageNo, pageSize,Sort.by(sorBy));
	Page<User>pageResult= userRepository.findAll(paging);
		
		if (pageResult.hasContent()) {
			return pageResult.getContent();
		}else { 
			return new ArrayList<User>();
		}
	}
	
	public User getById(int id) {
	Optional<User> user=userRepository.findById(id);	
		if (user.isPresent()) {
			return user.get();
			
		}else {
			return null;
		}
			
	}
	
	public User saveUser(User user) {
		
     return userRepository.save(user);    
	
	}
	
	
	
	public List<User>lista(){
		return userRepository.findAll();
	}
	
	public List<Car>getCars(int userId){
		List<Car>lista= restTemplate.getForObject("http://localhost:8002/car/byUser/"+userId, List.class);
		return lista;
	}
	
	public List<Bike>getBikes(int userId){
		List<Bike>lista= restTemplate.getForObject("http://localhost:8003/bike/byUser/"+userId, List.class);
		return lista;
	}
	
	public Car saveCar(int userId,Car car) {
		
		car.setUserId(userId);
		Car carNew = carFeing.save(car);
		return carNew;
	}
	
	public Bike saveBike(int userId,Bike bike) {
		
		bike.setUserId(userId);
		Bike bikeNew = bikeFeingClient.save(bike);
		return bikeNew;
	}
	
	public Map<String, Object> getUsersAndVehicles(int userId) {
		Map<String, Object> result = new HashMap<>();
		User user = userRepository.findById(userId).orElse(null);
		if (user == null) {
			result.put("Mensaje", "No existe el usuario");
			return result;
		}
		result.put("Users", user);
		List<Car> cars = carFeing.getCars(userId);

		if (cars.isEmpty())
			result.put("Cars", "El usuario: "+userId+" no tiene coches");

		else
			result.put("Cars", cars);
		List<Bike> bikes = bikeFeingClient.getBikes(userId);

		if (bikes.isEmpty())
			result.put("Bikes", "El usuario: "+userId+" no tiene bikes");
		else
			result.put("Bike", bikes);

		return result;
	}

}
