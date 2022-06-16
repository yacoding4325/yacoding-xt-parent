package com.yacoding.xt.common.wx.config;

import com.yacoding.xt.common.model.CallResult;
import lombok.Data;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.api.impl.WxMpServiceImpl;
import me.chanjar.weixin.mp.config.impl.WxMpDefaultConfigImpl;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Configuration
@Data
public class WxOpenConfig {
    //使用的配置
    @Value("${wx.open.config.appid}")
    private String loginAppid;
    @Value("${wx.open.config.secret}")
    private String loginSecret;
    @Value("${wx.open.config.csrfKey}")
    public String csrfKey;
    @Value("${wx.open.config.redirectUrl}")
    public String redirectUrl;
    @Value("${wx.open.config.scope}")
    public String scope;
    @Value("${wx.open.config.mobile.redirectUrl}")
    public String mobileRedirectUrl;
    @Value("${wx.pay.appId}")
    private String appid;
    @Value("${wx.open.config.pay.secret}")
    private String secret;

    @Bean//微信的Mp service.
    public WxMpService wxMpService() {
        WxMpService service = new WxMpServiceImpl();
        WxMpDefaultConfigImpl wxMpConfigStorage = new WxMpDefaultConfigImpl();
        wxMpConfigStorage.setAppId(loginAppid);//微信登录账号
        wxMpConfigStorage.setSecret(loginSecret);//微信登录密码
        service.setWxMpConfigStorage(wxMpConfigStorage);
        return service;
    }

//    //redirect_uri?code=CODE&state=STATE
//    @GetMapping("wxGzhLoginCallBack")
//    public String wxGzhLoginCallBack(HttpServletRequest request,
//                                     HttpServletResponse response,
//                                     String code,
//                                     String state){
//        //为了service层统一，所有的api层的参数处理 ，都放入loginParams中
//        LoginParam loginParam = new LoginParam();
//        loginParam.setCode(code);
//        loginParam.setState(state);
//        loginParam.setRequest(request);
//        //后续 登录成功之后，要生成token，提供给前端，把token放入对应的cookie
//        // response.addCookie();
//        loginParam.setResponse(response);
//        CallResult callResult = loginService.wxGzhLoginCallBack(loginParam);
//        if (callResult.isSuccess()){
//            return "redirect:http://a4tuaki.nat.ipyingshe.com/course";
//        }else{
//            return "redirect:http://a4tuaki.nat.ipyingshe.com";
//        }
//    }

//
    @Bean("wxMpServiceGzh")
    public WxMpService wxMpServiceGzh() {
        WxMpService service = new WxMpServiceImpl();
        WxMpDefaultConfigImpl wxMpConfigStorage = new WxMpDefaultConfigImpl();
        wxMpConfigStorage.setAppId(appid);
        wxMpConfigStorage.setSecret(secret);
        service.setWxMpConfigStorage(wxMpConfigStorage);
        return service;
    }

}