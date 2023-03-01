package by.scooter.application.repository;

import by.scooter.application.entity.Model;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface ModelRepository extends JpaRepository<Model, Long> {
    Optional<Model> findByUuid(UUID uuid);
}
