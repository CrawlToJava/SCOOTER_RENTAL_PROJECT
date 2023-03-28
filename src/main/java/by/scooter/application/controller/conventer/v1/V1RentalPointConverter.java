package by.scooter.application.controller.conventer.v1;

import by.scooter.application.controller.dto.v1.rental_point.V1RentalPointSaveRequestDto;
import by.scooter.application.controller.dto.v1.rental_point.V1RentalPointUpdateRequestDto;
import by.scooter.application.service.dto.rental_point.RentalPointSaveRequestDto;
import by.scooter.application.service.dto.rental_point.RentalPointUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class V1RentalPointConverter {
    private final ModelMapper modelMapper;

    public RentalPointUpdateRequestDto convertControllerUpdateDtoToServiceDto(V1RentalPointUpdateRequestDto v1RentalPointUpdateRequestDto) {
        return modelMapper.map(v1RentalPointUpdateRequestDto, RentalPointUpdateRequestDto.class);
    }

    public RentalPointSaveRequestDto convertControllerSaveDtoToServiceDto(V1RentalPointSaveRequestDto v1RentalPointSaveRequestDto) {
        return modelMapper.map(v1RentalPointSaveRequestDto, RentalPointSaveRequestDto.class);
    }
}
