package com.cursach.dao;

import com.cursach.entity.BankAccount;

import java.util.List;

public interface BankAccountDao {

    List<BankAccount> allBankAccount();
    void addBankAccount(BankAccount bankAccount);
    void deleteBankAccount(BankAccount bankAccount);
    void editBankAccount(BankAccount bankAccount);
    BankAccount getBankAccountById(int id);
    List<BankAccount> findBankAccountByUserId(int id);
}
