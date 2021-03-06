package com.chanshiyu.moemall.admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication(scanBasePackages = "com.chanshiyu.moemall")
//@EnableDiscoveryClient
@EnableTransactionManagement
@MapperScan({ "com.chanshiyu.moemall.mbg.mapper", "com.chanshiyu.moemall.admin.dao" })
public class AdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(AdminApplication.class, args);
    }

}