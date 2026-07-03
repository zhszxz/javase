package com.bistu.spring6iocxml.auto.service;

import com.bistu.spring6iocxml.auto.dao.UserDao;
import com.bistu.spring6iocxml.auto.dao.UserDaoImpl;

public class UserServiceImpl implements UserService{
    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void addUserService() {
        System.out.println("addUserService执行了.。。。");
        userDao.addUserDao();
    }
}
