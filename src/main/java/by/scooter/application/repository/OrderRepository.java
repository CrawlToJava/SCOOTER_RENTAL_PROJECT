package by.scooter.application.repository;

import by.scooter.application.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;
import java.util.UUID;

public interface OrderRepository extends JpaRepository<Order, Long> {

    @Query("select o from Order o left join fetch o.user" +
            " left join fetch o.rentalPoint" +
            " left join fetch o.scooter where o.uuid = :uuid")
    Optional<Order> findByUuid(@Param(value = "uuid") UUID uuid);
}
