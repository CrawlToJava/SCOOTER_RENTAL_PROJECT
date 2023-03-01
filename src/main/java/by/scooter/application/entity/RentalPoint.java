package by.scooter.application.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.ColumnTransformer;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "rental_points")
public class RentalPoint extends BaseEntity {
    @Column(name = "address")
    private String address;

    @Column(name = "rental_point_status")
    @Enumerated(EnumType.STRING)
    @ColumnTransformer(read = "UPPER(rental_point_status)", write = "LOWER(?)")
    private RentalPointStatus rentalPointStatus;
}
