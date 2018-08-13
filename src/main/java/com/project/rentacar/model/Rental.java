package com.project.rentacar.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import javax.validation.constraints.*;
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

    @Column(nullable = false)
    private Integer length;

    @Column(nullable = false)
    private Integer price;

    @NotNull
    @Column(nullable = false)
    @Type(type = "yes_no")
    private boolean Finished = false;

    @ManyToOne()
    @JoinColumn(name = "car_id")
    private Car car;

    public boolean isFinished() {
        if (endDate.isBefore(LocalDate.now())) {
            this.Finished = true;
        }
        return Finished;
    }

}
