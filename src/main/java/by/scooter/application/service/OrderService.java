package by.scooter.application.service;

import by.scooter.application.service.dto.order.OrderSaveRequestDto;
import by.scooter.application.service.dto.order.OrderUpdateRequestDto;

import java.util.UUID;

public interface OrderService {
    void save(OrderSaveRequestDto orderSaveRequestDto);

    void update(OrderUpdateRequestDto orderUpdateRequestDto);

    void delete(UUID uuid);

    void startRent(UUID userUUID, UUID scooterUUID);

    void finishRent(UUID scooterUUID, UUID orderUUID);
}
