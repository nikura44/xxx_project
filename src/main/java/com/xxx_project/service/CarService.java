package com.xxx_project.service;

import com.xxx_project.mapper.CarMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {
    @Autowired
    private CarMapper carMapper;

    public List showAllCars(){
        return carMapper.showAllCars();
    }

    public List selectOne(Integer cat_id){
        return carMapper.selectOne(cat_id);
    }
}
