package by.scooter.application.controller.v1;

import by.scooter.application.controller.conventer.v1.V1UserConverter;
import by.scooter.application.controller.dto.v1.user.V1UserSaveRequestDto;
import by.scooter.application.controller.dto.v1.user.V1UserUpdateRequestDto;
import by.scooter.application.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/api/v1/user")
public class V1UserController {
    private final UserService userService;

    private final V1UserConverter userConverter;

    @PostMapping
    public ResponseEntity<String> save(@RequestBody V1UserSaveRequestDto v1UserSaveRequestDto) {
        userService.save(userConverter.convertControllerSaveDtoToServiceDto(v1UserSaveRequestDto));
        return ResponseEntity.ok("User successfully saved");
    }

    @PutMapping
    public ResponseEntity<String> update(@RequestBody V1UserUpdateRequestDto v1UserUpdateRequestDto) {
        userService.update(userConverter.convertControllerUpdateDtoToServiceDto(v1UserUpdateRequestDto));
        return ResponseEntity.ok("User successfully updated");
    }

    @PostMapping("/delete/{uuid}")
    public ResponseEntity<String> delete(@PathVariable UUID uuid) {
        userService.delete(uuid);
        return ResponseEntity.ok("User successfully updated");
    }
}
