package com.ly.dubbo.provider.serviceImpl;

import com.alibaba.dubbo.config.annotation.Service;
import com.ly.dubbo.api.entity.User;
import com.ly.dubbo.api.service.UserServcie;

@Service
public class UserServiceImpl implements UserServcie {

    @Override
    public User getUser() {
        return  new User("张三");
    }
}
