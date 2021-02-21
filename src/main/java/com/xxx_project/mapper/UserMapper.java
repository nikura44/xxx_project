package com.xxx_project.mapper;

import com.xxx_project.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper {
    List check(@Param("username") String username,@Param("password") String password);
}
