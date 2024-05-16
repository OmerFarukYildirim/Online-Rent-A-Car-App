package com.System_Design_Project.dto;

import lombok.Data;

import java.util.Random;

@Data
public class CarDTO {

    private Long carId;
    private String type;
    private Double carPrice;
    private int carKilometer;
    Random random = new Random();
    private Double x = 28.6470 + (29.3594 - 28.6470) * random.nextDouble();
    private Double y = 40.8027 + (41.2354 - 40.8027) * random.nextDouble();
    
    private int statue;
    private int previousDriver = 0;
    private int amountOfFuel = 100;
    private Boolean isRented = false;
    private String lastServiceDateMonth;
}
