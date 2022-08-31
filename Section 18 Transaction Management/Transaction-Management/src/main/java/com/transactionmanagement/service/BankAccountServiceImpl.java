package com.transactionmanagement.service;


import com.transactionmanagement.entity.BankAccount;
import com.transactionmanagement.repository.BankAccountRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class BankAccountServiceImpl implements BankAccountService {

    private BankAccountRepository bankAccountRepository;


    public BankAccountServiceImpl(BankAccountRepository bankAccountRepository) {
        this.bankAccountRepository = bankAccountRepository;
    }

    @Override
    @Transactional
    public void transfer(int amount) {
        Optional<BankAccount> obamasAccount = bankAccountRepository.findById(1);
        obamasAccount.get().setBal(obamasAccount.get().getBal() - amount);
        bankAccountRepository.save(obamasAccount.get());

        if (true) {
            throw new RuntimeException();
        }

        Optional<BankAccount> trumpsAccount = bankAccountRepository.findById(2);
        trumpsAccount.get().setBal(trumpsAccount.get().getBal() + amount);
        bankAccountRepository.save(trumpsAccount.get());
    }
}
