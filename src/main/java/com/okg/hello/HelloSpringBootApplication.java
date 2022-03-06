package com.okg.hello;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@MapperScan("com.okg.hello.dao.mapper")//使用MapperScan批量扫描所有的Mapper接口进行映射后放到Spring容器里面
@EnableScheduling //启动时即启动定时任务
public class HelloSpringBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(HelloSpringBootApplication.class, args);
    }

}
