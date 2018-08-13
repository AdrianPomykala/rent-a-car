package com.project.rentacar.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "cars")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(nullable = false)
    @Enumerated(value = EnumType.STRING)
    private Brand brand;

    @NotBlank
    @Column(nullable = false)
    private String model;

    @NotNull
    @Column(nullable = false)
    @Enumerated(value = EnumType.STRING)
    private CarSegment carSegment;

    @NotNull
    @Min(1)
    @Max(10000)
    @Column(nullable = false)
    private Long price;
//
//    @OneToMany(mappedBy="car")
//    @JoinColumn(name="RENTAL_ID")
//    private List<Rental> rentals = new ArrayList<>();

}
