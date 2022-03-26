package com.servicios.service;


import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Sort;

import com.servicios.entity.User;
import com.servicios.repository.UserRepository;

@SpringBootTest
public class UserServiceTest {
	
	@Mock
	private UserRepository repositoryTest;
	
	
	@InjectMocks
	private UserService userTest;
	
	private User user;
	
	
	@BeforeEach
	void setup() {
		MockitoAnnotations.initMocks(this);
		
		 user = new User();
		user.setId_user(1L);
		user.setNombre("Yimy");
		user.setEmail("zepedayimy46@gmail.com");
	}
	/*
	@Test
	public void listaTest() {

		when(repositoryTest.findAll()).thenReturn(Arrays.asList(user));
		assertEquals(userTest.listaUser(0, 10, "id"),Arrays.asList(user));
	}
	
	*/
	
	@Test
	public void listaTest() {

		when(repositoryTest.findAll()).thenReturn(Arrays.asList(user));
		//verify(Arrays.asList(user)).get(0);
		assertEquals(userTest.lista(),Arrays.asList(user));
		
		 
	}
	
	@Test
	public void saveTest() {
		
		when(repositoryTest.save(user)).thenReturn(user);
		assertThat(userTest.saveUser(user));
	}
	
	@Test
	public void getIdTest() {
		when(repositoryTest.findById(user.getId_user())).thenReturn(Optional.of(user));
		assertThat(user);
	}

}
