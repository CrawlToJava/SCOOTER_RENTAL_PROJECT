package by.scooter.application.service.dto.order;

import by.scooter.application.entity.OrderStatus;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;
import org.hibernate.annotations.ColumnTransformer;

import java.util.UUID;

@Data
public class OrderSaveRequestDto {
    @Enumerated(EnumType.STRING)
    @ColumnTransformer(read = "UPPER(order_status)", write = "LOWER(?)")

    private OrderStatus orderStatus;

    private UUID userUUID;

    private UUID scooterUUID;

    private UUID rentalPointUUID;
}
