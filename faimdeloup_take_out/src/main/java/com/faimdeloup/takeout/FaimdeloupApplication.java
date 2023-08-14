package com.faimdeloup.takeout;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author Franklin
 */
@Slf4j
@SpringBootApplication
@ServletComponentScan
@EnableTransactionManagement
public class FaimdeloupApplication {
    public static void main(String[] args) {
        SpringApplication.run(FaimdeloupApplication.class, args);
        log.info("启动成功");
    }
}
