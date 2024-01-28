package com.cbfacademy.apiassessment.coffee;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public class DefaultCoffeeService implements CoffeeService{

    private final CoffeeRepository repository;

    public DefaultCoffeeService(CoffeeRepository repository) {
        this.repository = repository;
    }


    @Override
    public List<Coffee> getAllCoffees() {
        return iterableToList(repository.findAll());

        
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

