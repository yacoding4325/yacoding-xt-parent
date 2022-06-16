package com.yacoding.xt.sso.service.impl;

import com.yacoding.xt.common.service.ServiceTemplate;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Author yaCoding
 * @create 2022-04-13 上午 11:25
 */

public abstract class AbstractService {

    @Autowired
    protected ServiceTemplate serviceTemplate;

}
