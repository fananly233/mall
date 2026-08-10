package com.easy.mall;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
//@MapperScan("com.easy.mall.mapper")
@EnableCaching
public class AdminAppcalition {
    public static void main(String[] args) {
        SpringApplication.run(AdminAppcalition.class, args);
    }
}
