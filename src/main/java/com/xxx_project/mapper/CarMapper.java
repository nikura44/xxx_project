package com.xxx_project.mapper;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarMapper {
    List showAllCars();
    List selectOne(@Param("car_id") Integer car_id);
}
