package com.bistu.spring6.resourse.dao;

import org.springframework.stereotype.Repository;

@Repository(value = "myUserDao")
public class userDaoImpl implements userDao {
    @Override
    public void addUserDao() {
        System.out.println("dao...");
    }
}
