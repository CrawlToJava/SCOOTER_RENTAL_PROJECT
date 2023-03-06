package by.scooter.application.service.dto.model;

import lombok.Data;

@Data
public class ModelSaveRequestDto {
    private String brand;

    private String model;

    private int year;

    private double maxLoad;

    private double range;

    private double power;
}
