package com.yacoding.xt.sso.service;

/**
 * @Author yaCoding
 * @create 2022-04-19 下午 3:39
 */

public interface TokenService {

    /**
     * token认证
     * @param token
     * @return
     */
    Long checkToken(String token);
}
