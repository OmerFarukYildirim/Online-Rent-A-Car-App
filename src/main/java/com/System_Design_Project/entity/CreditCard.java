package com.System_Design_Project.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "credit_cards_table")
public class CreditCard {

    @Id
    @Column(name = "credit_card_id", length = 20)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long creditCardId;


    @Column(name = "expire_month", length = 255)
    private int expireMonth;
    @Column(name = "expire_year", length = 255)
    private int expireYear;

    @Column(name = "cvv", length = 255)
    private int cvv;

    @Column(name = "cardnumber", length = 255, unique = true)
    private String cardNumber;

    @Column(name = "money", length = 255)
    private Double money;


    public CreditCard(Long creditCardId, int expireMonth, int expireYear, int cvv, String cardNumber, Double money) {
        this.creditCardId = creditCardId;
        this.expireMonth = expireMonth;
        this.expireYear = expireYear;
        this.cvv = cvv;
        this.cardNumber = cardNumber;
        this.money = money;
    }

    public CreditCard() {
    }
}
