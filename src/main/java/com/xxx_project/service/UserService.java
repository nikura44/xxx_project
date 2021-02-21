package com.xxx_project.service;

import com.xxx_project.mapper.UserMapper;
import com.xxx_project.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    public List check(String username, String password){
        return userMapper.check(username,password);
    }
}
