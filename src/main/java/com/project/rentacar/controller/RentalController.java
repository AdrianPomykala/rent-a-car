package com.project.rentacar.controller;

import com.project.rentacar.model.Rental;
import com.project.rentacar.service.RentalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

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
}
