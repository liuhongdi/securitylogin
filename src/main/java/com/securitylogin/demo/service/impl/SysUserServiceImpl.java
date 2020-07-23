package com.securitylogin.demo.service.impl;

import com.securitylogin.demo.mapper.UserMapper;
import com.securitylogin.demo.pojo.SysUser;
import com.securitylogin.demo.service.SysUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class SysUserServiceImpl implements SysUserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public SysUser getOneUserByUsername(String username) {
        SysUser user_one = userMapper.selectOneUserByUserName(username);
        return user_one;
    }

}
