package com.cursach.service;

import com.cursach.entity.BankAccount;
import org.springframework.stereotype.Service;

import java.util.List;

public interface BankAccountService {
    List<BankAccount> allBankAccount();
    void addBankAccount(BankAccount bankAccount);
    void deleteBankAccount(BankAccount bankAccount);
    void editBankAccount(BankAccount bankAccount);
    BankAccount getBankAccountById(int id);
    List<BankAccount> findBankAccountByUserId(int id);
}
