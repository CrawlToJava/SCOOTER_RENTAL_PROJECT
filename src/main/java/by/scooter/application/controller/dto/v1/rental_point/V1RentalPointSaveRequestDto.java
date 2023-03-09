package by.scooter.application.controller.dto.v1.rental_point;

import by.scooter.application.entity.RentalPointStatus;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;
import org.hibernate.annotations.ColumnTransformer;

@Data
public class V1RentalPointSaveRequestDto {
    private String address;

    @Enumerated(EnumType.STRING)
    @ColumnTransformer(read = "UPPER(rental_point_status)", write = "LOWER(?)")
    private RentalPointStatus rentalPointStatus;
}