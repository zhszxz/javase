package com.bistu.Mapper;

import com.bistu.pojo.User;
import jdk.nashorn.internal.objects.annotations.Setter;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserMapper {

    List<User> selectAll();
    @Select("select * from tb_user where id=#{id}")
    User selectById(int id);

}
