package by.scooter.application.controller.dto.v1.order;

import lombok.Data;

import java.util.UUID;

@Data
public class OrderFinishOrderDto {
    UUID scooterUUID;

    UUID orderUUID;
}
