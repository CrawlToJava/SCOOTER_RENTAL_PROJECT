package by.scooter.application.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Scooter extends BaseEntity {

    private Model model;

    private RentalPoint rentalPoint;

    private ScooterStatus scooterStatus;

    private BigDecimal scooterPrice;
}
