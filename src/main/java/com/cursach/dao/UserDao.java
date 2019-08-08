package com.cursach.dao;

import com.cursach.entity.User;

import java.util.List;

public interface UserDao {
    List<User> allUser();
    void add(User users);
    void delete(User users);
    void edit(User users);
    User getById(int id);
    User findUserByUsername(String username);


    User findUserByActivationCode(String code);
}
