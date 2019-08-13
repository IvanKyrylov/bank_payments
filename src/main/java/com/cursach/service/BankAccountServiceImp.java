package com.cursach.service;

import com.cursach.dao.BankAccountDao;
import com.cursach.entity.BankAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Random;

@Service
public class BankAccountServiceImp implements BankAccountService {

    @Autowired
    private BankAccountDao bankAccountDao;

    @Transactional
    @Override
    public List<BankAccount> allBankAccount() {
        return bankAccountDao.allBankAccount();
    }

    @Transactional
    @Override
    public void addBankAccount(BankAccount bankAccount) {
        bankAccount.setNum(new Random().nextInt(1000000000));
        bankAccount.setCash(0);
        if(bankAccount.getType().equals("Credit")) {
            bankAccount.setCreditLimit(10000);
            bankAccount.setPercent(15);
            bankAccount.setCreateTime(new Timestamp(new Date().getTime()));
            bankAccount.setReturnTime(new Timestamp(new Date().getTime()+(86400000L*30)));
        }
        if (bankAccount.getType().equals("Deposit")) {
            bankAccount.setDeposit_rate(5);
            bankAccount.setCreateTime(new Timestamp(new Date().getTime()));
            bankAccount.setReturnTime(new Timestamp(new Date().getTime()+(86400000L*30)));
        }
        bankAccountDao.addBankAccount(bankAccount);
    }
    @Transactional
    @Override
    public void deleteBankAccount(BankAccount bankAccount) {
        bankAccountDao.deleteBankAccount(bankAccount);
    }

    @Transactional
    @Override
    public void editBankAccount(BankAccount bankAccount) {
        bankAccountDao.editBankAccount(bankAccount);
    }

    @Transactional
    @Override
    public BankAccount getBankAccountById(int id) {
        return bankAccountDao.getBankAccountById(id);
    }

    @Transactional
    @Override
    public List<BankAccount> findBankAccountByUserId(int id) {
        return bankAccountDao.findBankAccountByUserId(id);
    }
}
