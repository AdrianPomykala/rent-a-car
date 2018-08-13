package com.project.rentacar.repository;

import com.project.rentacar.model.Rental;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface RentalRepository extends JpaRepository<Rental, Long> {
    Page<Rental> findByPickUpPointContainingAndDropOffPointContainingAndFinishedInAndLengthGreaterThanEqualAndLengthLessThanEqualAndPriceGreaterThanEqualAndPriceLessThanEqual(
            String pickUpPoint,
            String dropOffPoint,
            Set isFinished,
            Integer minLength,
            Integer maxLength,
            Integer minPrice,
            Integer maxPrice,
            Pageable pageable
    );
}
