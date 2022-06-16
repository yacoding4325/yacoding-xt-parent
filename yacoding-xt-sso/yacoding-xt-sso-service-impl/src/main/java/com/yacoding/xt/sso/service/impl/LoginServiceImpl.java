package com.yacoding.xt.sso.service.impl;

import com.yacoding.xt.common.model.CallResult;
import com.yacoding.xt.common.service.AbstractTemplateAction;
import com.yacoding.xt.sso.model.params.LoginParam;
import com.yacoding.xt.sso.domain.LoginDomain;
import com.yacoding.xt.sso.domain.repository.LoginDomainRepository;
import com.yacoding.xt.sso.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author yaCoding
 * @create 2022-04-12 下午 3:41
 */

@Service
public class LoginServiceImpl extends AbstractService implements LoginService {

    @Autowired
    private LoginDomainRepository loginDomainRepository;

    @Override
    public CallResult getQRCodeUrl() {
        LoginDomain loginDomain = loginDomainRepository.createDomain(new LoginParam());
        return this.serviceTemplate.executeQuery(new AbstractTemplateAction<Object>(){
            @Override
            public CallResult<Object> doAction() {
                return loginDomain.buildQrConnectUrl();
            }
        });
    }


    @Override
    @Transactional
    public CallResult wxLoginCallBack(LoginParam loginParam) {

        LoginDomain loginDomain = loginDomainRepository.createDomain(loginParam);
        //带有事务的执行操作
        return this.serviceTemplate.execute(new AbstractTemplateAction<Object>(){

            @Override
            public CallResult<Object> checkBiz() {
                //检查业务参数
                return loginDomain.checkWxLoginCallBackBiz();
            }

            @Override
            public CallResult<Object> doAction() {
                //写业务逻辑的
                return loginDomain.wxLoginCallBack();
            }
        });
    }

    @Override
    public String authorize() {
        //用户通过扫码确认登录信息
        LoginDomain loginDomain = loginDomainRepository.createDomain(new LoginParam());
        return loginDomain.buildGzhUrl();
    }

    @Override
    @Transactional
    public CallResult wxGzhLoginCallBack(LoginParam loginParam) {
        LoginDomain loginDomain = loginDomainRepository.createDomain(loginParam);
        //带有事务的执行操作
        return this.serviceTemplate.execute(new AbstractTemplateAction<Object>(){

            @Override
            public CallResult<Object> checkBiz() {
                //检查业务参数
                return loginDomain.checkWxLoginCallBackBiz();
            }

            @Override
            public CallResult<Object> doAction() {
                //写业务逻辑的
                return loginDomain.wxGzhLoginCallBack();
            }
        });
    }
}