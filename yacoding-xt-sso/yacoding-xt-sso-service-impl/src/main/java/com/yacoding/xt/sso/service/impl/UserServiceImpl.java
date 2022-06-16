package com.yacoding.xt.sso.service.impl;

import com.yacoding.xt.common.model.CallResult;
import com.yacoding.xt.common.service.AbstractTemplateAction;
import com.yacoding.xt.sso.model.params.UserParam;
import com.yacoding.xt.sso.domain.UserDomain;
import com.yacoding.xt.sso.domain.repository.UserDomainRepository;
import com.yacoding.xt.sso.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author yaCoding
 * @create 2022-04-23 下午 10:48
 */

@Service
public class UserServiceImpl extends AbstractService implements UserService {

    @Autowired
    private UserDomainRepository userDomainRepository;

    @Override
    public CallResult userInfo() {
        UserDomain userDomain = userDomainRepository.createDomain(new UserParam());
        return this.serviceTemplate.executeQuery(new AbstractTemplateAction<Object>() {
            @Override
            public CallResult<Object> doAction() {
                return userDomain.userInfo();
            }
        });
    }
}
