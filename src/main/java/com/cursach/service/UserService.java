package com.cursach.service;

import com.cursach.entity.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;

public interface UserService extends UserDetailsService {
    List<User> allUser();
    boolean add(User user);
    void delete(User user);
    void edit(User user);
    User getById(int id);

    @Override
    UserDetails loadUserByUsername(String s) throws UsernameNotFoundException;

    boolean activationUser(String code);
}

