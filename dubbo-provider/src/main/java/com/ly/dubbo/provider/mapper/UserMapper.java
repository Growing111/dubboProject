package com.ly.dubbo.provider.mapper;

import com.ly.dubbo.api.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {

    List<User> getAll();

}
