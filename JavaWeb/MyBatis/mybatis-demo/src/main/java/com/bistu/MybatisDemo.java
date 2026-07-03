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

public class MybatisDemo {
    public static void main(String[] args) throws IOException {

        //加载mybatis核心配置文件。获取SqlSessionFactory对象
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //获取sqlSession对象，用来执行sql语句
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //执行sql语句，封装结果
        List<User> users = sqlSession.selectList("test.selectAll");
        System.out.println(users);

        //释放资源
        sqlSession.close();
    }
}
