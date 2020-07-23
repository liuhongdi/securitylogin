package com.securitylogin.demo.mapper;

import com.securitylogin.demo.pojo.SysRole;
import com.securitylogin.demo.pojo.SysUser;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
@Mapper
public interface UserMapper {
    public SysUser selectOneUserByUserName(String username);
}