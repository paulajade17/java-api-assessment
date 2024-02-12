package com.cbfacademy.apiassessment.coffee;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

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
     * Retrieve a list of all coffees or retrieve a list of all coffees by price.
     * If "price" is specified in the query parameter, return a sorted list of coffees by price.
     * The  "price" query parameter is optional, the method will still be called if this parameter is not provided.
     * Otherwise, return an unsorted list of all coffees.
     * ResponseEntity is apart of the springboot framework and responsible for HTTP requests.
     *
     * @param sortBy The query parameter to specify the sorting criteria.
     * @return A ResponseEntity containing the list of coffees and HttpStatus OK if successful.
     */
    // This annotation handles the HTTP GET requests.
    @GetMapping
    public ResponseEntity<List<Coffee>> getAllCoffees(@RequestParam(required = false, defaultValue = "defaultSort") String sortBy) {
        // Retrieve the list of all coffees using the CoffeeService
        List<Coffee> coffees = coffeeService.getAllCoffees();
        
        // Checks if optional parameter sortBy equals to string "price"
        // If true the request is sorted by price
        if (sortBy.equals("price")) {
            // Assigns the list of coffees by price, returned by the sortCoffeesByPrice() method, to the sortedCoffees variable
            List<Coffee> sortedCoffees = coffeeService.sortCoffeesByPrice();
            // If statement is true return a ResponseEntity with the sorted coffees and HTTP status OK
            return new ResponseEntity<>(sortedCoffees, HttpStatus.OK);
        }
        // If sortBy price is not specified (condition is not true)
        // return a ResponseEntity with the unsorted list of coffees and HTTP status OK
        return new ResponseEntity<>(coffees, HttpStatus.OK);
    }

    /**
     * Retrieve a specific coffee by its ID.
     *
     * @param id The ID of the coffee to retrieve.
     * @return A ResponseEntity containing the requested coffee and HttpStatus OK if found,
     *         or HttpStatus NOT_FOUND if the ID is not found.
     */
    // This annotation handles the HTTP GET requests for retrieving a coffee with a specific ID 
    @GetMapping("/{id}")
    public ResponseEntity<Coffee> getCoffee(@PathVariable UUID id) {
        // try catch block
        try {
             // Attempt to get the coffee by ID using coffeeService instance.
            Coffee coffee = coffeeService.getCoffee(id);
            //If the coffee is found, return a ResponseEntity with the coffee and HTTP status OK
            return new ResponseEntity<>(coffee, HttpStatus.OK);
            // If IllegalArguement is caught it means the coffee with the specific id is not found
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
    // This annotation handles the HTTP POST requests.
    @PostMapping
    //It extracts the coffee object from the request body, passes it to a CoffeeService instance to create the coffee.
    public ResponseEntity<Coffee> createCoffee(@RequestBody Coffee coffee) {
         // Create a new coffee 
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

        // PutMapping annotation handles PUT HTTP requests for updating a coffee with a specific ID 
        // {id} the id that is expected to be passed through the URL after coffees/
    @PutMapping("/{id}")
        // @PathVariable UUID id - the id is extracted from the URL path.
        // @RequestBody Coffee updatedCoffee - the updated data that will be extracted
        // and passes it a CoffeeService instance to create the updated coffee.
    public Coffee updateCoffee(@PathVariable UUID id, @RequestBody Coffee updatedCoffee) {
        // Attempts to update the coffee by calling updateCoffee method of the coffeeService instance
        // The method takes in parameter 'id' and 'updateCoffee'
        // The method returns the updated coffee
        Coffee coffee = coffeeService.updateCoffee(id, updatedCoffee);
        // Checks if updated coffee object returned from updatedCoffee method is null, if it is it means the coffee with the specified ID was not found 
        if (coffee == null) {
        // Throw a ResponseStatusException with HTTP status code 404 (NOT_FOUND)
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Coffee not found");
        }
        // coffee will be returned if the update was successful
        return coffee;
        }
        
        

    /**
     * Delete a coffee by ID.
     *
     * @param id The ID of the coffee to delete.
     * @return A ResponseEntity with HttpStatus NO_CONTENT if the coffee was successfully deleted,
     *         or HttpStatus NOT_FOUND if the ID was not found.
     */

    // This annotation handles the HTTP DELETE requests for updating a coffee with a specific ID.
    // {id} the id that is expected to be passed through the URL after coffees.
    @DeleteMapping("/{id}")
     // @PathVariable UUID id - the id is extracted from the URL path
    public void deleteCoffee(@PathVariable UUID id) {
    // Exception handling
    try {
        // Attempts to delete the coffee by ID using a coffeeService instance.
        coffeeService.deleteCoffee(id);
    } catch (CoffeeNotFoundException exception) {
        // If the coffee with the specified ID is not found.
        // throw a ResponseStatusException with HTTP status code 404 NOT_FOUND
        throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }
}


}
