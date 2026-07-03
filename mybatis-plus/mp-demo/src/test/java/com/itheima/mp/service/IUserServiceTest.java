package com.itheima.mp.service;

import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.itheima.mp.domain.po.User;
import com.itheima.mp.domain.po.UserInfo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class IUserServiceTest {

    @Autowired
    private IUserService userService;

    @Test
    void testSaveUser() {
        User user = new User();
        user.setUsername("Lilei");
        user.setPassword("123");
        user.setPhone("18688990012");
        user.setBalance(2000);
        user.setInfo(UserInfo.of(24, "英文老师", "female"));
        user.setCreateTime(LocalDateTime.now());
        user.setUpdateTime(LocalDateTime.now());
        userService.save(user);
    }

    @Test
    void testQuery() {
        List<User> userList = userService.listByIds(List.of(1L, 2L, 4L, 7L));
        userList.forEach(System.out::println);
    }

    @Test
    void testSaveOneByOne() {
        long b = System.currentTimeMillis();
        for (int i = 1; i <= 100000; i++) {
            userService.save(buildUser(i));
        }
        long e = System.currentTimeMillis();
        System.out.println("耗时：" + (e - b) + "ms");
    }

    @Test
    void testSaveBatch() {
        // 准备10万条数据
        List<User> list = new ArrayList<>(1000);
        long b = System.currentTimeMillis();
        for (int i = 1; i <= 100000; i++) {
            list.add(buildUser(i));
            // 每1000条批量插入一次
            if (i % 1000 == 0) {
                userService.saveBatch(list);
                list.clear();
            }
        }
        long e = System.currentTimeMillis();
        System.out.println("耗时：" + (e - b));
    }

    private User buildUser(int i) {
        User user = new User();
        user.setUsername("user_" + i);
        user.setPassword("123");
        user.setPhone("" + (18688190000L + i));
        user.setBalance(2000);
        user.setInfo(UserInfo.of(24, "英文老师", "female"));
        user.setCreateTime(LocalDateTime.now());
        user.setUpdateTime(user.getCreateTime());
        return user;
    }

    @Test
    void testPage() {
        int pageNo = 1, pageSize = 3;
        //准备分页条件
        Page<User> page = new Page<>(pageNo, pageSize);
        //添加排序规则
        page.addOrder(new OrderItem("balance", false));
        userService.page(page);
        long total = page.getTotal();
        System.out.println("total = " + total);
        long pages = page.getPages();
        System.out.println("pages = " + pages);
        List<User> users = page.getRecords();
        users.forEach(System.out::println);
    }
}
