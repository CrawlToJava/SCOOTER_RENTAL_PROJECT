package by.scooter.application.service.impl;

import by.scooter.application.exception.NoDataFoundException;
import by.scooter.application.repository.ModelRepository;
import by.scooter.application.service.ModelService;
import by.scooter.application.service.conventer.ModelConverter;
import by.scooter.application.service.dto.model.ModelSaveRequestDto;
import by.scooter.application.service.dto.model.ModelUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class ModelServiceImpl implements ModelService {
    private final ModelRepository modelRepository;

    private final ModelConverter modelConverter;

    @Override
    @Transactional
    public void save(ModelSaveRequestDto modelSaveRequestDto) {
        modelRepository.save(modelConverter.convertSaveDtoRequestDtoToEntity(modelSaveRequestDto));
        log.info("Model successfully saved");
    }

    @Override
    @Transactional
    public void update(ModelUpdateRequestDto modelUpdateRequestDto) {
        getByUUID(modelUpdateRequestDto.getUuid());
        modelRepository.save(modelConverter.convertUpdateDtoRequestDtoToEntity(modelUpdateRequestDto));
        log.info("Model successfully updated");
    }


    private void getByUUID(UUID modelUUID) {
        modelRepository.findByUuid(modelUUID).orElseThrow(() -> new NoDataFoundException("User not found by " + modelUUID + " uuid"));
    }
}
