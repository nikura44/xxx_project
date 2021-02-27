package com.xxx_project.controller;

import com.alibaba.fastjson.JSONObject;
import com.xxx_project.pojo.User;
import com.xxx_project.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@ResponseBody
@CrossOrigin
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    @Qualifier("commonDataSource")
    private DataSource dataSource;

    @RequestMapping("/check")
    public boolean testTwo(@RequestParam(value = "username") String username, @RequestParam(value = "password") String password, @RequestParam(value = "isAdmin") String isAdmin) {
        List list = userService.check(username, password, "1");
        if (list.isEmpty()) {
            return false;
        }
        return true;
    }

    @RequestMapping("/sec")
    public ResponseEntity<Map<String, Object>> hello(@RequestBody Map<String, String> maps) {
        System.out.println("dd");
        System.out.println(JSONObject.toJSONString(maps));
        String username = maps.get("username");
        String password = maps.get("password");
        List list = userService.check(username, password, "1");
        if (list.isEmpty()) {
            Map<String, Object> mapP = new HashMap<>();
            mapP.put("status", 403);
            return new ResponseEntity<Map<String, Object>>(mapP, HttpStatus.OK);
        } else {
            Map<String, Object> mapE = new HashMap<>();
            mapE.put("status", 200);
            return new ResponseEntity<Map<String, Object>>(mapE, HttpStatus.OK);
        }
    }

    @RequestMapping("/register")
    public boolean register(@RequestParam(value = "account") String account, @RequestParam(value = "password") String password, @RequestParam(value = "phone") String phone, @RequestParam(value = "command") String command) {
        System.out.println("insert new user: " + account);
        userService.register(account, password, phone, command);
        return true;
    }

    @RequestMapping("/login")
    public boolean login(@RequestParam(value = "account") String account, @RequestParam(value = "password") String password) {
        List list = userService.login(account, password);
        if (list.isEmpty()) {
            return false;
        }
        return true;
    }

    @RequestMapping("/updatePassword")
    public boolean updatePassword(@RequestParam(value = "account") String account, @RequestParam(value = "password") String password, @RequestParam(value = "new_password") String new_password) {
        int result = userService.updatePassword(account, password, new_password);
        if (result == 0) {
            return false;
        } else {
            return true;
        }
    }

    @RequestMapping("/updatePasswordByPhone")
    public boolean updatePasswordByPhone(@RequestParam(value = "account") String account, @RequestParam(value = "phone") String phone, @RequestParam(value = "new_password") String new_password) {
        int result = userService.updatePasswordByPhone(account, phone, new_password);
        if (result == 0) {
            return false;
        } else {
            return true;
        }
    }
}
