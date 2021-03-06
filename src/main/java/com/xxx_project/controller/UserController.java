package com.xxx_project.controller;

import com.alibaba.fastjson.JSONObject;
import com.xxx_project.pojo.User;
import com.xxx_project.service.UserService;
import com.xxx_project.util.JwtUtil;
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
    private JwtUtil jwtUtilService;

    @Autowired
    @Qualifier("commonDataSource")
    private DataSource dataSource;

    @RequestMapping("/check")
    public String check(){
        User user = (User) userService.select("5");
        if (user == null){
            return "err";
        }
        return user.toString();
    }
//    @RequestMapping("/check")
//    public boolean testTwo(@RequestParam(value = "username") String username, @RequestParam(value = "password") String password,@RequestParam(value = "isAdmin") String isAdmin){
//        List list =  userService.check(username,password,"1");
//        if (list.isEmpty()){
//            return false;
//        }
//        return true;
//    }
//
//    @RequestMapping("/sec")
//    public ResponseEntity<Map<String, Object>> hello(@RequestBody Map<String, String> maps) {
//        System.out.println("dd");
//        System.out.println(JSONObject.toJSONString(maps));
//        String username = maps.get("username");
//        String password = maps.get("password");
//        List list =  userService.check(username,password,"1");
//        if (list.isEmpty()){
//            Map<String, Object> mapP = new HashMap<>();
//            mapP.put("status", 403);
//            return new ResponseEntity<Map<String, Object>>(mapP, HttpStatus.OK);
//        }else  {
//            Map<String, Object> mapE = new HashMap<>();
//            mapE.put("status", 200);
//            String token = jwtUtilService.token(username,password);
//            mapE.put("token",token);
//            mapE.put("tk","nico");
//            return new ResponseEntity<Map<String, Object>>(mapE, HttpStatus.OK);
//        }
//    }
//
//    @RequestMapping("/checkToken")
//    public ResponseEntity<Map<String, Object>> checkToken(@RequestBody Map<String, String> maps){
//        String Token = maps.get("token");
//        boolean isOK = jwtUtilService.verify(Token);
//        Map<String, Object> res = new HashMap<>();
//        if (isOK){
//            res.put("status", 200);
//            res.put("check",true);
//        }else {
//            res.put("status", 403);
//            res.put("check",false);
//        }
//        return new ResponseEntity<Map<String, Object>>(res, HttpStatus.OK);
//    }
//
//    @RequestMapping("/InsertNewUser")
//    public boolean InsertNewUser(@RequestParam(value = "username") String username, @RequestParam(value = "password") String password, @RequestParam(value = "phone") String phone){
//        System.out.println("insert new user: " + username);
//        userService.InsertNewUser(username,password,phone);
//        return true;
//    }
}
