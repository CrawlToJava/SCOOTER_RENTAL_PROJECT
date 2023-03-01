package by.scooter.application.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "models")
public class Model extends BaseEntity {

    @Column(name = "brand")
    private String brand;

    @Column(name = "model")
    private String model;

    @Column(name = "year_of_issue")
    private int year;

    @Column(name = "max_load")
    private double maxLoad;

    @Column(name = "range")
    private double range;

    @Column(name = "power")
    private double power;
}
