package by.scooter.application.service.impl;

import by.scooter.application.entity.User;
import by.scooter.application.exception.NoDataFoundException;
import by.scooter.application.repository.UserRepository;
import by.scooter.application.service.UserService;
import by.scooter.application.service.conventer.UserConverter;
import by.scooter.application.service.dto.user.UserSaveRequestDto;
import by.scooter.application.service.dto.user.UserUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

import static by.scooter.application.entity.UserStatus.DELETED;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final UserConverter userConverter;

    @Override
    @Transactional
    public void save(UserSaveRequestDto userSaveRequestDto) {
        userRepository.save(userConverter.convertSaveRequestDtoToEntity(userSaveRequestDto));
        log.info("User successfully saved");
    }

    @Override
    @Transactional
    public void update(UserUpdateRequestDto userUpdateRequestDto) {
        getByUUID(userUpdateRequestDto.getUuid());
        userRepository.save(userConverter.convertUpdateRequestDtoToEntity(userUpdateRequestDto));
        log.info("User successfully updated");
    }

    @Override
    @Transactional
    public void delete(UUID uuid) {
        User userFromDb = getByUUID(uuid);
        userFromDb.setUserStatus(DELETED);
        userRepository.save(userFromDb);
        log.info("User successfully deleted");
    }

    private User getByUUID(UUID userUUID) {
        return userRepository.findByUuid(userUUID).orElseThrow(() -> new NoDataFoundException("User not found by " + userUUID + " uuid"));
    }
}
