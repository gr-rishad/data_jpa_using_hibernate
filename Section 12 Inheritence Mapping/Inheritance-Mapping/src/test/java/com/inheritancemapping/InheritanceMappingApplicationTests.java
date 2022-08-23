package com.inheritancemapping;

import com.inheritancemapping.entity.Check;
import com.inheritancemapping.entity.CreditCard;
import com.inheritancemapping.repository.PaymentRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class InheritanceMappingApplicationTests {

    private PaymentRepository paymentRepository;

    @Autowired
    public InheritanceMappingApplicationTests(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    @Test
    void contextLoads() {
    }

    @Test
    public void createPayment() {
        CreditCard creditCard = new CreditCard();
        creditCard.setId(123L);
        creditCard.setAmount(3000d);
        creditCard.setCardNumber("123321");

        paymentRepository.save(creditCard);
    }

    @Test
    public void createCheckPayment() {
        Check check = new Check();
        check.setId(124L);
        check.setAmount(4000d);
        check.setCheckNumber("456654");

        paymentRepository.save(check);
    }


}
