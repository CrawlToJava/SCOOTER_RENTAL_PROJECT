package by.scooter.application.controller.dto.v1.model;

import lombok.Data;

import java.util.UUID;

@Data
public class V1ModelUpdateRequestDto {
    private UUID uuid;

    private String brand;

    private String model;

    private int year;

    private double maxLoad;

    private double range;

    private double power;
}
