package com.cbfacademy.apiassessment.coffee;
import java.util.UUID;

public class Coffee {

	private final UUID id;

	private String name;

	private String description;

	private double price;

	private String brand;

	private String origin;

	//private int sales;

	/**
	 * Parameterised constructor to create a coffee with specified details.
	 * id is not included inside the parameters
	 *
	 * @param name The name of the coffee.
	 * @param description The description of the coffee.
	 * @param price   The price of the coffee.
	 * @param brand The brand of the coffee.
     * @param origin The origin of the coffee.
     * @param sales The sales of the coffee.
	 */
	public Coffee(String name, String description, double price, String brand, String origin, int sales) {
		this.id = UUID.randomUUID();
		this.name = name;
		this.description = description;
		this.price = price;
		this.brand = brand;
        this.origin = origin;
        this.sales = sales;
	}

	/**
	 * Get the ID of the coffee.
	 *
	 * @return The unique identifier for the coffee.
	 */
	public UUID getId() {
		return this.id;
	}

	/**
	 * Get the name of the coffee.
	 *
	 * @return The name of the coffee.
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * Set the name of the coffee.
	 *
	 * @param name The name of the coffee.
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Get the the description of the coffee.
	 *
	 * @return The description of the coffee.
	 */
	public String getDescription() {
		return this.description;
	}

	/**
	 * Set the description of the coffee.
	 *
	 * @param description The description of the coffee.
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * Get the price of the coffee.
	 *
	 * @return The price of the coffee.
	 */
	public double getPrice() {
		return this.price;
	}

	/**
	 * Set the price of the coffee.
	 *
	 * @param price The price of the coffee.
	 */
	public void setPrice(double price) {
		this.price = price;
	}

	/**
	 * Get the brand of coffee.
	 *
	 * @return The brand of the coffee.
	 */
	public String getBrand() {
		return this.brand;
	}

    /**
	 * Set the brand of the coffee.
	 *
	 * @param brand The brand of the coffee.
	 */
	public void setBrand(String brand) {
		this.brand = brand;
	}

    /**
	 * Get the origin of coffee.
	 *
	 * @return The origin of the coffee.
	 */
	public String getOrigin() {
		return this.origin;
	}

    /**
	 * Set the origin of the coffee.
	 *
	 * @param origin The origin of the coffee.
	 */
	public void setOrigin(String origin) {
		this.origin = origin;
	}

     /**
	 * Get the sales of coffee.
	 *
	 * @return The sales of the coffee.
	 */
	public int getSales() {
		return this.sales;
	}

    /**
	 * Set the sales of the coffee.
	 *  
	 * @param sales The sales of the coffee.
	 */
	public void setSales(int sales) {
		this.sales = sales;
	}
    
    /**
	 * Create toString method to allow us to print the
     * string representation of the class. I have set it up 
     * in JSON format as this is how I want my data to show.
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
				", sales=" + sales +
			'}';
	}
}
