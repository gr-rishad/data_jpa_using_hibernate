package com.transactionmanagement;

import com.transactionmanagement.service.BankAccountService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TransactionManagementApplicationTests {


    private  BankAccountService bankAccountService;

    @Autowired
    public TransactionManagementApplicationTests(BankAccountService bankAccountService) {
        this.bankAccountService = bankAccountService;
    }

    @Test
    void contextLoads() {
    }

   @Test
    public void testTransfer() {
        bankAccountService.transfer(500);
    }


}
