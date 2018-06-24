package com.revature.models;



public class Car {
	private int vin;
	private String make;
	private String model;
	private String color;
	
	Car(){}

	public int getVin() {
		return vin;
	}

	public void setVin(int vin) {
		this.vin = vin;
	}

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public Car(int vin, String make, String model, String color) {
		super();
		this.vin = vin;
		this.make = make;
		this.model = model;
		this.color = color;
	}

	@Override
	public String toString() {
		return "Car [vin=" + vin + ", make=" + make + ", model=" + model + ", color=" + color + "]";
	}
	

}
