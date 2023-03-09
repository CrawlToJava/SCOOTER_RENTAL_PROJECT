package by.scooter.application.service.impl;

import by.scooter.application.entity.RentalPoint;
import by.scooter.application.exception.NoDataFoundException;
import by.scooter.application.repository.RentalPointRepository;
import by.scooter.application.service.RentalPointService;
import by.scooter.application.service.conventer.RentalPointConverter;
import by.scooter.application.service.dto.rental_point.RentalPointSaveRequestDto;
import by.scooter.application.service.dto.rental_point.RentalPointUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

import static by.scooter.application.entity.RentalPointStatus.DELETED;

@Service
@RequiredArgsConstructor
@Slf4j
public class RentalPointServiceImpl implements RentalPointService {
    private final RentalPointRepository rentalPointRepository;

    private final RentalPointConverter rentalPointConverter;

    @Override
    @Transactional
    public void save(RentalPointSaveRequestDto rentalPointSaveRequest) {
        rentalPointRepository.save(rentalPointConverter.convertSaveDtoRequestToEntity(rentalPointSaveRequest));
        log.info("Rental point successfully saved");
    }

    @Override
    @Transactional
    public void update(RentalPointUpdateRequestDto rentalPointUpdateRequestDto) {
        getByUUID(rentalPointUpdateRequestDto.getUuid());
        rentalPointRepository.save(rentalPointConverter.convertUpdateDtoRequestToEntity(rentalPointUpdateRequestDto));
        log.info("Rental point successfully updated");
    }

    @Override
    @Transactional
    public void delete(UUID uuid) {
        RentalPoint rentalPointFromDb = getByUUID(uuid);
        rentalPointFromDb.setRentalPointStatus(DELETED);
        rentalPointRepository.save(rentalPointFromDb);
        log.info("Rental point successfully deleted");
    }

    private RentalPoint getByUUID(UUID rentalPointUUID) {
        return rentalPointRepository.findByUuid(rentalPointUUID).orElseThrow(() -> new NoDataFoundException("Rental point not found by " + rentalPointUUID + " uuid"));
    }
}
