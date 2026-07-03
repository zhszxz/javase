package com.itheima.mp.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.itheima.mp.domain.po.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * mp会将传给BaseMapper的实体类：
 * 类名驼峰转下划线作为表名
 * 名为id的字段作为主键
 * 变量名驼峰转下划线作为表的字段名
 */
public interface UserMapper extends BaseMapper<User> {
    void updateBalanceByIds(@Param("ew") QueryWrapper<User> wrapper, @Param("amount") int amount);

    @Update("update user set balance=balance-#{money} WHERE ID=#{id}")
    void deductBalanceById(@Param("id") Long id, @Param("money") Integer money);
}
