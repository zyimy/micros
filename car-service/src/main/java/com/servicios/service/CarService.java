package com.servicios.service;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;


import com.servicios.entity.Car;
import com.servicios.repository.CarRepository;



@Service
public class CarService {
	
	@Autowired
	private CarRepository userRepository;
	
	public List<Car>listaUser(Integer pageNo,Integer pageSize,String sorBy){
	Pageable paging = PageRequest.of(pageNo, pageSize,Sort.by(sorBy));
	Page<Car>pageResult= userRepository.findAll(paging);
		
		if (pageResult.hasContent()) {
			return pageResult.getContent();
		}else { 
			return new ArrayList<Car>();
		}
	}
	
	public Car getById(int id) {
	Optional<Car> user=userRepository.findById(id);	
		if (user.isPresent()) {
			return user.get();
			
		}else {
			return null;
		}
			
	}
	
	public Car saveUser(Car user) {
		
     return userRepository.save(user);    
	
	}
	
	public List<Car>lista(){
		return userRepository.findAll();
	}
	
	public List<Car>listById(int userId){
		Optional<Car>user=userRepository.findById(userId);
		
		if (user.isPresent()) {
			return userRepository.findByUserId(userId);
		}else {
			return null;
		}
		
	}

}
