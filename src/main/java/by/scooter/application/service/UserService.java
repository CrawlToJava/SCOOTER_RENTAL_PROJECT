package by.scooter.application.service;

import by.scooter.application.service.dto.user.UserSaveRequestDto;
import by.scooter.application.service.dto.user.UserUpdateRequestDto;

import java.util.UUID;

public interface UserService {
    void save(UserSaveRequestDto userSaveRequestDto);

    void update(UserUpdateRequestDto userUpdateRequestDto);

    void delete(UUID uuid);
}
