package com.System_Design_Project.service;

import com.System_Design_Project.dto.AddMoneyDTO;
import com.System_Design_Project.dto.CarDTO;
import com.System_Design_Project.dto.CreditCardDTO;
import com.System_Design_Project.dto.PaymentDTO;
import com.System_Design_Project.response.Response;

public interface ICreditCardService {
    Response payment(PaymentDTO paymentDTO);
    Response addMoney(AddMoneyDTO addMoneyDTO);
}
