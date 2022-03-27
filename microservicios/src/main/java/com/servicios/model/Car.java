package com.servicios.model;


public class Car {
	
	
	private String model;
	private String brand;
	private int userId;
	
	
	public Car() {
		super();
	}
	
	
	public Car(String model, String brand) {
		super();
		this.model = model;
		this.brand = brand;
	}
	
	public Car(String model, String brand, int userId) {
		super();
		this.model = model;
		this.brand = brand;
		this.userId = userId;
	}


	public int getUserId() {
		return userId;
	}


	public void setUserId(int userId) {
		this.userId = userId;
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


	@Override
	public String toString() {
		return "Car [model=" + model + ", brand=" + brand + ", userId=" + userId + "]";
	}



	
	
	

}
