package by.scooter.application.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class RentalPoint extends BaseEntity {
    private String address;

    private RentalPointStatus rentalPointStatus;
}
