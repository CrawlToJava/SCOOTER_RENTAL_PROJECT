package by.scooter.application.service.impl;

import by.scooter.application.entity.Scooter;
import by.scooter.application.exception.NoDataFoundException;
import by.scooter.application.repository.ScooterRepository;
import by.scooter.application.service.ScooterService;
import by.scooter.application.service.conventer.ScooterConverter;
import by.scooter.application.service.dto.scooter.ScooterSaveRequestDto;
import by.scooter.application.service.dto.scooter.ScooterUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

import static by.scooter.application.entity.ScooterStatus.DELETED;

@Service
@RequiredArgsConstructor
@Slf4j
public class ScooterServiceImpl implements ScooterService {
    private final ScooterRepository scooterRepository;

    private final ScooterConverter scooterConverter;

    @Override
    @Transactional
    public void save(ScooterSaveRequestDto scooterSaveRequestDto) {
        scooterRepository.save(scooterConverter.convertSaveRequestDtoToEntity(scooterSaveRequestDto));
        log.info("Scooter successfully saved");
    }

    @Override
    @Transactional
    public void update(ScooterUpdateRequestDto scooterUpdateRequestDto) {
        getByUUID(scooterUpdateRequestDto.getUuid());
        scooterRepository.save(scooterConverter.convertUpdateRequestDtoToEntity(scooterUpdateRequestDto));
        log.info("Scooter successfully updated");
    }

    @Override
    @Transactional
    public void delete(UUID uuid) {
        Scooter scooterFromDb = getByUUID(uuid);
        scooterFromDb.setScooterStatus(DELETED);
        scooterRepository.save(scooterFromDb);
        log.info("Scooter successfully deleted");
    }

    private Scooter getByUUID(UUID scooterUUID) {
        return scooterRepository.findByUuid(scooterUUID).orElseThrow(() -> new NoDataFoundException("Scooter not found by " + scooterUUID + " uuid"));
    }
}
