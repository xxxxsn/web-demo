package com.example.webdemo.service;

import com.example.webdemo.entity.SysUser;
import com.baomidou.mybatisplus.extension.service.IService;


/**
* Description:
* @Author xiesn
* @Create 2023/4/22 19:12
*/
public interface SysUserService extends IService<SysUser>{

     SysUser getUserByUsername(String username);

}
