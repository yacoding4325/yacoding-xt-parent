package com.yacoding.xt.admin.service;

import com.yacoding.xt.admin.model.AdminUserModel;

public interface AdminUserService {

    AdminUserModel findUserByUsername(String username);
}
