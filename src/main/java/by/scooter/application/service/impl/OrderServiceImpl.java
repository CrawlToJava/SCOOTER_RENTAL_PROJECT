package by.scooter.application.service.impl;

import by.scooter.application.entity.Order;
import by.scooter.application.exception.NoDataFoundException;
import by.scooter.application.repository.OrderRepository;
import by.scooter.application.service.OrderService;
import by.scooter.application.service.conventer.OrderConverter;
import by.scooter.application.service.dto.order.OrderSaveRequestDto;
import by.scooter.application.service.dto.order.OrderUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.UUID;

import static by.scooter.application.entity.OrderStatus.DELETE;

@Service
@RequiredArgsConstructor
@Slf4j
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;

    private final OrderConverter orderConverter;

    @Override
    @Transactional
    public void save(OrderSaveRequestDto orderSaveRequestDto) {
        Order orderToSave = orderConverter.convertSaveDtoRequestDtoToEntity(orderSaveRequestDto);
        orderToSave.setOrderedAt(LocalDateTime.now());
        orderRepository.save(orderToSave);
        log.info("Order successfully saved");
    }

    @Override
    @Transactional
    public void update(OrderUpdateRequestDto orderUpdateRequestDto) {
        getByUUID(orderUpdateRequestDto.getUuid());
        orderRepository.save(orderConverter.convertUpdateDtoRequestDtoToEntity(orderUpdateRequestDto));
        log.info("Order successfully updated");
    }

    @Override
    @Transactional
    public void delete(UUID uuid) {
        Order orderFromDB = getByUUID(uuid);
        orderFromDB.setOrderStatus(DELETE);
        orderRepository.save(orderFromDB);
        log.info("Order successfully deleted");
    }

    @Override
    public void startOrder(UUID userUUID, UUID scooterUUID) {

    }

    @Override
    public void finishOrder(UUID scooterUUID, UUID orderUUID) {

    }

    private Order getByUUID(UUID orderUUID) {
        return orderRepository.findByUuid(orderUUID).orElseThrow(() -> new NoDataFoundException("Order was not found by " + orderUUID + " uuid"));
    }
}
