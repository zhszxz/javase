package com.bistu.spring6.autowired.dao;

import org.springframework.stereotype.Repository;

@Repository
public class userDaoImpl implements userDao{
    @Override
    public void addUserDao() {
        System.out.println("dao...");
    }
}
