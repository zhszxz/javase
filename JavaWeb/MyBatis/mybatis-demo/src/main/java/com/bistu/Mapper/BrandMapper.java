package com.bistu.Mapper;

import com.bistu.pojo.Brand;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface BrandMapper {
    List<Brand> selectAll();
    Brand selectById(int id);
    //条件查询
    //1.散装参数：需要用param注解表示参数与sql语句占位符的对应关系
    List<Brand> selectByCondition(@Param("status") int status,@Param("companyName") String companyName,@Param("brandName") String brandName);
    //2.封装对象：需要对象字段名与sql占位符名一致
    List<Brand> selectByCondition(Brand brand);
    //3.Map集合：键要与sql占位符对应
    List<Brand> selectByCondition(Map<String,String> hs);
    List<Brand> selectByConditionSingle(Brand brand);
    void add(Brand brand);

    int update(Brand brand);

    void deleteById(Integer id);
    void deleteByIds(Integer[] ids);

}
