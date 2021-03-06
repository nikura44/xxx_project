package com.xxx_project.util;

import com.alibaba.fastjson.JSON;
import com.xxx_project.pojo.User;
import redis.clients.jedis.Jedis;

import java.util.HashMap;
import java.util.Map;

public class RedisJava {
    public static void main(String[] args) {
//        //连接本地的 Redis 服务
//        Jedis jedis = new Jedis("localhost");
//        // 如果 Redis 服务设置来密码，需要下面这行，没有就不需要
//        // jedis.auth("123456");
//        System.out.println("连接成功");
//        //查看服务是否运行
//        System.out.println("服务正在运行: " + jedis.ping());

//        User xxx = new User();
//        xxx.setUsername("xxx");
//        xxx.setPassword("123456");
//        xxx.setIsAdmin("No");
//        RedisOps.setObject("user",xxx);
//        System.out.println("suc");

        User user = (User)RedisOps.getObject("d");
        if (user==null){
            System.out.println("suc");
        }else {
            System.out.println("...");
        }
        //System.out.println(user.toString());

//        Map map = new HashMap();
//        String token = "jwtUtil.token(session_key,openid)";
//
//
//
//
//        jedis.set(token, JSON.toJSONString(user));
//        // 获取存储的数据并输出
//        System.out.println("redis 存储的字符串为: " + jedis.get("token"));
    }
}
