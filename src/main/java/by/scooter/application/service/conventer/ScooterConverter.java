package by.scooter.application.service.conventer;

import by.scooter.application.entity.Scooter;
import by.scooter.application.service.dto.scooter.ScooterResponseDto;
import by.scooter.application.service.dto.scooter.ScooterSaveRequestDto;
import by.scooter.application.service.dto.scooter.ScooterUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ScooterConverter {
    private final ModelMapper modelMapper;

    public Scooter convertSaveRequestDtoToEntity(ScooterSaveRequestDto scooterSaveRequestDto) {
        return modelMapper.map(scooterSaveRequestDto, Scooter.class);
    }

    public Scooter convertUpdateRequestDtoToEntity(ScooterUpdateRequestDto scooterUpdateRequestDto) {
        return modelMapper.map(scooterUpdateRequestDto, Scooter.class);
    }

    public ScooterResponseDto convertEntityToResponseDto(Scooter scooter) {
        return modelMapper.map(scooter, ScooterResponseDto.class);
    }
}
