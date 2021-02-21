package com.xxx_project.controller;

import com.xxx_project.pojo.User;
import com.xxx_project.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.sql.DataSource;
import java.util.List;

@Controller
@ResponseBody
@RequestMapping("/login")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    @Qualifier("commonDataSource")
    private DataSource dataSource;

    @RequestMapping("/check")
    public boolean testTwo(@RequestParam(value = "username") String username, @RequestParam(value = "password") String password){
        List list =  userService.check(username,password);
        if (list.isEmpty()){
            return false;
        }
        return true;
    }
}
