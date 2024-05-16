package com.System_Design_Project.dto;

import lombok.Data;

@Data
public class UserDTO {
    private Long userId;
    private String name;
    private String surname;
    private String telNumber;
    private String password;
    private Double money = 0.0;
    private int drivingPoint = 100;
    private String drivingLicense;
}
