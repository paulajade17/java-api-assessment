package com.cbfacademy.apiassessment;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import java.util.ArrayList;
import java.util.List;

import com.cbfacademy.apiassessment.coffee.Coffee;

@DisplayName(value = "Coffee")
public class CoffeeTest {

    @Test
    @DisplayName("getName() method returns a string")
    public void getName_ReturnsString() {
        Coffee coffee = new Coffee("Minty Sensation", "Delicious minty coffee", 3.99, "Nescafe", "Brazil");
        final String result = coffee.getName();
        final String expected = "Minty Sensation";

        assertThat(result, is(equalTo(expected)));
    }

    @Test
    @DisplayName("getPrice() method returns a double")
    public void getPrice_ReturnsDouble() {
        Coffee coffee = new Coffee("Minty Sensation", "Delicious minty coffee", 3.99, "Nescafe", "Brazil");
        final double result = coffee.getPrice();
        final double expected = 3.99;

        assertThat(result, is(equalTo(expected)));
    }


    @Test
    @DisplayName("setPrice() method returns the correct value")
    public void getPrice_ReturnsCorrectValue() {
        Coffee coffee = new Coffee("Minty Sensation", "Delicious minty coffee", 3.99, "Nescafe", "Brazil");
        final double newPrice = coffee.getPrice() + 1.00;
        coffee.setPrice(newPrice);
        final double result = coffee.getPrice();
        final double expected = 4.99;

        assertThat(result, is(equalTo(expected)));
    }

    @Test
    @DisplayName("size() method returns a non empty list")
    public void getAllCoffees_ReturnsNonEmptyList() {
        List<Coffee> coffeeList = new ArrayList<>();
        //link this to my defaultcoffeeservice
        //set up service class 
        //add coffees from below
        
    
        coffeeList.add(new Coffee("Original", "Delicious coffee", 3.99, "Nescafe", "Brazil"));
        coffeeList.add(new Coffee("Mocha", "Delicious mocha", 4.99, "Java's Cup", "India"));
        coffeeList.add(new Coffee("Hazelnut", "Delicious hazelnut coffee", 5.99, "Nestle", "Columbia"));
        coffeeList.add(new Coffee("Chilli Chocolate", "Delicious chilli chocolate coffee", 6.99, "Nescafe", "India"));
        coffeeList.add(new Coffee("Chocolate Orange", "Delicious chocolate orange coffee", 7.99, "Java's Cup5", "Brazil"));

        Integer expectedSize = 5;
        Integer coffeeListSize = coffeeList.size();
        assertThat(coffeeListSize, is(equalTo(expectedSize)));
    }

}


