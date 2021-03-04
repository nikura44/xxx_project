package com.xxx_project.controller;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
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
    public boolean testTwo(@RequestParam(value = "username") String username, @RequestParam(value = "password") String password,@RequestParam(value = "isAdmin") String isAdmin){
        List list =  userService.check(username,password,"1");
        if (list.isEmpty()){
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
        List list =  userService.check(username,password,"1");
        if (list.isEmpty()){
            Map<String, Object> mapP = new HashMap<>();
            mapP.put("status", 403);
            return new ResponseEntity<Map<String, Object>>(mapP, HttpStatus.OK);
        }else  {
            Map<String, Object> mapE = new HashMap<>();
            mapE.put("status", 200);
            return new ResponseEntity<Map<String, Object>>(mapE, HttpStatus.OK);
        }
    }

    @RequestMapping("/InsertNewUser")
    public boolean InsertNewUser(@RequestParam(value = "username") String username, @RequestParam(value = "password") String password, @RequestParam(value = "phone") String phone){
        System.out.println("insert new user: " + username);
        userService.InsertNewUser(username,password,phone);
        return true;
    }

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    @ResponseBody
    public String login(@RequestHeader Map<String,Object> he,@RequestBody Map<String,Object> para) throws JsonProcessingException {
        System.out.println(he);
        String username=(String)para.get("username");
        String password=(String)para.get("password");
        HashMap<String,Object> hs=new HashMap<>();
        hs.put("token","token"+username+password);
        ObjectMapper objectMapper=new ObjectMapper();
        return objectMapper.writeValueAsString(hs);
    }

    @RequestMapping(value = "/test",method = RequestMethod.GET)
    @ResponseBody
    public String test(@RequestHeader Map<String,Object> he) throws JsonProcessingException {
        System.out.println(he);
        HashMap<String,Object> hs=new HashMap<>();
        ObjectMapper objectMapper=new ObjectMapper();
        return objectMapper.writeValueAsString(hs);
    }


}
