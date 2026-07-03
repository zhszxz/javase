package com.bistu.service;

import com.bistu.mapper.UserMapper;
import com.bistu.pojo.User;
import com.bistu.util.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class UserService {
    SqlSessionFactory Factory = SqlSessionFactoryUtils.getSqlSessionFactory();

    public User login(String username, String password) {
        SqlSession sqlSession = Factory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.select(username, password);
        sqlSession.close();
        return user;
    }

    public boolean register(User user) {
        SqlSession sqlSession = Factory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User u = mapper.selectByUsername(user.getUsername());
        if(u==null){
            mapper.add(user);
            sqlSession.commit();
        }
        sqlSession.close();
        return u==null;
    }
}
