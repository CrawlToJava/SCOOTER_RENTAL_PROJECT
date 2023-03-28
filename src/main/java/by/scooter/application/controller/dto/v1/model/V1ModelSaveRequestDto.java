package by.scooter.application.controller.dto.v1.model;

import lombok.Data;

@Data
public class V1ModelSaveRequestDto {
    private String brand;

    private String model;

    private int year;

    private double maxLoad;

    private double range;

    private double power;
}
