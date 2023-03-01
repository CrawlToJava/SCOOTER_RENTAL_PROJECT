package by.scooter.application.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.ColumnTransformer;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "orders")
public class Order extends BaseEntity {

    @Column(name = "ordered_at")
    private LocalDateTime orderedAt;

    @Column(name = "finished_at")
    private LocalDateTime finishedAt;

    @Column(name = "total_price")
    private BigDecimal totalPrice;

    @Column(name = "order_status")
    @Enumerated(EnumType.STRING)
    @ColumnTransformer(read = "UPPER(order_status)", write = "LOWER(?)")
    private OrderStatus orderStatus;

    @ManyToOne(fetch = FetchType.EAGER)
    private User user;

    @ManyToOne(fetch = FetchType.EAGER)
    private Scooter scooter;

    @ManyToOne(fetch = FetchType.EAGER)
    private RentalPoint rentalPoint;
}
