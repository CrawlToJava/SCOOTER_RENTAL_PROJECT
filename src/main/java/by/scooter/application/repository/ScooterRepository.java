package by.scooter.application.repository;

import by.scooter.application.entity.Scooter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;
import java.util.UUID;

public interface ScooterRepository extends JpaRepository<Scooter, Long> {

    @Query("select s from Scooter s left join fetch s.rentalPoint"
            + " left join fetch s.model where s.uuid = :uuid")
    Optional<Scooter> findByUuid(@Param("uuid") UUID uuid);
}
