package com.example.webdemo.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.webdemo.entity.SysUser;
import com.example.webdemo.mapper.SysUserMapper;
import com.example.webdemo.service.SysUserService;
/**
* Description:
* @Author xiesn
* @Create 2023/4/22 19:12
*/
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements SysUserService{

    @Override
    public SysUser getUserByUsername(String username) {
        SysUser sysUser = this.getOne(Wrappers.<SysUser>lambdaQuery().eq(SysUser::getUsername, username));
        return sysUser;
    }
}
