package com.System_Design_Project.controller;

import com.System_Design_Project.dto.*;
import com.System_Design_Project.response.Response;
import com.System_Design_Project.service.ICreditCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/creditCard")
public class CreditCardController {

    @Autowired
    private ICreditCardService creditCardService;

    @PutMapping("/payment")
    public ResponseEntity<?> payment(@RequestBody PaymentDTO paymentDTO) {
        Response paymentResponse = creditCardService.payment(paymentDTO);
        return ResponseEntity.ok(paymentResponse);
    }

    @PostMapping("/addMoney")
    public ResponseEntity<?> addMoneyFromProfile(@RequestBody AddMoneyDTO addMoneyDTO){
        Response addMoneyResponse = creditCardService.addMoney(addMoneyDTO);
        return ResponseEntity.ok(addMoneyResponse);
    }
}
