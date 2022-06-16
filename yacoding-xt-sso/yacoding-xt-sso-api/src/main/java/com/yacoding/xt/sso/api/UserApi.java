package com.yacoding.xt.sso.api;

import com.yacoding.xt.common.model.CallResult;
import com.yacoding.xt.sso.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @Author yaCoding
 * @create 2022-04-19 下午 4:17
 */

@RestController
@RequestMapping("user")
public class UserApi {

    @Autowired
    private UserService userService;
    // user/userInfo

    @PostMapping("userInfo")
    public CallResult userInfo(){
        return userService.userInfo();
    }

}