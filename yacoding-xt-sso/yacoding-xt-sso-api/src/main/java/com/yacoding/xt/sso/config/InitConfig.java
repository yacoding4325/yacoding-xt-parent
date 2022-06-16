package com.yacoding.xt.sso.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @Author yaCoding
 * @create 2022/4/9 下午 10:45
 */

//在yacoding-xt-sso-api中的config包下，扫描common中有关的配置类，使之生效
@Configuration
@ComponentScan({"com.yacoding.xt.common.wx.config","com.yacoding.xt.common.service"})

public class InitConfig {

}
