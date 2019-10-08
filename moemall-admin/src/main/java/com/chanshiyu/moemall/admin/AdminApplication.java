package com.chanshiyu.moemall.admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication(scanBasePackages = "com.chanshiyu.moemall")
//@EnableDiscoveryClient
@MapperScan(basePackages = "com.chanshiyu.moemall.mbg.mapper")
public class AdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(AdminApplication.class, args);
    }

}