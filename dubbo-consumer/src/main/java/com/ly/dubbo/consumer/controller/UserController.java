package com.ly.dubbo.consumer.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.ly.dubbo.api.entity.User;
import com.ly.dubbo.api.service.UserServcie;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Reference
    private UserServcie userServcie;

    @RequestMapping(value = "/finUser")
    public User findUser(){
        return userServcie.getUser();
    }
}
