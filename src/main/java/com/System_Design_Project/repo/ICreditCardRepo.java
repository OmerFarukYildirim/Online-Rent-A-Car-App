package com.System_Design_Project.repo;

import com.System_Design_Project.entity.CreditCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@EnableJpaRepositories
@Repository
public interface ICreditCardRepo extends JpaRepository<CreditCard, Integer> {

    CreditCard findCreeditCardByCardNumber(String cardNumber);
    Optional<CreditCard> findOneByCardNumberAndCvv(String cardNumber, int Cvv);

}
