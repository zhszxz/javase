package com.bistu.spring6.autowired.service;

import com.bistu.spring6.autowired.dao.userDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class userServiceImpl implements userService{
    @Autowired
    private userDao userDao;
    @Override
    public void addUserService() {
        System.out.println("service...");
        userDao.addUserDao();
    }
}
