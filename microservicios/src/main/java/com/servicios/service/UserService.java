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

import com.servicios.entity.User;
import com.servicios.repository.UserRepository;



@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public List<User>listaUser(Integer pageNo,Integer pageSize,String sorBy){
	Pageable paging = PageRequest.of(pageNo, pageSize,Sort.by(sorBy));
	Page<User>pageResult= userRepository.findAll(paging);
		
		if (pageResult.hasContent()) {
			return pageResult.getContent();
		}else {
			return new ArrayList<User>();
		}
	}
	
	public User getById(Long id) {
	Optional<User> user=userRepository.findById(id);	
		if (user.isPresent()) {
			return user.get();
			
		}else {
			return null;
		}
			
	}
	
	public User saveUser(User user) {
	 Optional<User> user2=userRepository.findById(user.getId_user());
	 
	 if (!user2.isPresent()) {
		return userRepository.save(user);
	}else {
		return null;
	}
	
	
	}

}
