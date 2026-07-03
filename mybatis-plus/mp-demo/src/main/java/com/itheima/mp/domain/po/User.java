package com.itheima.mp.domain.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.handlers.JacksonTypeHandler;
import com.itheima.mp.enums.UserStatus;
import lombok.Data;
import org.apache.ibatis.type.TypeHandler;

import java.time.LocalDateTime;

@Data
//指定实体类对应的数据库表名
@TableName(value = "user", autoResultMap = true)
public class User {

    /**
     * 用户id
     */
    //指定主键信息和主键策略
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 用户名
     */
    /**
     * 以下场景需要使用TableField注解：
     * 成员变量名与数据库字段名不一致
     * 成员变量名以is开头，且是布尔值
     * 成员变量名与数据库关键字冲突
     * 成员变量不是数据库字段
     */
    @TableField(value = "username", exist = true)
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 注册手机号
     */
    private String phone;

    /**
     * 详细信息
     */
    @TableField(typeHandler = JacksonTypeHandler.class)
    private UserInfo info;

    /**
     * 使用状态（1正常 2冻结）
     */
    private UserStatus status;

    /**
     * 账户余额
     */
    private Integer balance;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;
}
