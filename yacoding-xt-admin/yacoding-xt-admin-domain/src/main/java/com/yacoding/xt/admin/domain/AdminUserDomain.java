package com.yacoding.xt.admin.domain;

import com.yacoding.xt.admin.dao.data.AdminUser;
import com.yacoding.xt.admin.domain.repository.AdminUserDomainRepository;
import com.yacoding.xt.admin.model.AdminUserModel;
import com.yacoding.xt.admin.params.AdminUserParam;
import org.springframework.beans.BeanUtils;

/**
 * @Author yaCoding
 * @create 2022-05-08 下午 6:59
 */

public class AdminUserDomain {


    private AdminUserDomainRepository adminUserDomainRepository;
    private AdminUserParam adminUserParam;

    public AdminUserDomain(AdminUserDomainRepository adminUserDomainRepository, AdminUserParam adminUserParam) {
        this.adminUserDomainRepository = adminUserDomainRepository;
        this.adminUserParam = adminUserParam;
    }

    public AdminUserModel findUserByUsername() {
        AdminUser adminUser = adminUserDomainRepository.findUserByUsername(this.adminUserParam.getUsername());
        AdminUserModel adminUserModel = new AdminUserModel();
        BeanUtils.copyProperties(adminUser,adminUserModel);
        return adminUserModel;
    }



}
