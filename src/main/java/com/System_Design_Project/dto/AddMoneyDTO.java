package com.System_Design_Project.dto;

import lombok.Data;

@Data
public class AddMoneyDTO {
    AmountOfPaymentDTO amountOfPaymentDTO;
    UserDTO userDTO;
    CreditCardDTO creditCardDTO;
}
