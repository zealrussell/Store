package com.zeal.stroe;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan
public class StroeApplication {

    public static void main(String[] args) {
        SpringApplication.run(StroeApplication.class, args);
    }


}
