package com.bistu.service.impl;

import com.bistu.anno.Bean;
import com.bistu.anno.Di;
import com.bistu.dao.UserDao;
import com.bistu.service.UserService;

@Bean
public class UserServiceImpl implements UserService {
    @Di
    private UserDao userDao;
    @Override
    public void add() {
        System.out.println("service......");
        userDao.add();
    }
}
