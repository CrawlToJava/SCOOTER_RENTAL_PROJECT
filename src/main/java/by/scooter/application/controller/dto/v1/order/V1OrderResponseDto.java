package by.scooter.application.controller.dto.v1.order;

import by.scooter.application.entity.OrderStatus;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;
import org.hibernate.annotations.ColumnTransformer;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class V1OrderResponseDto {
    private UUID uuid;

    @Enumerated(EnumType.STRING)
    @ColumnTransformer(read = "UPPER(order_status)", write = "LOWER(?)")
    private OrderStatus orderStatus;

    private LocalDateTime orderedAt;

    private LocalDateTime finishedAt;

    private BigDecimal totalPrice;

    private UUID userUUID;

    private UUID scooterUUID;

    private UUID rentalPointUUID;
}
