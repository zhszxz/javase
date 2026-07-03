package com.bistu.test;

import com.bistu.Mapper.BrandMapper;
import com.bistu.pojo.Brand;
import org.apache.ibatis.executor.statement.RoutingStatementHandler;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;

public class mybatisTest {
    @Test
    public void testselectAll() throws IOException {
        //加载mybatis核心配置文件。获取SqlSessionFactory对象
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession sqlSession = sqlSessionFactory.openSession();
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);

        List<Brand> brands = mapper.selectAll();
        System.out.println(brands);
        sqlSession.close();
    }

    @Test
    public void testselectById() throws IOException {
        //加载mybatis核心配置文件。获取SqlSessionFactory对象
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession sqlSession = sqlSessionFactory.openSession();
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);

        Brand brand = mapper.selectById(1);
        System.out.println(brand);
        sqlSession.close();
    }

    @Test
    public void testselectByCondition() throws IOException {
        //加载mybatis核心配置文件。获取SqlSessionFactory对象
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession sqlSession = sqlSessionFactory.openSession();
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);

        //List<Brand> brands = mapper.selectByCondition(1, "%华为%", "%华为%");


       /* Brand brand = new Brand();
        brand.setStatus(1);
        brand.setCompanyName("%华为%");
        brand.setBrandName("%华为%");
        List<Brand> brands = mapper.selectByCondition(brand);*/


        HashMap<String, String> hs = new HashMap<>();
        hs.put("status","1");
        hs.put("companyName","%华为%");
        hs.put("brandName","%华为%");
        List<Brand> brands = mapper.selectByCondition(hs);


        System.out.println(brands);
        sqlSession.close();
    }

    @Test
    public void testselectByConditionSingle() throws IOException {
        //加载mybatis核心配置文件。获取SqlSessionFactory对象
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession sqlSession = sqlSessionFactory.openSession();
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);

        Brand brand = new Brand();
        //brand.setStatus(1);
        brand.setCompanyName("%华为%");
        //brand.setBrandName("%华为%");

        List<Brand> brands = mapper.selectByCondition(brand);

        System.out.println(brands);
        sqlSession.close();
    }

    @Test
    public void testadd() throws IOException {
        //加载mybatis核心配置文件。获取SqlSessionFactory对象
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //自动提交事务
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);

        Brand brand = new Brand();
        brand.setBrandName("菠萝手机");
        brand.setCompanyName("菠萝");
        brand.setDescription("美国有苹果，中国有菠萝");
        brand.setOrdered(100);
        brand.setStatus(1);

        mapper.add(brand);
        sqlSession.commit();

        System.out.println(brand.getId());
        sqlSession.close();
    }

    @Test
    public void testupdate() throws IOException {
        //加载mybatis核心配置文件。获取SqlSessionFactory对象
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //自动提交事务
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);

        //Brand brand = new Brand(7,"特斯拉","特斯拉汽车",2,"不着火就算成功",1);
        Brand brand=new Brand();
        brand.setId(6);
        brand.setStatus(0);
        int line = mapper.update(brand);
        System.out.println(line);

        sqlSession.close();
    }

    @Test
    public void testdeleteById() throws IOException {
        //加载mybatis核心配置文件。获取SqlSessionFactory对象
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //自动提交事务
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);

        Integer id=7;
        mapper.deleteById(id);

        sqlSession.close();
    }

    @Test
    public void testdeleteByIds() throws IOException {
        //加载mybatis核心配置文件。获取SqlSessionFactory对象
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //自动提交事务
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);

        Integer[] ids={1,2,6};
        mapper.deleteByIds(ids);

        sqlSession.close();
    }


}
