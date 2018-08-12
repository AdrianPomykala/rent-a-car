package com.project.rentacar.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "cars")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(nullable = false)
    @Enumerated(value = EnumType.STRING)
    private Brand brand;

    @NotBlank
    @Column(nullable = false)
    private String model;

    @NotBlank
    @Min(1)
    @Column(nullable = false)
    private Long price;




}
