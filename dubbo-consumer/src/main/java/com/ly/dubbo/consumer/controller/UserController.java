package com.ly.dubbo.consumer.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.ly.dubbo.api.entity.User;
import com.ly.dubbo.api.service.UserServcie;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class UserController {

    @Reference(version = "1.0.0")
    private UserServcie userServcie;

    @RequestMapping(value = "/finUser")
    public String findUser(){
        return userServcie.findUser();
    }

    @RequestMapping(value = "/getAll")
    public List<User> getAll(){
        return  userServcie.getAllUser();
    }


    @RequestMapping(value = "/login/{userid}/{userName}")
    public String login(@PathVariable String userid,@PathVariable String userName){
        User user = new User();
        user.setId(userid);
        user.setUsername(userName);
        userServcie.saveUser(user);
        return  "ok";
    }

}
