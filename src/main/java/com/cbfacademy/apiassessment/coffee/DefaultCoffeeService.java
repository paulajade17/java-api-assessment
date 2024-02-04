package com.cbfacademy.apiassessment.coffee;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

    /** 
     * Service Annotation
     * DefaultCoffeeService class implements the CoffeeService interface and has access to the methods once overriden.
     * Line 24 creates a variable that acts as the data store (repository)
     * This class has a constructor that takes a the repository variable as a parameter
     * The constructor is responsible for initializing the repository field with the provided instance.
     * This is known as dependency injection, where the dependencies 
     * (in this case, the CoffeeRepository) are injected into the class through its constructor.
     */
@Service

public class DefaultCoffeeService implements CoffeeService {

    private final CoffeeRepository repository;

    public DefaultCoffeeService(CoffeeRepository repository) {
        this.repository = repository;
    }
    /** 
     * Overriden getAllCoffees method returns a list of Coffee objects.
     * New Arraylist called coffeeList is created.
     * For loop, loops coffee variable through findAll method from the repository.
     * adds coffee variable to coffeeList and returns contents of coffeeList.
     */

    @Override
    public List<Coffee> getAllCoffees() {
        List<Coffee> coffeeList = new ArrayList<>();

        for (Coffee coffee : repository.findAll()) {
            coffeeList.add(coffee);
        }

        return coffeeList;
    }

    public List<Coffee> sortCoffeesByPrice() {
        List<Coffee> coffeeList = getAllCoffees();

        int n = coffeeList.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                // Compare adjacent elements and swap if they are in the wrong order
                if (coffeeList.get(j).getPrice() > coffeeList.get(j + 1).getPrice()) {
                    Coffee temp = coffeeList.get(j);
                    coffeeList.set(j, coffeeList.get(j + 1));
                    coffeeList.set(j + 1, temp);
                }
            }
        }

        return coffeeList;
    }

     /** 
     * Overriden getCoffee method returns a Coffee object and takes in paramater of UUID called id.
     * New coffee variable points to getValidCoffee(id) method
     * For loop, loops coffee variable through findAll method from the repository.
     * adds coffee variable to coffeeList and returns contents of coffeeList.
     */

    @Override
    public Coffee getCoffee(UUID id) {
        Coffee coffee = repository.findById(id);

        if (coffee == null) {
            throw new IllegalArgumentException("Coffee not found.");
        }

        return coffee;
    }

    @Override
    public Coffee createCoffee(Coffee coffee) {
        return repository.save(coffee);

    }

    @Override
    public Coffee updateCoffee(UUID id, Coffee updatedCoffee) {
        Coffee coffee = repository.findById(id);

        if (coffee == null) {
            throw new IllegalArgumentException("Coffee not found.");
        }
        coffee.setName(updatedCoffee.getName());
        coffee.setDescription(updatedCoffee.getDescription());
        coffee.setPrice(updatedCoffee.getPrice());
        coffee.setBrand(updatedCoffee.getBrand());
        coffee.setOrigin(updatedCoffee.getOrigin());

        return repository.save(coffee);
    }

    @Override
    public void deleteCoffee(UUID id) {
        repository.findById(id);
        repository.deleteById(id);
    }
    // Methods I want to work on if I had more time 
    
    public Coffee searchByName(String name) {
        throw new CoffeeNotFoundException ("TODO");

    }
    public List<Coffee> searchByBrand(String brand) 
    {
        throw new CoffeeNotFoundException ("TODO");

    }
    public List<Coffee> searchByOrigin(String origin)
    {
        throw new CoffeeNotFoundException ("TODO");

    }
}
