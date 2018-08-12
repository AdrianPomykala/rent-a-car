package com.project.rentacar.repository;

import com.project.rentacar.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface CarRepository  extends JpaRepository<Car, Long> {

    List<Car> findByBrandInAndPriceGreaterThanEqualAndPriceLessThanEqualAAndCarSegmentIn(
            Set brand,
            Long minPrice,
            Long maxPrice,
            Set carSegment
    );
}
