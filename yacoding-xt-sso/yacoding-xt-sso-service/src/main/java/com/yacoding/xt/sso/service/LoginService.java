package com.yacoding.xt.sso.service;

import com.yacoding.xt.common.model.CallResult;
import com.yacoding.xt.sso.model.params.LoginParam;

/**
 * @Author yaCoding
 * @create 2022-04-12 下午 3:37
 */

public interface LoginService {

    /**
     * 获取微信扫码的二维码链接地址
     * @return
     */
    CallResult getQRCodeUrl();

    /**
     * 当用户扫码授权之后，进行的登录回调操作
     * @param loginParam
     * @return
     */
    CallResult wxLoginCallBack(LoginParam loginParam);

    /**
     * 公众号授权的路径
     * @return
     */
    String authorize();

    /**
     * 公众号进行授权后，进行的登录回调操作
     * @param loginParam
     * @return
     */
    CallResult wxGzhLoginCallBack(LoginParam loginParam);

}
