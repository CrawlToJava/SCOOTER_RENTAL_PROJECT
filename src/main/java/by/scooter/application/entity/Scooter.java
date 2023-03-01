package by.scooter.application.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.ColumnTransformer;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "scooters")
public class Scooter extends BaseEntity {

    @ManyToOne(fetch = FetchType.EAGER)
    private Model model;

    @ManyToOne(fetch = FetchType.EAGER)
    private RentalPoint rentalPoint;

    @Column(name = "scooter_status")
    @Enumerated(EnumType.STRING)
    @ColumnTransformer(read = "UPPER(scooter_status)", write = "LOWER(?)")
    private ScooterStatus scooterStatus;

    @Column(name = "scooter_price")
    private BigDecimal scooterPrice;
}
