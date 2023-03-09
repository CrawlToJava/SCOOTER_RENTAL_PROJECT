package by.scooter.application.controller.v1;

import by.scooter.application.controller.conventer.v1.V1RentalPointConverter;
import by.scooter.application.controller.dto.v1.rental_point.V1RentalPointSaveRequestDto;
import by.scooter.application.controller.dto.v1.rental_point.V1RentalPointUpdateRequestDto;
import by.scooter.application.service.RentalPointService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/api/v1/rental_point")
public class V1RentalPointController {
    private final RentalPointService rentalPointService;

    private final V1RentalPointConverter rentalPointConverter;

    @PostMapping
    public ResponseEntity<String> save(@RequestBody V1RentalPointSaveRequestDto v1RentalPointSaveRequestDto) {
        rentalPointService.save(rentalPointConverter.convertControllerSaveDtoToServiceDto(v1RentalPointSaveRequestDto));
        return ResponseEntity.ok("Rental point successfully saved");
    }

    @PutMapping
    public ResponseEntity<String> update(@RequestBody V1RentalPointUpdateRequestDto v1RentalPointUpdateRequestDto) {
        rentalPointService.update(rentalPointConverter.convertControllerUpdateDtoToServiceDto(v1RentalPointUpdateRequestDto));
        return ResponseEntity.ok("Rental point successfully updated");
    }

    @PostMapping("/delete/{uuid}")
    public ResponseEntity<String> delete(@PathVariable UUID uuid) {
        rentalPointService.delete(uuid);
        return ResponseEntity.ok("Rental point successfully deleted");
    }
}
