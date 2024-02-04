package com.cbfacademy.apiassessment.coffee;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

/**
 * Controller class to implement coffee API endpoints.
 */
@RestController
@RequestMapping("/api/coffees")
public class CoffeeController {

    // CoffeeService instance for handling coffee-related business logic
    private final CoffeeService coffeeService;

    /**
     * Constructor for CoffeeController.
     *
     * @param coffeeService The CoffeeService instance injected through constructor.
     */
    public CoffeeController(CoffeeService coffeeService) {
        this.coffeeService = coffeeService;
    }

    /**
     * Retrieve a list of all coffees or retrieve the list by price.
     * If "price" is specified in the query parameter, return a sorted list of coffees by price.
     * Otherwise, return an unsorted list of all coffees.
     *
     * @param sortBy The query parameter to specify the sorting criteria.
     * @return A ResponseEntity containing the list of coffees and HttpStatus OK if successful.
     */
    @GetMapping
    public ResponseEntity<List<Coffee>> getAllCoffees(@RequestParam(required = false, defaultValue = "defaultSort") String sortBy) {
        // Retrieve the list of all coffees using the CoffeeService
        List<Coffee> coffees = coffeeService.getAllCoffees();
        
        // Check if optional parameter sortBy equals to string "price"
        // If true the request is sorted by price.
        if (sortBy.equals("price")) {
            // If sorting by price is requested, sort the coffees by price using CoffeeService
            List<Coffee> sortedCoffees = coffeeService.sortCoffeesByPrice();
            // Return a ResponseEntity with the sorted coffees and HTTP status OK
            return new ResponseEntity<>(sortedCoffees, HttpStatus.OK);
        }
        // If no sorting is requested or an invalid sortBy value is provided,
        // return a ResponseEntity with the unsorted coffees and HTTP status OK
        return new ResponseEntity<>(coffees, HttpStatus.OK);
    }

    /**
     * Retrieve a specific coffee by its ID.
     *
     * @param id The ID of the coffee to retrieve.
     * @return A ResponseEntity containing the requested coffee and HttpStatus OK if found,
     *         or HttpStatus NOT_FOUND if the ID is not found.
     */
    @GetMapping("/{id}")
    public ResponseEntity<Coffee> getCoffee(@PathVariable UUID id) {
        try {
             // Attempt to get the coffee by ID
            Coffee coffee = coffeeService.getCoffee(id);
            //If the coffee is found, return a ResponseEntity with the coffee and HTTP status OK
            return new ResponseEntity<>(coffee, HttpStatus.OK);
        } catch(IllegalArgumentException exception) {
            // Handle exception when the coffee with the specified ID is not found
            //Return a ResponseEntity with HTTP status NOT_FOUND
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Create a new coffee.
     *
     * @param coffee The coffee object to create.
     * @return A ResponseEntity containing the created coffee and HttpStatus CREATED if successful.
     */
    @PostMapping
    public ResponseEntity<Coffee> createCoffee(@RequestBody Coffee coffee) {
         // Create a new coffee and return the response
        Coffee createdCoffee = coffeeService.createCoffee(coffee);
        //Return a ResponseEntity with the created coffee and HTTP status CREATED
        return new ResponseEntity<>(createdCoffee, HttpStatus.CREATED);
    }

    /**
     * Update an existing coffee by ID.
     *
     * @param id            The ID of the coffee to update.
     * @param updatedCoffee The updated coffee object.
     * @return A ResponseEntity containing the updated coffee and HttpStatus OK if successful,
     *         or HttpStatus NOT_FOUND if the ID is not found.
     */
    @PutMapping("/{id}")
    public ResponseEntity<Coffee> updateCoffee(@PathVariable UUID id, @RequestBody Coffee updatedCoffee) {
        try {
            // Attempt to update the coffee and return the response
            Coffee coffee = coffeeService.updateCoffee(id, updatedCoffee);
            // If the coffee is updated successfully, return a ResponseEntity with the updated coffee and HTTP status OK.
            return new ResponseEntity<>(coffee, HttpStatus.OK);
        } catch (IllegalArgumentException exception) {
            // Handle exception when the coffee with the specified ID is not found
            // Return a ResponseEntity with HTTP status NOT_FOUND
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

/**
     * Delete a coffee by ID.
     *
     * @param id The ID of the coffee to delete.
     * @return A ResponseEntity with HttpStatus NO_CONTENT if the coffee was successfully deleted,
     *         or HttpStatus NOT_FOUND if the ID was not found.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCoffee(@PathVariable UUID id) {
        try {
            // Attempt to delete the coffee by ID using the coffeeService.
            coffeeService.deleteCoffee(id);
            // If the coffee is deleted successfully, return a ResponseEntity with HTTP status NO_CONTENT
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            
        } catch (IllegalArgumentException exception) {
            // Handle exception when the coffee with the specified ID is not found
            // Return a ResponseEntity with HTTP status NOT_FOUND
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


}
