package com.example.webdemo.service;

import com.example.webdemo.entity.SysMenu;
import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Description:
 *
 * @Author xiesn
 * @Create 2023/4/22 19:11
 */
public interface SysMenuService extends IService<SysMenu> {
    List<SysMenu> getSysmenuByUserId( Integer roleId);

}

