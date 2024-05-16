package com.System_Design_Project.entity;

import jakarta.persistence.*;
import lombok.Data;


@Data
@Entity
@Table(name = "car_table")
public class Car{

    @Id
    @Column(name = "car_id", length = 20)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long carId;

    @Column(name = "car_type", length = 255, unique = true)
    private String type;

    @Column(name = "car_price", length = 255)
    private Double carPrice;

    @Column(name = "car_kilometer", length = 255)
    private int carKilometer;

    @Column(name = "car_x_coordinate", length = 255)
    private Double x;

    @Column(name = "car_y_coordinate", length = 255)
    private Double y;

    @Column(name = "car_last_service", length = 255)
    private String lastServiceDateMonth;

    @Column(name = "car_statue", length = 255)
    private int statue;

    @Column(name = "car_previous_driver", length = 255)
    private int previousDriver;

    @Column(name = "car_amount_fuel", length = 255)
    private int amountOfFuel;

    @Column(name = "car_is_rented", length = 255)
    private Boolean isRented;

    public Car(Long carId, String type, Double carPrice, int carKilometer, Double x,
               Double y, String lastServiceDateMonth, int statue, int previousDriver,
               int amountOfFuel, Boolean isRented) {
        this.carId = carId;
        this.type = type;
        this.carPrice = carPrice;
        this.carKilometer = carKilometer;
        this.x = x;
        this.y = y;
        this.lastServiceDateMonth = lastServiceDateMonth;
        this.statue = statue;
        this.previousDriver = previousDriver;
        this.amountOfFuel = amountOfFuel;
        this.isRented = isRented;
    }

    public Car() {
    }
}
