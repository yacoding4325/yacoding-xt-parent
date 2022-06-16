package com.yacoding.xt.sso.handler;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.yacoding.xt.common.login.UserThreadLocal;
import com.yacoding.xt.common.model.BusinessCodeEnum;
import com.yacoding.xt.common.model.CallResult;
import com.yacoding.xt.sso.service.TokenService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @Author yaCoding
 * @create 2022-04-19 下午 3:07
 */

@Component
@Slf4j
public class LoginInterceptor implements HandlerInterceptor {

    @Autowired
    private TokenService tokenService;

    //1.实现登录拦截器，需要登录才能访问的接口，都会被拦截
    //2.要从cookie中拿到对应的token
    //3.根据token去做对应的认证，认证通过，拿到对应的userId
    //4.通过ThreadLocal将userId放入其中，后续的接口都可以通过ThreadLocal方便地拿到用户id

    //ThreadLocal : 线程隔离的，多个线程之间，存放在ThreadLocal中的变量，不会被其他线程获取和更改
    //一个请求 就是一个线程，一个请求controller，service，domain，dao代码
    //请求完成之后，ThreadLocal 就会随线程销毁
    //相比redis缓存 好处：（1）省内存 （2）redis获取信息 需要网络连接，开销极大


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.info("-------------------login interceptor start-----------------------");
        log.info("request uri:{}",request.getRequestURI());
        log.info("request method:{}",request.getMethod());
        log.info("-------------------login interceptor end-----------------------");

        Cookie[] cookies = request.getCookies();
        if (cookies == null) {//cookies 为null就会返回Json未登录的状态
            returnJson(response);
            return false;
        }
        String token = null;
        for (Cookie cookie :cookies) {//循环cookie
            String name = cookie.getName();
            if ("t_token".equals(name)){
                token = cookie.getValue();//对token赋值
            }
        }
        if (StringUtils.isBlank(token)) {//判断是否有token
            returnJson(response);
            return false;
        }
        Long userId = tokenService.checkToken(token);
        if (userId == null) {//得到userId判断是否为空
            returnJson(response);
            return false;
        }
        UserThreadLocal.put(userId);//拿到登录认证信息userId
        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

        //用完ThreadLocal之后，其中的数据将会删除，以防止出现内存泄露
        //ThreadLocal泄露处理
        UserThreadLocal.remove();//用完就删出userId

    }

    private void returnJson(HttpServletResponse response){
        PrintWriter writer = null;
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json; charset=utf-8");
        try {
            writer = response.getWriter();
            CallResult callResult = CallResult.fail(BusinessCodeEnum.NO_LOGIN.getCode(),"您的登录已失效，请重新登录");
            writer.print(JSON.toJSONString(callResult));
        } catch (IOException e){
            e.printStackTrace();
        } finally {
            if(writer != null){
                writer.close();
            }
        }
    }
}
