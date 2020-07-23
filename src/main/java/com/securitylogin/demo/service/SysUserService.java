package com.securitylogin.demo.service;

import com.securitylogin.demo.pojo.SysUser;

public interface SysUserService {
    public SysUser getOneUserByUsername(String Username);
}
