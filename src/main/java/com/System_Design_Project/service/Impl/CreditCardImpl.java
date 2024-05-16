package com.System_Design_Project.service.Impl;

import com.System_Design_Project.dto.AddMoneyDTO;
import com.System_Design_Project.dto.CreditCardDTO;
import com.System_Design_Project.dto.PaymentDTO;
import com.System_Design_Project.entity.CreditCard;
import com.System_Design_Project.entity.User;
import com.System_Design_Project.repo.ICreditCardRepo;
import com.System_Design_Project.repo.IUserRepo;
import com.System_Design_Project.response.Response;
import com.System_Design_Project.service.ICreditCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CreditCardImpl implements ICreditCardService {

    @Autowired
    public ICreditCardRepo creditCardRepo;
    @Autowired
    private IUserRepo userRepo;


    /*@Override
    public Response getCreditCardInfo(CreditCardDTO creditCardDTO) {
        // kredi kartı numarasına göre databaseden kredi kartını bulur
        CreditCard creditCard1  = creditCardRepo.findCreeditCardByCardNumber(creditCardDTO.getCardNumber());
        // eğer o numaraya sahip kredi kartı varsa koşulun içine girer
        if (creditCard1 != null) {
            // kredi kartı ccv leri aynı ise koşul içine girer
            if (creditCard1.getCvv() == creditCardDTO.getCvv()) {
                // kredi kartı numarası ve ccv'e göre databaseden kredi kartını bulur
                Optional<CreditCard> creditCard = creditCardRepo.findOneByCardNumberAndCvv(creditCardDTO.getCardNumber(),
                        creditCardDTO.getCvv());
                // eğer kredi kartı numarası ve ccv'si eşleşiyorsa responseyi döndürür
                if (creditCard.isPresent()) {
                    Response moneyResponse = new Response("Kredi kartı bilgileri doğru", true);
                    moneyResponse.setData(creditCard1);
                    return moneyResponse;
                } else
                    return new Response("Kredi kartı bilgileri yanlış", false);

            } else return new Response("Cvv not match!", false);
        } else return new Response("Credit card number or Cvv not match!", false);
    }*/

    @Override
    public Response payment(PaymentDTO paymentDTO) {

        User user1 = userRepo.findUserByTelNumber(paymentDTO.getUserDTO().getTelNumber());
        if (user1.getMoney() >= paymentDTO.getAmountOfPaymentDTO().getAmountOfPayment()) {
            user1.setMoney((user1.getMoney()) - paymentDTO.getAmountOfPaymentDTO().getAmountOfPayment());
            userRepo.save(user1);
            Response paymentResponse = new Response("Ödeme başarılı", true);
            paymentResponse.setData(user1.getMoney());
            return paymentResponse;
        } else {
            Response paymentResponse = new Response("Ödeme başarısız", false);
            return paymentResponse;
        }
    }

    @Override
    public Response addMoney(AddMoneyDTO addMoneyDTO) {
        // kredi kartı numarasına göre databaseden kredi kartını bulur
        CreditCard creditCard1  = creditCardRepo.findCreeditCardByCardNumber(addMoneyDTO.getCreditCardDTO().getCardNumber());
        // eğer o numaraya sahip kredi kartı varsa koşulun içine girer
        if (creditCard1 != null) {
            // kredi kartı ccv leri aynı ise koşul içine girer
            if (creditCard1.getCvv() == addMoneyDTO.getCreditCardDTO().getCvv()) {
                // kredi kartı numarası ve ccv'e göre databaseden kredi kartını bulur
                Optional<CreditCard> creditCard = creditCardRepo.findOneByCardNumberAndCvv(addMoneyDTO.getCreditCardDTO().getCardNumber(),
                        addMoneyDTO.getCreditCardDTO().getCvv());
                // eğer kredi kartı numarası ve ccv'si eşleşiyorsa responseyi döndürür
                if (creditCard.isPresent()) {
                    User user1 = userRepo.findUserByTelNumber(addMoneyDTO.getUserDTO().getTelNumber());
                    if (creditCard1.getMoney() >= addMoneyDTO.getAmountOfPaymentDTO().getAmountOfPayment()) {
                        creditCard1.setMoney((creditCard1.getMoney()) - addMoneyDTO.getAmountOfPaymentDTO().getAmountOfPayment());
                        user1.setMoney(addMoneyDTO.getAmountOfPaymentDTO().getAmountOfPayment());
                        userRepo.save(user1);
                        creditCardRepo.save(creditCard1);
                        Response addMoneyResponse = new Response("Ödeme başarılı", true);
                        addMoneyResponse.setData(user1.getMoney());
                        return addMoneyResponse;
                    }
                } else
                    return new Response("Kredi kartı bilgileri yanlış", false);

            } else return new Response("Cvv not match!", false);
        } else return new Response("Credit card number or Cvv not match!", false);

            Response addMoneyResponse = new Response("Lütfen başka kredi kartı deneyin", false);
            return addMoneyResponse;
    }
}
