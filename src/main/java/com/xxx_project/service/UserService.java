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

    public List check(String username, String password,String isAdmin){
        return userMapper.check(username,password,isAdmin);
    }

    public void register(String account, String password,String phone,String command){
        userMapper.register(account,password,phone,command);
    }

    public List login(String account, String password){
        return userMapper.login(account,password);
    }

    public int updatePassword(String account,String password,String new_password){
        return userMapper.updatePassword(account,password,new_password);
    }

    public int updatePasswordByPhone(String account,String phone,String new_password){
        return userMapper.updatePasswordByPhone(account,phone,new_password);
    }
}
