package com.System_Design_Project.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "user_table")
public class User {

    @Id
    @Column(name = "user_id", length = 20)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long userId;

    @Column(name = "user_name", length = 255)
    private String name;

    @Column(name = "user_lastname", length = 255)
    private String surname;

    @Column(name = "user_tel_number", length = 255,unique = true)
    private String telNumber;

    @Column(name = "user_password", length = 255)
    private String password;

    @Column(name = "user_money", length = 255)
    private Double money;

    @Column(name = "user_driving point", length = 255)
    private int drivingPoint;

    @Column(name = "user_driving license", length = 255)
    private String drivingLicense;

    public User(Long userId, String name, String surname, String telNumber,
                   String password, Double money, int drivingPoint, String drivingLicense) {
        this.userId = userId;
        this.name = name;
        this.surname = surname;
        this.telNumber = telNumber;
        this.password = password;
        this.money = money;
        this.drivingPoint = drivingPoint;
        this.drivingLicense = drivingLicense;
    }

    public User() {
    }


}
