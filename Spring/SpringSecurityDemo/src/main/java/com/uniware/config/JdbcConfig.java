package com.uniware.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

/**
 * @ClassName JdbcConfig
 * @Description TODO
 * @Author heyu
 * @Date 2019/2/20 12:31
 */
@Configuration
public class JdbcConfig {

    @Autowired
    private DataSource dataSource;

    @Bean("jt")
    public JdbcTemplate jdbcTemplate(){
        return new JdbcTemplate(dataSource);
    }
}
