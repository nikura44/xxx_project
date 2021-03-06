package com.xxx_project.mapper;

import com.xxx_project.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper {
    List check(@Param("username") String username,@Param("password") String password,@Param("isAdmin") String isAdmin);
    void InsertNewUser(@Param("openid") String openid,@Param("picUrl") String picUrl,@Param("nickname") String nickname);
    Object select(@Param("openid") String openid);
}
