package by.scooter.application.controller.v1;

import by.scooter.application.controller.conventer.v1.V1ModelConverter;
import by.scooter.application.controller.dto.v1.model.V1ModelSaveRequestDto;
import by.scooter.application.controller.dto.v1.model.V1ModelUpdateRequestDto;
import by.scooter.application.service.ModelService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/api/v1/model")
public class V1ModelController {
    private final ModelService modelService;

    private final V1ModelConverter modelConverter;

    @PostMapping
    public ResponseEntity<String> save(@RequestBody V1ModelSaveRequestDto v1ModelSaveRequestDto) {
        modelService.save(modelConverter.convertControllerSaveDtoToServiceDto(v1ModelSaveRequestDto));
        return ResponseEntity.ok("Model successfully saved!");
    }

    @PutMapping
    public ResponseEntity<String> update(@RequestBody V1ModelUpdateRequestDto v1ModelUpdateRequestDto) {
        modelService.update(modelConverter.convertControllerUpdateDtoToServiceDto(v1ModelUpdateRequestDto));
        log.info("Model successfully saved");
        return ResponseEntity.ok("Model successfully updated!");
    }
}
