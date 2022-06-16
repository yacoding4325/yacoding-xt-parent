package com.yacoding.xt.sso;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Author yaCoding
 * @create 2022/4/9 下午 3:43
 */

//默认的扫包是当前包 及其子包
@SpringBootApplication
public class SSOApp {
    public static void main(String[] args) {
        SpringApplication.run(SSOApp.class, args);
    }
}
