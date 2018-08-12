package com.project.rentacar.controller;


import com.project.rentacar.model.Brand;
import com.project.rentacar.model.Car;
import com.project.rentacar.model.CarSegment;
import com.project.rentacar.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Set;

@RestController
@RequestMapping("/cars")
public class CarController {

    @Autowired
    private CarService carService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Car create(@RequestBody @Valid Car car, BindingResult bindingResult) {
        return carService.create(car, bindingResult);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Page<Car> search(
            @RequestParam(required = false) Set<Brand> brands,
            @RequestParam(required = false) Set<CarSegment> carSegments,
            @RequestParam(defaultValue = "0") Long minPrice,
            @RequestParam(required = false) Long maxPrice,
            Pageable pageable) {
        return carService.search(brands, carSegments, minPrice, maxPrice, pageable);
    }
}
