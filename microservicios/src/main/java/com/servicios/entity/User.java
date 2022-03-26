package com.servicios.entity;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.criterion.NotNullExpression;



@Entity
@Table(name = "tbl_user")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;
	
	@Column(name = "nombre")
	private String nombre;
	
	
	@Column(name = "email")
	private String email;
	
	


	public User() {
		super();
	}


	public User(String nombre, String email) {
		super();
		this.nombre = nombre;
		this.email = email;
	}


	public Long getId_user() {
		return id;
	}


	public void setId_user(Long id_user) {
		id_user = id_user;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
	
	

}
