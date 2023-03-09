package by.scooter.application.controller.conventer.v1;

import by.scooter.application.controller.dto.v1.model.V1ModelSaveRequestDto;
import by.scooter.application.controller.dto.v1.model.V1ModelUpdateRequestDto;
import by.scooter.application.service.dto.model.ModelSaveRequestDto;
import by.scooter.application.service.dto.model.ModelUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class V1ModelConverter {
    private final ModelMapper modelMapper;

    public ModelUpdateRequestDto convertControllerUpdateDtoToServiceDto(V1ModelUpdateRequestDto v1ModelUpdateRequestDto) {
        return modelMapper.map(v1ModelUpdateRequestDto, ModelUpdateRequestDto.class);
    }

    public ModelSaveRequestDto convertControllerSaveDtoToServiceDto(V1ModelSaveRequestDto v1ModelSaveRequestDto) {
        return modelMapper.map(v1ModelSaveRequestDto, ModelSaveRequestDto.class);
    }
}
