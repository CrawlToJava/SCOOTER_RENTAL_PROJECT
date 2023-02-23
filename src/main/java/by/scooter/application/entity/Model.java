package by.scooter.application.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Model extends BaseEntity {

    private String brand;

    private String model;

    private int year;

    private double maxLoad;

    private double range;

    private double power;
}
