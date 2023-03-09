package by.scooter.application.controller.v1;

import by.scooter.application.controller.conventer.v1.V1OrderConverter;
import by.scooter.application.controller.dto.v1.order.V1OrderSaveRequestDto;
import by.scooter.application.controller.dto.v1.order.V1OrderUpdateRequestDto;
import by.scooter.application.service.OrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/api/v1/order")
public class V1OrderController {
    private final OrderService orderService;

    private final V1OrderConverter orderConverter;

    @PostMapping
    public ResponseEntity<String> save(@RequestBody V1OrderSaveRequestDto v1OrderSaveRequestDto) {
        orderService.save(orderConverter.convertControllerSaveDtoToServiceDto(v1OrderSaveRequestDto));
        return ResponseEntity.ok("Order successfully saved");
    }

    @PutMapping
    public ResponseEntity<String> update(@RequestBody V1OrderUpdateRequestDto v1OrderUpdateRequestDto) {
        orderService.update(orderConverter.convertControllerUpdateDtoToServiceDto(v1OrderUpdateRequestDto));
        return ResponseEntity.ok("Order successfully updated");
    }

    @PostMapping("/delete/{uuid}")
    public ResponseEntity<String> delete(@PathVariable UUID uuid) {
        orderService.delete(uuid);
        return ResponseEntity.ok("Order successfully deleted");
    }

    @PostMapping("/start-rent")
    public ResponseEntity<String> startRent(@RequestParam UUID userUUID
            , @RequestParam UUID scooterUUID) {
        orderService.startRent(userUUID, scooterUUID);
        return ResponseEntity.ok("Rent successfully started");
    }

    @PostMapping("/finish-rent")
    public ResponseEntity<String> finishRent(@RequestParam UUID scooterUUID
            , @RequestParam UUID orderUUID) {
        orderService.finishRent(scooterUUID, orderUUID);
        return ResponseEntity.ok("Rent successfully finished");
    }
}
