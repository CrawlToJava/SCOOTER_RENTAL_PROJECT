package by.scooter.application.service;

import by.scooter.application.service.dto.model.ModelSaveRequestDto;
import by.scooter.application.service.dto.model.ModelUpdateRequestDto;

public interface ModelService {

    void save(ModelSaveRequestDto modelSaveRequestDto);

    void update(ModelUpdateRequestDto modelUpdateRequestDto);
}
