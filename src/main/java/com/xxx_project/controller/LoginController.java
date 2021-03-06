package com.xxx_project.controller;

import com.alibaba.fastjson.JSON;
import com.xxx_project.pojo.Back;
import com.xxx_project.pojo.LoginBo;
import com.xxx_project.pojo.User;

import com.xxx_project.service.UserService;
import com.xxx_project.util.JwtUtil;
import com.xxx_project.util.RedisOps;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "login")
public class LoginController {
    @Autowired
    JwtUtil jwtUtil;

    @Autowired
    UserService userService;

    @PostMapping
    @RequestMapping("/loginBo")
    public Back login(@RequestBody LoginBo loginBo) throws IOException {
        System.out.println(loginBo);
        Back back = new Back();
        String url = "https://api.weixin.qq.com/sns/jscode2session?appid=wx424ea63fa3262c17&secret=a09416ebf9091170c15b962aa9598f76&js_code="+ loginBo.getCode() +"&grant_type=authorization_code";
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url(url).build();
        Response response = client.newCall(request).execute();

        if (response.isSuccessful()){
            String body = response.body().string();
            System.out.println(body);
            String session_key = "";
            String openid = "";
            //入库，存储openId
            String token = jwtUtil.token(session_key,openid);
            RedisOps.set(token,openid);

            if (userService.select(openid)==null){
                userService.InsertNewUser(openid,"","");
                User user = new User();
                user.setOpenid(openid);
                back.setToken(token);
                back.setUser(user);

                return back;
            }else {
                User user = (User) userService.select(openid);
                back.setUser(user);
                back.setToken(token);

                return back;
            }
        }
        return back;
    }

    @PostMapping
    @RequestMapping("/loginBoWithToken")
    public Back loginTo(@RequestBody String token) throws IOException {
        Back back = new Back();
        String openid = RedisOps.get(token);
        if (openid.isEmpty()){
            return back;
        }

        User user = (User) userService.select(openid);
        back.setUser(user);
        back.setToken(token);

        return back;
    }
}
