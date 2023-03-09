package by.scooter.application.controller.v1;

import by.scooter.application.controller.conventer.v1.V1ScooterConverter;
import by.scooter.application.controller.dto.v1.scooter.V1ScooterSaveRequestDto;
import by.scooter.application.controller.dto.v1.scooter.V1ScooterUpdateRequestDto;
import by.scooter.application.service.ScooterService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/api/v1/scooter")
public class V1ScooterController {
    private final ScooterService scooterService;

    private final V1ScooterConverter scooterConverter;

    @PostMapping
    public ResponseEntity<String> save(@RequestBody V1ScooterSaveRequestDto v1ScooterSaveRequestDto) {
        scooterService.save(scooterConverter.convertControllerSaveDtoToServiceDto(v1ScooterSaveRequestDto));
        return ResponseEntity.ok("Scooter successfully saved");
    }

    @PutMapping
    public ResponseEntity<String> update(@RequestBody V1ScooterUpdateRequestDto v1ScooterUpdateRequestDto) {
        scooterService.update(scooterConverter.convertControllerUpdateDtoToServiceDto(v1ScooterUpdateRequestDto));
        return ResponseEntity.ok("Scooter successfully updated");
    }

    @PostMapping("/delete/{uuid}")
    public ResponseEntity<String> delete(@PathVariable UUID uuid) {
        scooterService.delete(uuid);
        return ResponseEntity.ok("Scooter successfully deleted");
    }
}
