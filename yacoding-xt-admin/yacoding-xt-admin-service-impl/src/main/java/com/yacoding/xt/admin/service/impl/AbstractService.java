package com.yacoding.xt.admin.service.impl;

import com.yacoding.xt.common.service.ServiceTemplate;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class AbstractService {

    @Autowired
    protected ServiceTemplate serviceTemplate;
}
