package com.mycom.boot3demo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class HelloController {
    @GetMapping("/hello")
    public String Hello(String a, String b){
        //打印日志
        //默认级别为info
        log.debug("debug 日志");

        log.info("info 日志...参数a={},参数b={}",a,b);
        return "Hello";
    }
}
