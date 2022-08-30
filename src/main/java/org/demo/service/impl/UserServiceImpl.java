package org.demo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.demo.entity.User;
import org.demo.mapper.UserMapper;
import org.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService{


    /**
     * 之前都是这么写的，但是现在 spring 的版本这样写 注解下面会有黄色波浪号
     *
     * @Autowired
     * private UserMapper userMapper;
     *
     * 推荐的方式是下面这样通过构造器注入的方式写
     */

    private final UserMapper userMapper;

    @Autowired
    public UserServiceImpl(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public User selectByAge(String age) {
        return userMapper.selectByAge(age);
    }
}
