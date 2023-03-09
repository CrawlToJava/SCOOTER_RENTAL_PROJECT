package by.scooter.application.controller.conventer.v1;

import by.scooter.application.controller.dto.v1.user.V1UserSaveRequestDto;
import by.scooter.application.controller.dto.v1.user.V1UserUpdateRequestDto;
import by.scooter.application.service.dto.user.UserSaveRequestDto;
import by.scooter.application.service.dto.user.UserUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class V1UserConverter {
    private final ModelMapper modelMapper;

    public UserUpdateRequestDto convertControllerUpdateDtoToServiceDto(V1UserUpdateRequestDto v1UserUpdateRequestDto) {
        return modelMapper.map(v1UserUpdateRequestDto, UserUpdateRequestDto.class);
    }

    public UserSaveRequestDto convertControllerSaveDtoToServiceDto(V1UserSaveRequestDto v1UserSaveRequestDto) {
        return modelMapper.map(v1UserSaveRequestDto, UserSaveRequestDto.class);
    }
}
