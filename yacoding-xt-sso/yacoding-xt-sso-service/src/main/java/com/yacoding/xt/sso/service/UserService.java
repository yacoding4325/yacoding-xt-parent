package com.yacoding.xt.sso.service;

import com.yacoding.xt.common.model.CallResult;

/**
 * @Author yaCoding
 * @create 2022-04-23 下午 10:45
 */

public interface UserService {

    /**
     * 获得用户登录信息
     * @return
     */
    CallResult userInfo();

}
