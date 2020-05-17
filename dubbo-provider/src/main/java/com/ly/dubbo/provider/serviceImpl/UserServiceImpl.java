package com.ly.dubbo.provider.serviceImpl;

import com.alibaba.dubbo.config.annotation.Service;
import com.ly.dubbo.api.entity.User;
import com.ly.dubbo.api.service.UserServcie;
import com.ly.dubbo.provider.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service(version = "1.0.0")
public class UserServiceImpl implements UserServcie {

    @Autowired
    public UserMapper userMapper;

    @Override
    public String findUser() {
        return "张三";
    }

    @Override
    public List<User> getAllUser() {
        return userMapper.getAll();
    }
}
