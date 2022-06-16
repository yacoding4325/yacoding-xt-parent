package com.yacoding.xt.admin.service.impl;

import com.yacoding.xt.admin.domain.AdminUserDomain;
import com.yacoding.xt.admin.domain.repository.AdminUserDomainRepository;
import com.yacoding.xt.admin.model.AdminUserModel;
import com.yacoding.xt.admin.params.AdminUserParam;
import com.yacoding.xt.admin.service.AdminUserService;
import com.yacoding.xt.common.model.CallResult;
import com.yacoding.xt.common.service.AbstractTemplateAction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminUserServiceImpl  extends  AbstractService implements AdminUserService {

    @Autowired
    private AdminUserDomainRepository adminUserDomainRepository;

    @Override
    public AdminUserModel findUserByUsername(String username) {
        AdminUserParam adminUserParam = new AdminUserParam();
        adminUserParam.setUsername(username);
        AdminUserDomain adminUserDomain  = adminUserDomainRepository.createDomain(adminUserParam);
        return adminUserDomain.findUserByUsername();
    }
}
