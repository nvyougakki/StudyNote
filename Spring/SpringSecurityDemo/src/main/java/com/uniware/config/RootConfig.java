package com.uniware.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @ClassName RootConfig
 * @Description TODO
 * @Author heyu
 * @Date 2019/9/20 10:46
 */
@Configuration
@EnableTransactionManagement
@MapperScan("com.uniware.dao.mapper")
public class RootConfig {
}
