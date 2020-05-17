package com.ly.dubbo.api.service;

import com.ly.dubbo.api.entity.User;

import java.util.List;

public interface UserServcie {

    String findUser();

    List<User> getAllUser();
}
