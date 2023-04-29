package com.example.webdemo.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.webdemo.mapper.SysMenuMapper;
import com.example.webdemo.entity.SysMenu;
import com.example.webdemo.service.SysMenuService;

/**
 * Description:
 *
 * @Author xiesn
 * @Create 2023/4/22 19:11
 */
@Service
@AllArgsConstructor
public class SysMenuServiceImpl extends ServiceImpl<SysMenuMapper, SysMenu> implements SysMenuService {


    private final SysMenuMapper sysMenuMapper;
    @Override
    public List<SysMenu> getSysmenuByUserId(Integer roleId) {
        return sysMenuMapper.getSysmenuByUserId(roleId);
    }
}

