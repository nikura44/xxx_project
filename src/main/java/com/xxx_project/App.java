package com.xxx_project;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@MapperScan("com.xxx_project.mapper")
public class App 
{
    public static void main( String[] args )
    {
        SpringApplication.run(App.class);
        System.out.println( "Hello World!" );
    }
}
