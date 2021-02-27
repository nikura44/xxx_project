package com.xxx_project.mapper;

import com.xxx_project.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper {
    List check(@Param("account") String account,@Param("password") String password,@Param("isAdmin") String isAdmin);
    void register(@Param("account") String account,@Param("password") String password,@Param("phone") String phone,@Param("command")String command);
    List login(@Param("account") String account,@Param("password") String password);
    int updatePassword(@Param("account") String account,@Param("password") String password,@Param("new_password") String new_password);
    int updatePasswordByPhone(@Param("account") String account,@Param("phone") String phone,@Param("new_password") String new_password);
}
