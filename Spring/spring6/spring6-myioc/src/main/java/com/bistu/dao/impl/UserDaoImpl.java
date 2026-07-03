package com.bistu.dao.impl;

import com.bistu.anno.Bean;
import com.bistu.dao.UserDao;

@Bean
public class UserDaoImpl implements UserDao{
    @Override
    public void add() {
        System.out.println("Dao......");
    }
}
