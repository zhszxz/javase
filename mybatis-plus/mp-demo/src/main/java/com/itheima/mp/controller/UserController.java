package com.itheima.mp.controller;

import com.itheima.mp.domain.dto.PageDTO;
import com.itheima.mp.domain.query.UserQuery;
import cn.hutool.core.bean.BeanUtil;
import com.itheima.mp.domain.dto.UserFormDTO;
import com.itheima.mp.domain.po.User;
import com.itheima.mp.domain.vo.UserVO;
import com.itheima.mp.service.IUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "用户管理接口")
@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final IUserService userService;

    @ApiOperation("新增用户")
    @PostMapping
    public void saveUser(@RequestBody UserFormDTO userFormDTO) {
        User user = BeanUtil.copyProperties(userFormDTO, User.class);
        userService.save(user);
    }

    @ApiOperation("删除用户")
    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable("id") Long id) {
        userService.removeById(id);
    }

    @ApiOperation("根据id查询用户")
    @GetMapping("/{id}")
    public UserVO queryUserById(@PathVariable("id") Long id) {
        return userService.queryUserAndAddressById(id);
    }

    @ApiOperation("根据id批量查询用户")
    @GetMapping
    public List<UserVO> queryUserByIds(@RequestParam("ids") List<Long> ids) {
        return userService.queryUserAndAddressByIds(ids);
    }

    @ApiOperation("根据id扣减余额")
    @PutMapping("/{id}/deduction/{money}")
    public void deductBalanceById(@PathVariable("id") Long id, @PathVariable("money") Integer money) {
        userService.deductBalance(id, money);
    }

    @ApiOperation("根据复杂条件查询用户")
    @GetMapping("/list")
    public List<UserVO> queryUsers(UserQuery query) {
        List<User> users = userService.getUsers(query.getName(), query.getStatus(), query.getMinBalance(), query.getMaxBalance());
        return BeanUtil.copyToList(users, UserVO.class);
    }

    @ApiOperation("根据复杂条件分页查询用户")
    @GetMapping("/page")
    public PageDTO<UserVO> queryUsersPage(UserQuery query) {
        return userService.queryUsersPage(query);
    }
}
