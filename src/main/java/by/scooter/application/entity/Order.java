package by.scooter.application.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Order extends BaseEntity {

    private LocalDateTime orderedAt;

    private LocalDateTime finishedAt;

    private BigDecimal totalPrice;

    private OrderStatus orderStatus;

    private User user;

    private Scooter scooter;

    private RentalPoint rentalPoint;
}
