package com.project.rentacar.service;

import com.project.rentacar.exception.BindingResultException;
import com.project.rentacar.exception.NotFoundException;
import com.project.rentacar.model.Rental;
import com.project.rentacar.repository.RentalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class RentalService {

    @Autowired
    RentalRepository rentalRepository;

    public Rental create(Rental rental, BindingResult bindingResult) {
        validateRental(bindingResult);
        return rentalRepository.save(rental);
    }

    public Rental getById(Long id) {
        Optional<Rental> rentalOptional = rentalRepository.findById(id);
        if (!rentalOptional.isPresent()) {
            throw new NotFoundException(String.format("Rental with id %s not found!", id));
        }
        return rentalOptional.get();
    }

    public Page<Rental> search(
            String pickUpPoint,
            String dropOffPoint,
            Set finished,
            Integer minLength,
            Integer maxLength,
            Integer minPrice,
            Integer maxPrice,
            Pageable pageable) {
        return rentalRepository.findByPickUpPointContainingAndDropOffPointContainingAndFinishedInAndLengthGreaterThanEqualAndLengthLessThanEqualAndPriceGreaterThanEqualAndPriceLessThanEqual(
                pickUpPoint,
                dropOffPoint,
                finished,
                minLength,
                maxLength,
                minPrice,
                maxPrice,
                pageable
        );
    }

    public void delete(Long id) {
        if (rentalRepository.existsById(id)) {
            throw new NotFoundException(String.format("Rental with id %s was not found", id));
        }
        rentalRepository.deleteById(id);
    }

    public Rental update(Long id, Rental rental, BindingResult bindingResult) {
        validateRental(bindingResult);
        if (rentalRepository.existsById(id)) {
            throw new NotFoundException(String.format("Rental with id %s was not found", id));
        }
        rental.setId(id);
        return rentalRepository.save(rental);
    }

    private void validateRental(BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new BindingResultException(bindingResult);
        }
    }
}
