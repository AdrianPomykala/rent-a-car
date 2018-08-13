package com.project.rentacar.controller;

import com.project.rentacar.model.Rental;
import com.project.rentacar.service.RentalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/rentals")
public class RentalController {

    @Autowired
    RentalService rentalService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Rental create(@RequestBody @Valid Rental rental, BindingResult bindingResult) {
        return rentalService.create(rental, bindingResult);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Rental getById(@PathVariable Long id) {
        return rentalService.getById(id);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Page<Rental> search(
            @RequestParam(required = false, defaultValue = "") String pickUpPoint,
            @RequestParam(required = false, defaultValue = "") String dropOffPoint,
            @RequestParam(required = false) Set finished,
            @RequestParam(required = false, defaultValue = "0") Integer minLength,
            @RequestParam(required = false) Integer maxLength,
            @RequestParam(required = false, defaultValue = "0") Integer minPrice,
            @RequestParam(required = false) Integer maxPrice,
            Pageable pageable) {
        return rentalService.search(pickUpPoint, dropOffPoint, finished, minLength, maxLength, minPrice, maxPrice, pageable);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        rentalService.delete(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Rental update(
            @PathVariable Long id,
            @RequestBody @Valid Rental rental, BindingResult bindingResult) {
        return rentalService.update(id, rental, bindingResult);
    }
}
