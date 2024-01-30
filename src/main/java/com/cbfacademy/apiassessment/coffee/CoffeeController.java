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

    private final CoffeeService coffeeService;

    public CoffeeController(CoffeeService coffeeService) {
        this.coffeeService = coffeeService;
    }

    /**
     * Retrieve a list of all coffees.
     *
     * @return A ResponseEntity containing a list of all coffees and HttpStatus OK if
     *         successful.
     */
    @GetMapping
    public ResponseEntity<List<Coffee>> getAllCoffees() {
        List<Coffee> coffees = coffeeService.getAllCoffees();

        return new ResponseEntity<>(coffees, HttpStatus.OK);
    }

    /**
     * Retrieve a specific coffee by its ID.
     *
     * @param id The ID of the coffee to retrieve.
     * @return A ResponseEntity containing the requested coffee and HttpStatus OK if
     *         found,
     *         or HttpStatus NOT_FOUND if the ID is not found.
     */
    @GetMapping("/{id}")
    public ResponseEntity<Coffee> getCoffee(@PathVariable UUID id) {
        try {
            Coffee coffee = coffeeService.getCoffee(id);

            return new ResponseEntity<>(coffee, HttpStatus.OK);
        } catch(IllegalArgumentException exception) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Create a new coffee.
     *
     * @param coffee The coffee object to create.
     * @return A ResponseEntity containing the created coffee and HttpStatus CREATED if
     *         successful.
     */
    @PostMapping
    public ResponseEntity<Coffee> createCoffee(@RequestBody Coffee coffee) {
        Coffee createdCoffee = coffeeService.createCoffee(coffee);

        return new ResponseEntity<>(createdCoffee, HttpStatus.CREATED);
    }

    /**
     * Update an existing coffee by ID.
     *
     * @param id         The ID of the coffee to update.
     * @param updatedCoffee The updated coffee object.
     * @return A ResponseEntity containing the updated coffee and HttpStatus OK if
     *         successful,
     *         or HttpStatus NOT_FOUND if the ID is not found.
     */
    @PutMapping("/{id}")
    public ResponseEntity<Coffee> updateCoffee(@PathVariable UUID id, @RequestBody Coffee updatedCoffee) {
        try {
            Coffee coffee = coffeeService.updateCoffee(id, updatedCoffee);

            return new ResponseEntity<>(coffee, HttpStatus.OK);
        } catch (IllegalArgumentException exception) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Delete a coffee by ID.
     *
     * @param id The ID of the coffee to delete.
     * @return A ResponseEntity with HttpStatus NO_CONTENT if the coffee was
     *         successfully deleted,
     *         or HttpStatus NOT_FOUND if the ID was not found.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCoffee(@PathVariable UUID id) {
        try {
            coffeeService.deleteCoffee(id);

            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (IllegalArgumentException exception) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
