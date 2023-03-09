package by.scooter.application.service.conventer;

import by.scooter.application.entity.Model;
import by.scooter.application.service.dto.model.ModelResponseDto;
import by.scooter.application.service.dto.model.ModelSaveRequestDto;
import by.scooter.application.service.dto.model.ModelUpdateRequestDto;
import liquibase.hub.model.Project;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ModelConverter {
    private final ModelMapper modelMapper;

    public Model convertSaveDtoRequestDtoToEntity(ModelSaveRequestDto modelSaveRequestDto) {
        return modelMapper.map(modelSaveRequestDto, Model.class);
    }

    public Model convertUpdateDtoRequestDtoToEntity(ModelUpdateRequestDto modelUpdateRequestDto) {
        return modelMapper.map(modelUpdateRequestDto, Model.class);
    }

    public ModelResponseDto convertEntityToResponseDto(Project project) {
        return modelMapper.map(project, ModelResponseDto.class);
    }
}

