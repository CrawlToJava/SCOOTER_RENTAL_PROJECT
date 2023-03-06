package by.scooter.application.service.dto.scooter;

import by.scooter.application.entity.ScooterStatus;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;
import org.hibernate.annotations.ColumnTransformer;

import java.math.BigDecimal;
import java.util.UUID;

@Data
public class ScooterResponseDto {
    private UUID uuid;

    private UUID modelUUID;

    private UUID rentalPointUUID;

    @Enumerated(EnumType.STRING)
    @ColumnTransformer(read = "UPPER(scooter_status)", write = "LOWER(?)")
    private ScooterStatus scooterStatus;

    private BigDecimal scooterPrice;

}
