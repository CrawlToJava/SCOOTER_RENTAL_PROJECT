package by.scooter.application.repository;

import by.scooter.application.entity.RentalPoint;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface RentalPointRepository extends JpaRepository<RentalPoint, Long> {
    Optional<RentalPoint> findByUuid(UUID uuid);
}
