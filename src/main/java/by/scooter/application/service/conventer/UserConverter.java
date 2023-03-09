package by.scooter.application.service.conventer;

import by.scooter.application.entity.User;
import by.scooter.application.service.dto.user.UserResponseDto;
import by.scooter.application.service.dto.user.UserSaveRequestDto;
import by.scooter.application.service.dto.user.UserUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserConverter {
    private final ModelMapper modelMapper;

    public User convertSaveRequestDtoToEntity(UserSaveRequestDto userSaveRequestDto) {
        return modelMapper.map(userSaveRequestDto, User.class);
    }

    public User convertUpdateRequestDtoToEntity(UserUpdateRequestDto userUpdateRequestDto) {
        return modelMapper.map(userUpdateRequestDto, User.class);
    }

    public UserResponseDto convertEntityToResponseDto(User user) {
        return modelMapper.map(user, UserResponseDto.class);
    }
}
