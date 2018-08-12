package com.project.rentacar.service;

import com.project.rentacar.exception.BindingResultException;
import com.project.rentacar.model.Rental;
import com.project.rentacar.repository.RentalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

@Service
public class RentalService {

    @Autowired
    RentalRepository rentalRepository;

    public Rental create(Rental rental, BindingResult bindingResult) {
        validateRental(bindingResult);
        return rentalRepository.save(rental);
    }

    private void validateRental(BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new BindingResultException(bindingResult);
        }
    }
}
