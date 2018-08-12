package com.project.rentacar.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "rentals")
public class Rental {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(nullable = false)
    private String pickUpPoint;

    @NotBlank
    @Column(nullable = false)
    private String dropOffPoint;

    @FutureOrPresent
    @NotNull
    @Column(nullable = false)
    private LocalDate startDate;

    @Future
    @NotNull
    @Column(nullable = false)
    private LocalDate endDate;

    @NotNull
    @Column(nullable = false)
    private Integer length;

    @NotNull
    @Column(nullable = false)
    private Integer price;

    @ManyToOne()
    @JoinColumn(name = "car_id")
    private Car car;

//    @Size(min = 1)
//    @ManyToMany
//    @JoinTable(
//            name = "rentals_cars",
//            joinColumns = @JoinColumn(name = "rental_id", nullable = false),
//            inverseJoinColumns = @JoinColumn(name = "car_id", nullable = false)
//    )
//    private List<Car> cars;

}
