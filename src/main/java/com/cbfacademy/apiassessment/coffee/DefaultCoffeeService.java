package com.cbfacademy.apiassessment.coffee;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

/**
 * The DefaultCoffeeService class implements the CoffeeService interface and provides
 * methods for managing coffee entities in the system.
 */
@Service

public class DefaultCoffeeService implements CoffeeService {

    private final CoffeeRepository repository;

    /**
     * Constructor for DefaultCoffeeService.
     * Initializes the repository field with the CoffeeRepository instance.
     * This follows the dependency injection pattern.
     *
     * @param repository The CoffeeRepository instance to be used by the service.
     */

    public DefaultCoffeeService(CoffeeRepository repository) {
        this.repository = repository;
    }
    /**
     * 
     * Retrieves a list of all coffees available in the system.
     * 
     * 
     *
     * @return A list of coffees representing all available coffees.
     */

    @Override
    public List<Coffee> getAllCoffees() {
        // new ArrayList called coffeeList is initialised to store the retrieved coffees
        List<Coffee> coffeeList = new ArrayList<>();

        // Enhanced for loop iterates over the each coffee object in the collection from the findAll() method
        // repository.findAll method should return a collection of coffee objects, as it retrieves the objects from a data source 'repository'.
        for (Coffee coffee : repository.findAll()) {
            //inside the loop each coffee object is added to the coffeeList
            coffeeList.add(coffee);
        }
        // All the coffee objects retrieved from the data source are returned
        return coffeeList;
    }

    /**
     * Sorts the list of coffees based on their prices in ascending order.
     *
     * @return A sorted list of Coffee objects based on price.
     */

    public List<Coffee> sortCoffeesByPrice() {
        List<Coffee> coffeeList = getAllCoffees();
        
        // Use n to get the total number of elements in the list.
        int n = coffeeList.size();

        /**
        * Implemented bubble sort algorithm, it's not as efficent but is beginner friendly.
        * i - Outer loop iterates over each element in the list. 
        * -1 is included to avoid an array out of bounds error, when the loop get's to the second to last element i
        * it will be comparing against the last element.
        * i++ incruments i through the loop
        * this represents the number of passes through the array
        */
        for (int i = 0; i < n - 1; i++) {
            // Inner loop compares and swaps each elements next to each other.
            for (int j = 0; j < n - i - 1; j++) {
                // if the price of j is greater than j + 1 then the two elements should be swapped.
                // j + 1 is the next number after j
                // temp variable has been created and points to j 
                if (coffeeList.get(j).getPrice() > coffeeList.get(j + 1).getPrice()) {
                    Coffee temp = coffeeList.get(j);
                    // swaps position of j with j + 1
                    coffeeList.set(j, coffeeList.get(j + 1));
                    //swaps position of j + 1 with the temp variable which is j
                    coffeeList.set(j + 1, temp);
                }
            }
        }
        //returns the sorted list
        return coffeeList;
    }

    /**
     * Retrieves a specific coffee by its unique identifier.
     *
     * @param id The unique identifier of the coffee to retrieve.
     * @return The Coffee object with the specified ID.
     * @throws CoffeeNotFoundException if the coffee with the provided ID is not found.
     */

    @Override
    public Coffee getCoffee(UUID id) {
        // Retrieve the coffee entity from the repository based on the provided UUID
        Coffee coffee = repository.findById(id);
        // Check if the retrieved coffee is null (not found in the repository). 
        // If so a CoffeeNotFoundException will be thrown. User will see "Coffee not found" message.
        if (coffee == null) {
            throw new CoffeeNotFoundException("Coffee not found.");
        }
        // If coffee is found, the coffee will be returned.
        return coffee;
    }

    /**
     * Creates a new coffee entry in the system.
     *
     * @param coffee The Coffee object to be created.
     * @return The created Coffee object.
     */

    @Override
    public Coffee createCoffee(Coffee coffee) {
        // Save the provided Coffee object to the repository
        // and returning the saved instance (which may include generated identifiers)
        return repository.save(coffee);

    }

    /**
     * Updates an existing coffee's information based on its ID.
     *
     * @param id            The ID of the coffee to be updated.
     * @param updatedCoffee The updated Coffee object.
     * @return The updated Coffee object.
     * @throws CoffeeNotFoundException if the coffee with the provided ID is not found.
     */

    @Override
    public Coffee updateCoffee(UUID id, Coffee updatedCoffee) {
        // Retrieve the existing Coffee object from the repository based on the provided UUID
        Coffee coffee = repository.findById(id);
        // Check if the retrieved coffee is null (not found in the repository)
        if (coffee == null) {
        // If the coffee is not found, throw an CoffeeNotFoundException with a descriptive message
            throw new CoffeeNotFoundException("Coffee not found.");
        }
        // Update the properties of the retrieved Coffee object with the values from the updatedCoffee
        coffee.setName(updatedCoffee.getName());
        coffee.setDescription(updatedCoffee.getDescription());
        coffee.setPrice(updatedCoffee.getPrice());
        coffee.setBrand(updatedCoffee.getBrand());
        coffee.setOrigin(updatedCoffee.getOrigin());

        // Save the updated Coffee object back to the repository
        // and returning the saved instance (which may include generated identifiers)
        return repository.save(coffee);
    }

    /**
     * Deletes a coffee from the system based on its ID.
     *
     * @param id The ID of the coffee to be deleted.
     */
    @Override
    public void deleteCoffee(UUID id) {
        // Retrieve the Coffee object from the repository based on the provided UUID
        repository.findById(id);
        //Delete the Coffee object with the specified UUID from the repository
        repository.deleteById(id);
    }

    
    // Methods I want to work on if I had more time 
    
    // public Coffee searchByName(String name) {
    //     throw new CoffeeNotFoundException ("TODO");

    // }
    // public List<Coffee> searchByBrand(String brand) 
    // {
    //     throw new CoffeeNotFoundException ("TODO");

    // }
    // public List<Coffee> searchByOrigin(String origin)
    // {
    //     throw new CoffeeNotFoundException ("TODO");

    // }
}
