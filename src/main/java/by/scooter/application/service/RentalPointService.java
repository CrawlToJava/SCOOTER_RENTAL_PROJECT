package by.scooter.application.service;

import by.scooter.application.service.dto.rental_point.RentalPointSaveRequestDto;
import by.scooter.application.service.dto.rental_point.RentalPointUpdateRequestDto;

import java.util.UUID;

public interface RentalPointService {
    void save(RentalPointSaveRequestDto rentalPointSaveRequest);

    void update(RentalPointUpdateRequestDto rentalPointUpdateRequestDto);

    void delete(UUID uuid);
}
