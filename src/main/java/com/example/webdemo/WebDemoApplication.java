package com.example.webdemo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScans;
@MapperScan(basePackages = {"com.example.webdemo.mapper"})
@SpringBootApplication
public class WebDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebDemoApplication.class, args);
        System.err.println("(♥◠‿◠)ﾉﾞ  启动成功   ლ(´ڡ`ლ)ﾞ  \n");
    }

}
