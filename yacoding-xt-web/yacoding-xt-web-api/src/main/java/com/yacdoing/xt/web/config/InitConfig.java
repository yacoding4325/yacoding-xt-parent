package com.yacdoing.xt.web.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan({"com.yacoding.xt.common.cache","com.yacoding.xt.common.service"})
public class InitConfig {
}