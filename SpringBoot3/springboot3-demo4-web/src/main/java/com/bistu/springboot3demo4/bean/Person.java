package com.bistu.springboot3demo4.bean;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author lfy
 * @Description
 * @create 2023-04-11 20:16
 */
@JacksonXmlRootElement  // 可以写出为xml文档
@Data
//生成全参构造
@AllArgsConstructor
//生成无参构造
@NoArgsConstructor
public class Person {
    private Long id;
    private String userName;
    private String email;
    private Integer age;
    private String role;
}
