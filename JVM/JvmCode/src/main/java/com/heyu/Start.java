package com.heyu;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * @Author heyu
 * @Date 2021/1/21 15:31
 * @Package com.heyu
 * @Description
 **/
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class/*, HibernateJpaAutoConfiguration.class*/})
@MapperScan(basePackages = "com.heyu.luceneStudy.mapper")
public class Start {

    public static void main(String[] args) {
        SpringApplication.run(Start.class, args);
    }

}
