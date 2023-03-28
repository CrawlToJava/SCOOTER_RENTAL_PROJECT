package by.scooter.application.controller.conventer.v1;

import by.scooter.application.controller.dto.v1.order.V1OrderSaveRequestDto;
import by.scooter.application.controller.dto.v1.order.V1OrderUpdateRequestDto;
import by.scooter.application.service.dto.order.OrderSaveRequestDto;
import by.scooter.application.service.dto.order.OrderUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class V1OrderConverter {
    private final ModelMapper modelMapper;

    public OrderUpdateRequestDto convertControllerUpdateDtoToServiceDto(V1OrderUpdateRequestDto v1OrderUpdateRequestDto) {
        return modelMapper.map(v1OrderUpdateRequestDto, OrderUpdateRequestDto.class);
    }

    public OrderSaveRequestDto convertControllerSaveDtoToServiceDto(V1OrderSaveRequestDto v1OrderSaveRequestDto) {
        return modelMapper.map(v1OrderSaveRequestDto, OrderSaveRequestDto.class);
    }
}
