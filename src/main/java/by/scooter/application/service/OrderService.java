package by.scooter.application.service;

import by.scooter.application.service.dto.order.OrderSaveRequestDto;
import by.scooter.application.service.dto.order.OrderUpdateRequestDto;

import java.util.UUID;

public interface OrderService {
    void save(OrderSaveRequestDto orderSaveRequestDto);

    void update(OrderUpdateRequestDto orderUpdateRequestDto);

    void delete(UUID uuid);

    void startOrder(UUID userUUID, UUID scooterUUID);

    void finishOrder(UUID scooterUUID, UUID orderUUID);
}
