package by.scooter.application.service.conventer;

import by.scooter.application.entity.RentalPoint;
import by.scooter.application.service.dto.rental_point.RentalPointResponseDto;
import by.scooter.application.service.dto.rental_point.RentalPointSaveRequestDto;
import by.scooter.application.service.dto.rental_point.RentalPointUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RentalPointConverter {

    private final ModelMapper modelMapper;

    public RentalPoint convertSaveDtoRequestToEntity(RentalPointSaveRequestDto rentalPointSaveRequestDto) {
        return modelMapper.map(rentalPointSaveRequestDto, RentalPoint.class);
    }

    public RentalPoint convertUpdateDtoRequestToEntity(RentalPointUpdateRequestDto rentalPointUpdateRequestDto) {
        return modelMapper.map(rentalPointUpdateRequestDto, RentalPoint.class);
    }

    public RentalPointResponseDto convertEntityToResponseDto(RentalPoint rentalPoint) {
        return modelMapper.map(rentalPoint, RentalPointResponseDto.class);
    }
}
