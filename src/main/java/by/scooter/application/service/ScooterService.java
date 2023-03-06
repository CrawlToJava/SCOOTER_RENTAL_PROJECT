package by.scooter.application.service;

import by.scooter.application.service.dto.scooter.ScooterSaveRequestDto;
import by.scooter.application.service.dto.scooter.ScooterUpdateRequestDto;

import java.util.UUID;

public interface ScooterService {
    void save(ScooterSaveRequestDto scooterSaveRequestDto);

    void update(ScooterUpdateRequestDto scooterUpdateRequestDto);

    void delete(UUID uuid);
}
