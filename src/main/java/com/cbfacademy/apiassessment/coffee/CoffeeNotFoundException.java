package com.cbfacademy.apiassessment.coffee;

// Created a custom exception called CoffeeNotFoundException
// This class has inhertited the RunTimeException methods and behaviour
public class CoffeeNotFoundException extends RuntimeException{
    public CoffeeNotFoundException(String message) {
        super(message);
    }
}


