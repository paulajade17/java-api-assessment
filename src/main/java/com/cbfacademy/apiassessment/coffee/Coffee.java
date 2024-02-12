package com.cbfacademy.apiassessment.coffee;
import java.util.UUID;

/** 
 * 	A model class called Coffee declared as public so it can be accessed from other classes in this project i.e. JsonRepository, Service, Controller etc.
 *  The Coffee class has various attritbutes such as id, name, description, price, brand, origin etc.
 * 	Attributes declared as private, so they can only be accessed within the Coffee class itself.
 * 	The final keyword for id ensures once a Coffee object has been created, the id cannot be changed.
 * 	ID is an attribute that you don't want changed
 * 	Data type for id is UUID as IDs need to be random and unique.
 *  Attributes name, description, brand and origin have the data type of a String
 *  price has a data type of a double.
 */

public class Coffee {

	private final UUID id;

	private String name;

	private String description;

	private double price;

	private String brand;

	private String origin;

	/**
	 * Parameterised constructor is used to create instances of the Coffee class with specified details.
	 * ID is not included inside the parameters, as ID should be created randomly.
	 *
	 * @param name The name of the coffee.
	 * @param description The description of the coffee.
	 * @param price   The price of the coffee.
	 * @param brand The brand of the coffee.
     * @param origin The origin of the coffee.
	 * 
	 * this. differeniates between instance variables above and variables in the parameters below with the same name.
	 */
	public Coffee(String name, String description, double price, String brand, String origin) {
		// Initialises the id of the coffee object to be generated randomly.
		this.id = UUID.randomUUID();
		this.name = name;
		this.description = description;
		this.price = price;
		this.brand = brand;
        this.origin = origin;
      
	}
	/** 
	 * Getters and setters method for each attribute
	 * No setter method for id. 
	 * This is something that should not be set
	*/

	// 
	public UUID getId() {
		return this.id;
	}

	public String getName() {
		return this.name;
	}


	public void setName(String name) {
		this.name = name;
	}

	
	public String getDescription() {
		return this.description;
	}


	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return this.price;
	}


	public void setPrice(double price) {
		this.price = price;
	}


	public String getBrand() {
		return this.brand;
	}

  
	public void setBrand(String brand) {
		this.brand = brand;
	}


	public String getOrigin() {
		return this.origin;
	}

 
	public void setOrigin(String origin) {
		this.origin = origin;
	}

    
     /**
     * Override toString method to provide a string representation of the Coffee object.
     * The format is in JSON style for better readability.
     */

	@Override
	public String toString() {
		return "Coffee{" +
				"id=" + id +
				", name='" + name + '\'' +
				", description='" + description + '\'' +
				", price=" + price +
				", brand='" + brand + '\'' +
				", origin='" + origin + '\'' +
			'}';
	}
}
