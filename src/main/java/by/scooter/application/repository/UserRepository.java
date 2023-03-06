package by.scooter.application.repository;

import by.scooter.application.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUuid(UUID uuid);

    List<User> findByLastName(String lastName);
}
