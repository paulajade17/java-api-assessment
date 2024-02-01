package com.cbfacademy.apiassessment.coffee;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.stereotype.Service;

@Service
public class DefaultCoffeeService implements CoffeeService{

    private final CoffeeRepository repository;

    public DefaultCoffeeService(CoffeeRepository repository) {
        this.repository = repository;
    }

    //Instead of doing a for loop. I have used the iterableToList method to loop through the coffees
    //This makes the code shorter and cleaner


    @Override
    public List<Coffee> getAllCoffees() {
        return iterableToList(repository.findAll());
    }

    public List<Coffee> sortCoffeesByPrice() {
        List<Coffee> coffeeList = iterableToList(repository.findAll());

        int n = coffeeList.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                // Compare adjacent elements and swap if they are in the wrong order
                if (coffeeList.get(j).getPrice() > coffeeList.get(j+1).getPrice()) {
                    // Swap
                    System.out.println("swapping");
                    Coffee temp = coffeeList.get(j);
                    coffeeList.set(j, coffeeList.get(j + 1));
                    coffeeList.set(j + 1, temp);
                }
            }
        }

        return coffeeList;
    }


    @Override
    public Coffee getCoffee(UUID id) {
        Optional<Coffee> coffee = getValidCoffee(id);

        return coffee.orElseThrow();
    }


    @Override
    public Coffee createCoffee(Coffee coffee) {
        return repository.save(coffee);
    
    }

    @Override
    public Coffee updateCoffee(UUID id, Coffee updatedCoffee) {
        Optional<Coffee> found = getValidCoffee(id);

        Coffee coffee = found.orElseThrow();
        coffee.setName(updatedCoffee.getName());
        coffee.setDescription(updatedCoffee.getDescription());
        coffee.setPrice(updatedCoffee.getPrice());
        coffee.setBrand(updatedCoffee.getBrand());
        coffee.setOrigin(updatedCoffee.getOrigin());
        coffee.setSales(updatedCoffee.getSales());

        return repository.save(coffee);
    }

    @Override
    public void deleteCoffee(UUID id) {
        getValidCoffee(id);
        repository.deleteById(id);
    }

    protected <T> List<T> iterableToList(Iterable<T> iterable) {
        return StreamSupport.stream(iterable.spliterator(), false)
                .collect(Collectors.toList());
    }

    protected Optional<Coffee> getValidCoffee(UUID id) {
        Optional<Coffee> found = repository.findById(id);

        if (!found.isPresent()) {
            throw new IllegalArgumentException("Coffee not found.");
        }

        return found;
    
    }

}

