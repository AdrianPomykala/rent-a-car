package com.project.rentacar.service;

import com.project.rentacar.exception.BindingResultException;
import com.project.rentacar.model.Brand;
import com.project.rentacar.model.Car;
import com.project.rentacar.model.CarSegment;
import com.project.rentacar.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import java.util.Arrays;
import java.util.HashSet;
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

    public Page<Car> search(Set brands, Set carSegments, Long minPrice, Long maxPrice, Pageable pageable) {
        if(maxPrice == null) {
            maxPrice = Long.MAX_VALUE;
        }
        if(brands == null) {
            Set brandsSet = new HashSet();
            brandsSet.addAll(Arrays.asList(Brand.values()));
            brands = brandsSet;
        }
        if(carSegments == null) {
            Set carSegmentsSet = new HashSet();
            carSegmentsSet.addAll(Arrays.asList(CarSegment.values()));
            carSegments = carSegmentsSet;
        }
        return carRepository.findByBrandInAndPriceGreaterThanEqualAndPriceLessThanEqualAndCarSegmentIn(brands, minPrice, maxPrice, carSegments, pageable);
    }

    private void validateCar(BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new BindingResultException(bindingResult);
        }
    }


}
