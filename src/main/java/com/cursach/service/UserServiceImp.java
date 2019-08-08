package com.cursach.service;


import com.cursach.dao.UserDao;
import com.cursach.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.UUID;


@Service
public class UserServiceImp implements UserService{

    @Autowired
    private UserDao userDao;


    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private SenderMailService mailService;

    @Transactional
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        User user = userDao.findUserByUsername(username);
//        UserBuilder builder = null;
//        if (user != null) {
//
//            builder = org.springframework.security.core.userdetails.User.withUsername(username);
//            builder.disabled(!user.isEnabled());
//            builder.password(user.getPassword());
//            builder.authorities(user.getAuthorities());
//        } else {
//            throw new UsernameNotFoundException("User not found.");
//        }
        return userDao.findUserByUsername(username);
    }

    @Transactional
    @Override
    public List<User> allUser() {
        return userDao.allUser();
    }

    @Transactional
    @Override
    public boolean add(User user) {
        if (userDao.findUserByUsername(user.getUsername())!= null) return false;
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setCreateTime(new Timestamp(new Date().getTime()));
        user.setEnabled(true);
        user.setActivationCode(UUID.randomUUID().toString());
        userDao.add(user);

        if (!StringUtils.isEmpty(user.getEmail())) {
            String message = String.format(
                    "Hello %s!\n " +
                            "Welcome to bank. Please visit next link, http://localhost:8080/activate/%s",
                    user.getUsername(), user.getActivationCode()
            );
            mailService.send(user.getEmail(), "Activation code", message);
        }
        return true;

        //хуйня переделать
    }

    @Transactional
    @Override
    public boolean activationUser(String code) {
        User user = userDao.findUserByActivationCode(code);
        if (user == null) {
            return false;
        }
        user.setActivationCode(null);
        userDao.add(user);
        return true;
    }

    @Transactional
    @Override
    public void delete(User user) {
        userDao.delete(user);
    }

    @Transactional
    @Override
    public void edit(User user) {
        userDao.edit(user);
    }

    @Transactional
    @Override
    public User getById(int id) {
        return userDao.getById(id);
    }

}
