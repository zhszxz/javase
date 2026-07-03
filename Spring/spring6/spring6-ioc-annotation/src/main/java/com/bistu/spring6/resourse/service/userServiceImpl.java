package com.bistu.spring6.resourse.service;

import com.bistu.spring6.resourse.dao.userDao;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "myUserService")
public class userServiceImpl implements userService {
    //service注入dao，不指定名字，根据属性名进行注入
    @Resource
    private userDao myUserDao;
    @Override
    public void addUserService() {
        System.out.println("service...");
        myUserDao.addUserDao();
    }
}
