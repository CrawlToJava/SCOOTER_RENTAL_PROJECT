package by.scooter.application.controller.dto.v1.order;

import by.scooter.application.entity.OrderStatus;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;
import org.hibernate.annotations.ColumnTransformer;

import java.util.UUID;

@Data
public class V1OrderSaveRequestDto {
    @Enumerated(EnumType.STRING)
    @ColumnTransformer(read = "UPPER(order_status)", write = "LOWER(?)")
    private OrderStatus orderStatus;

    private UUID userUUID;

    private UUID scooterUUID;

    private UUID rentalPointUUID;
}
