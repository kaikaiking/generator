package com.king.gen;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Slite2WebSpringBootApplication
 * <p/>
 * Created by yangguanchao on 16/7/22.
 */
@EnableTransactionManagement
@MapperScan("com.king.gen.dao")
@SpringBootApplication
@EnableAutoConfiguration
public class GenWebSpringBootApplication {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(GenWebSpringBootApplication.class, args);
    }
}
