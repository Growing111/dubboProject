package com.ly.dubbo.provider.serviceImpl;

import com.alibaba.dubbo.config.annotation.Service;
import com.ly.dubbo.api.entity.User;
import com.ly.dubbo.api.service.UserServcie;
import com.ly.dubbo.provider.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

import java.util.List;

@Service(version = "1.0.0")
public class UserServiceImpl implements UserServcie {



    @Autowired
    private UserMapper userMapper;

    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public User findUser(User user) {
        return userMapper.findUser(user);
    }

    @Override
    public List<User> getAllUser() {
        return userMapper.getAll();
    }

    @Override
    public void saveUser(User user) {
        redisTemplate.opsForValue().set(user.getId(), user);
    }

    @Override
    public User getUserInfo(String userId) {
        Boolean aBoolean = redisTemplate.hasKey(userId);
        ValueOperations valueOperations = redisTemplate.opsForValue();
        User user;
        if (aBoolean) {
            user = (User) valueOperations.get(userId);
            System.out.println("select by redis");
        } else {
            user = userMapper.getUserInfo(userId);
            System.out.println("select by mysql");
            if (user != null) {
                valueOperations.set(userId, user);
                System.out.println("the first select by mysql and add in redis");
            }
        }
        return user;
    }


}
