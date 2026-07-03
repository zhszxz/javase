package com.bistu;

import com.bistu.Mapper.UserMapper;
import com.bistu.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MybatisDemo2 {
    public static void main(String[] args) throws IOException {
        //MyBatis代理开发

        //加载mybatis核心配置文件。获取SqlSessionFactory对象
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //获取sqlSession对象，用来执行sql语句
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //获取UserMapper接口代理对象
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        //List<User> users = mapper.selectAll();
        //System.out.println(users);
        //注解开发：完成简单sql
        User user = mapper.selectById(1);
        System.out.println(user);

        //释放资源
        sqlSession.close();
    }
}
