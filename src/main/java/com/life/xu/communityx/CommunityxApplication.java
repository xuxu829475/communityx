package com.life.xu.communityx;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.life.xu.communityx.dao")
public class CommunityxApplication {

    public static void main(String[] args) {
        SpringApplication.run(CommunityxApplication.class, args);
    }

}
