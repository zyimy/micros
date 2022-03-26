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
@Table(name = "tbl_car")
public class Car {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;
	
	@Column(name = "nombre")
	private String model;
	
	
	@Column(name = "email")
	private String brand;
	
	@Column(name="userId")
	private Integer userId;
	
	


	public Car() {
		super();
	}


	public Car(String model, String brand,Integer userId) {
		
		this.model = model;
		this.brand = brand;
		this.userId= userId;
	}


	public String getModel() {
		return model;
	}


	public void setModel(String model) {
		this.model = model;
	}


	public String getBrand() {
		return brand;
	}


	public void setBrand(String brand) {
		this.brand = brand;
	}


	public Integer getUserId() {
		return userId;
	}


	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	
	


	
	
	
	
	

}
