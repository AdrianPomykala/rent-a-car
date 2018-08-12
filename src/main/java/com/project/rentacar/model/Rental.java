package com.project.rentacar.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
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

    @NotBlank
    @Column(nullable = false)
    private LocalDate startDate;

    @NotBlank
    @Column(nullable = false)
    private LocalDate endDate;

    @NotBlank
    @Column(nullable = false)
    private Integer length;

    @NotBlank
    @Column(nullable = false)
    private Integer price;

}
