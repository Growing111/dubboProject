package com.ly.dubbo.consumer.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.ly.dubbo.api.entity.User;
import com.ly.dubbo.api.service.UserServcie;
import com.ly.dubbo.api.utils.ResponseResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class UserController {


    @Reference(version = "1.0.0")
    private UserServcie userServcie;

    @RequestMapping(value = "/getAll")
    public List<User> getAll(){
        return  userServcie.getAllUser();
    }


    @RequestMapping(value = "/login")
    @CrossOrigin
    public ResponseResult login(@RequestBody User user){
        User user1 = userServcie.findUser(user);
        return new ResponseResult(user1);
    }

    @RequestMapping(value = "/login/getUserInfo/{userId}")
    public User getUserInfo(@PathVariable String userId){
        return  userServcie.getUserInfo(userId);
    }

}
