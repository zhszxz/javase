package com.itheima.mp.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollUtil;
import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.extension.toolkit.Db;
import com.itheima.mp.domain.dto.PageDTO;
import com.itheima.mp.domain.po.Address;
import com.itheima.mp.domain.po.User;
import com.itheima.mp.domain.query.UserQuery;
import com.itheima.mp.domain.vo.AddressVO;
import com.itheima.mp.domain.vo.UserVO;
import com.itheima.mp.enums.UserStatus;
import com.itheima.mp.mapper.UserMapper;
import com.itheima.mp.service.IUserService;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {
    @Override
    public void deductBalance(Long id, Integer money) {
        User user = getById(id);
        if (user == null || user.getStatus() == UserStatus.FREEZE) {
            throw new RuntimeException("用户状态异常！");
        }
        if (user.getBalance() < money) {
            throw new RuntimeException("用户余额不足！");
        }
        int remainBalance = user.getBalance() - money;
        this.lambdaUpdate()
                .set(User::getBalance, remainBalance)
                .set(remainBalance == 0, User::getStatus, UserStatus.FREEZE)
                .eq(User::getId, id)
                .eq(User::getBalance, user.getBalance())
                .update();
    }

    @Override
    public List<User> getUsers(String name, Integer status, Integer minBalance, Integer maxBalance) {
        return this.lambdaQuery()
                .like(name != null, User::getUsername, name)
                .eq(status != null, User::getStatus, status)
                .ge(minBalance != null, User::getBalance, minBalance)
                .le(maxBalance != null, User::getBalance, maxBalance)
                .list();
    }

    @Override
    public UserVO queryUserAndAddressById(Long id) {
        //1.查询用户
        User user = getById(id);
        if (user == null) {
            return null;
        }
        UserVO userVO = BeanUtil.copyProperties(user, UserVO.class);
        //2.查询收货地址
        List<Address> addresses = Db.lambdaQuery(Address.class).eq(Address::getUserId, id).list();
        if (addresses != null && addresses.size() > 0) {
            userVO.setAddresses(BeanUtil.copyToList(addresses, AddressVO.class));
        }
        return userVO;
    }

    @Override
    public List<UserVO> queryUserAndAddressByIds(List<Long> ids) {
        List<User> userList = listByIds(ids);
        if (CollUtil.isEmpty(userList)) {
            return Collections.emptyList();
        }
        List<Long> userIdList = userList.stream().map(User::getId).collect(Collectors.toList());
        List<Address> addressList = Db.lambdaQuery(Address.class).in(Address::getUserId, userIdList).list();
        List<AddressVO> addressVOList = BeanUtil.copyToList(addressList, AddressVO.class);
        Map<Long, List<AddressVO>> addressMap = new HashMap<>();
        if (CollUtil.isNotEmpty(addressVOList)) {
            addressMap = addressVOList.stream().collect(Collectors.groupingBy(AddressVO::getUserId));
        }
        ArrayList<UserVO> userVOList = new ArrayList<>(userList.size());
        for (User user : userList) {
            UserVO userVO = BeanUtil.copyProperties(user, UserVO.class);
            userVO.setAddresses(addressMap.get(userVO.getId()));
            userVOList.add(userVO);
        }
        return userVOList;
    }

    @Override
    public PageDTO<UserVO> queryUsersPage(UserQuery query) {
        String name = query.getName();
        Integer status = query.getStatus();
        Integer minBalance = query.getMinBalance();
        Integer maxBalance = query.getMaxBalance();
        Page<User> page = query.toPageOrderByUpdateTimeDesc();
        lambdaQuery()
                .like(name != null, User::getUsername, name)
                .eq(status != null, User::getStatus, status)
                .ge(minBalance != null, User::getBalance, minBalance)
                .le(maxBalance != null, User::getBalance, maxBalance)
                .page(page);
        return PageDTO.of(page, UserVO.class);
    }
}
