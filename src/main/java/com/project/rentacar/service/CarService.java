package com.project.rentacar.service;

import com.project.rentacar.exception.BindingResultException;
import com.project.rentacar.model.Car;
import com.project.rentacar.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import java.util.List;
import java.util.Set;

@Service
public class CarService {

    @Autowired
    private CarRepository carRepository;

    public Car create(Car car, BindingResult bindingResult) {
        validateCar(bindingResult);
        return carRepository.save(car);
    }

    public Page<Car> search(Set brand, Set carSegment, Long minPrice, Long maxPrice, Pageable pageable) {
        if(maxPrice == null) {
            maxPrice = Long.MAX_VALUE;
        }
        return carRepository.findByBrandInAndPriceGreaterThanEqualAndPriceLessThanEqualAndCarSegmentIn(brand, minPrice, maxPrice, carSegment, pageable);
    }

    private void validateCar(BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new BindingResultException(bindingResult);
        }
    }


}
