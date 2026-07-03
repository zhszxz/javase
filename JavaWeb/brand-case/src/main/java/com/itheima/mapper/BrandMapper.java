package com.itheima.mapper;

import com.itheima.pojo.Brand;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface BrandMapper {
    @Select("select * from tb_brand")
    @ResultMap("brandResultMap")
    List<Brand> selectAll();

    @Insert("insert into tb_brand values (null,#{brandName},#{companyName},#{ordered},#{description},#{status})")
    void add(Brand brand);

    void deleteByIds(@Param("ids") int[] ids);
    @ResultMap("brandResultMap")
    @Select("select * from tb_brand limit #{begin},#{size}")
    List<Brand> selectByPage(@Param("begin") int begin,@Param("size") int size);
    @Select("select count(*) from tb_brand")
    int selectTotalCount();
    List<Brand> selectByPageAndCondition(@Param("begin") int begin,@Param("size") int size,@Param("brand") Brand brand);
    int selectTotalCountByCondition();

}
