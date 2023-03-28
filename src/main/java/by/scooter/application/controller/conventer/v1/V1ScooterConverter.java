package by.scooter.application.controller.conventer.v1;

import by.scooter.application.controller.dto.v1.scooter.V1ScooterSaveRequestDto;
import by.scooter.application.controller.dto.v1.scooter.V1ScooterUpdateRequestDto;
import by.scooter.application.service.dto.scooter.ScooterSaveRequestDto;
import by.scooter.application.service.dto.scooter.ScooterUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class V1ScooterConverter {
    private final ModelMapper modelMapper;

    public ScooterUpdateRequestDto convertControllerUpdateDtoToServiceDto(V1ScooterUpdateRequestDto v1ScooterUpdateRequestDto) {
        return modelMapper.map(v1ScooterUpdateRequestDto, ScooterUpdateRequestDto.class);
    }

    public ScooterSaveRequestDto convertControllerSaveDtoToServiceDto(V1ScooterSaveRequestDto v1ScooterSaveRequestDto) {
        return modelMapper.map(v1ScooterSaveRequestDto, ScooterSaveRequestDto.class);
    }
}
