package com.example.webdemo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 测试
 *
 * @author xiesn
 * @date 2022/04/08 10:03
 */

@RestController
public class HelloController {
    @GetMapping("/")
    public String hello(){
        return "发布成功";
    }
}
