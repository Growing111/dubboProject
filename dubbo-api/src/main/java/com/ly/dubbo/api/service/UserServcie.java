package com.ly.dubbo.api.service;

import com.ly.dubbo.api.entity.User;

import java.util.List;

public interface UserServcie {

    User findUser(User user);

    List<User> getAllUser();

    void saveUser(User user);

    User getUserInfo(String userId);
}
