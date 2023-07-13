package com.crms.demo.model;

public class Vehicle {
	private String brand;
	private String model;
	private String colour;
	private String engine;
	private String registrationno;
	private int vehicleid;
	private int rate;
	
	public Vehicle(){
	}
	
	public Vehicle(int vehicleid, String brand, String model, String colour, String engine, String registrationno, int rate){
		this.vehicleid = vehicleid;
		this.brand = brand;
		this.model = model;
		this.colour = colour;
		this.engine = engine;
		this.registrationno = registrationno;
		this.rate = rate;
	}
	
	//accessor and mutator methods
	public int getVehicleid(){
		return vehicleid;
	}
	public void setVehicleid(int vehicleid){
		this.vehicleid = vehicleid;
	}
	public String getBrand(){
		return brand;
	}
	public void setBrand(String brand){
		this.brand = brand;
	}
	public String getModel(){
		return model;
	}
	public void setModel(String model){
		this.model = model;
	}
	public String getColour(){
		return colour;
	}
	public void setColour(String colour){
		this.colour = colour;
	}
	public String getEngine(){
		return engine;
	}
	public void setEngine(String engine){
		this.engine = engine;
	}
	public String getRegistrationno(){
		return registrationno;
	}
	public void setRegistrationno(String registrationno){
		this.registrationno = registrationno;
	}
	public int getRate(){
		return rate;
	}
	public void setRate(int rate){
		this.rate = rate;
	}

	//tostring method
	public String toString(){
		return "Vehicle [vehicleid=" + vehicleid + ", brand=" + brand + ", model=" + model + ", colour=" + colour + ", engine=" + engine + ", registrationno=" + registrationno + ", rate=" + rate + "]";
	}
}

