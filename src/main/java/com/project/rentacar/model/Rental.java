package com.project.rentacar.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Future;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

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

    @ManyToOne
    @JoinColumn(name = "car_id")
    private Car car;

}
