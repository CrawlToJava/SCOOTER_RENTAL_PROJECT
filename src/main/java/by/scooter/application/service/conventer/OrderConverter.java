package by.scooter.application.service.conventer;

import by.scooter.application.entity.Order;
import by.scooter.application.service.dto.order.OrderResponseDto;
import by.scooter.application.service.dto.order.OrderSaveRequestDto;
import by.scooter.application.service.dto.order.OrderUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class OrderConverter {
    private final ModelMapper modelMapper;

    public Order convertSaveDtoRequestDtoToEntity(OrderSaveRequestDto orderSaveRequestDto) {
        return modelMapper.map(orderSaveRequestDto, Order.class);
    }

    public Order convertUpdateDtoRequestDtoToEntity(OrderUpdateRequestDto orderUpdateRequestDto) {
        return modelMapper.map(orderUpdateRequestDto, Order.class);
    }

    public OrderResponseDto convertEntityToResponseDto(Order order) {
        return modelMapper.map(order, OrderResponseDto.class);
    }
}
