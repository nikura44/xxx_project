package com.xxx_project.controller;

import com.xxx_project.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.sql.DataSource;
import java.util.List;

@Controller
@ResponseBody
@RequestMapping("/car")
public class CarController {
    @Autowired
    @Qualifier("commonDataSource")
    private DataSource dataSource;

    @Autowired
    private CarService carService;

    @RequestMapping("/showAllCars")
    public String showAllCars(){
        List list = carService.showAllCars();
        return list.toString();
    }

    @RequestMapping("/selectOne")
    public String selectOne(@RequestParam(value = "car_id") Integer car_id){
        List list = carService.selectOne(car_id);
        return list.toString();
    }
}
