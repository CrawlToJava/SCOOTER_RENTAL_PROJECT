package by.scooter.application.service.dto.model;

import lombok.Data;

import java.util.UUID;

@Data
public class ModelResponseDto {
    private UUID uuid;

    private String brand;

    private String model;

    private int year;

    private double maxLoad;

    private double range;

    private double power;
}
