package com.cursach.dao;

import com.cursach.entity.BankAccount;
import org.hibernate.Hibernate;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BankAccountDaoImp implements BankAccountDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<BankAccount> allBankAccount() {
        return sessionFactory.getCurrentSession().createQuery("FROM BankAccount ").list();
    }

    @Override
    public void addBankAccount(BankAccount bankAccount) {
        sessionFactory.getCurrentSession().persist(bankAccount);
    }

    @Override
    public void deleteBankAccount(BankAccount bankAccount) {
        sessionFactory.getCurrentSession().delete(bankAccount);
    }

    @Override
    public void editBankAccount(BankAccount bankAccount) {
        sessionFactory.getCurrentSession().update(bankAccount);
    }

    @Override
    public BankAccount getBankAccountById(int id) {
        return sessionFactory.getCurrentSession().get(BankAccount.class, id);
    }

    @Override
    public List<BankAccount> findBankAccountByUserId(int id) {
        return sessionFactory.getCurrentSession().createQuery("FROM BankAccount WHERE userId.id = :paramName").setParameter("paramName", id).list();
    }
}
